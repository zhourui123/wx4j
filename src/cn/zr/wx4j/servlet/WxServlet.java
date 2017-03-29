package cn.zr.wx4j.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import com.qq.weixin.mp.aes.AesException;

import cn.zr.wx4j.model.menu.Menu;
import cn.zr.wx4j.model.receiveEvent.ReceiveClickMenuEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveLocationEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveLocationSelectEvent;
import cn.zr.wx4j.model.receiveEvent.ReceivePicEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveScanCodeEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveScanEvent;
import cn.zr.wx4j.model.receiveEvent.ReceiveViewMenuEvent;
import cn.zr.wx4j.model.receiveMsg.ReceiveImageMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveLinkMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveLocationMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveShortvideoMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveTextMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveVideoMessage;
import cn.zr.wx4j.model.receiveMsg.ReceiveVoiceMessage;
import cn.zr.wx4j.open.WxAdapter;
import cn.zr.wx4j.util.MenuUtils;
import cn.zr.wx4j.util.MessageType;
import cn.zr.wx4j.util.MyUtils;
import cn.zr.wx4j.util.WxUtils;

/**
 * Servlet implementation class WxServlet
 */
public class WxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private WxAdapter wxAdapter;

	public WxServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("---------------------");
		// 验证请求是否来自公众号
		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");
		System.out.println("signature:" + signature);
		System.out.println("timestamp:" + timestamp);
		System.out.println("nonce:" + nonce);
		System.out.println("echostr:" + echostr);
		String[] array = { WxUtils.WX_TOKEN, timestamp, nonce };
		Arrays.sort(array);
		String str = "";
		for (int i = 0; i < array.length; i++) {
			str += array[i];
		}
		System.out.println("str:" + str);
		String sign = DigestUtils.shaHex(str);
		System.out.println("sign:" + sign);
		if (signature.equals(sign)) {

			response.getWriter().write(echostr);
		}
		Menu m = wxAdapter.initMenu();
		MenuUtils.createMenu(m);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		System.out.println("---------------post request begin in wxservlet " + MyUtils.sdf.format(new Date())
				+ "-------------------");
		PrintWriter writer = response.getWriter();
		wxAdapter.setWriter(writer);
		wxAdapter.setRequest(request);
		wxAdapter.setResponse(response);
		wxAdapter.setServletContext(getServletContext());

		// Map<String, String> map = MyUtils.xml2Map(request.getInputStream());
		// for (String key : map.keySet()) {
		// System.out.print(key + ":" + map.get(key) + ",");
		// }
		// System.out.println();
		String fromXML = MyUtils.xmlInputStream2String(request.getInputStream());
		System.out.println("源xml:" + fromXML);
		if (WxUtils.IS_SAFE_MODE) {

			// 以下四个参数任何模式都可以收到
			//String signature = request.getParameter("signature");
			String timestamp = request.getParameter("timestamp");
			String nonce = request.getParameter("nonce");
			//String openid = request.getParameter("openid");
			// 以下两个参数只有在安全模式可以收到
			//String encrypt_type = request.getParameter("encrypt_type");
			String msg_signature = request.getParameter("msg_signature");
			// 开始解密
			try {
				fromXML = WxUtils.decryptMsg(WxUtils.WX_TOKEN, WxUtils.AES_KEY, WxUtils.APP_ID, msg_signature,
						timestamp, nonce, fromXML);
			} catch (AesException e) {
				e.printStackTrace();
			}
		}
		Map<String, String> map = MyUtils.xmlString2Map(fromXML);
		System.out.println("解码并转换成map后:" + map);
		//writer.write("sucess");
		//writer.flush();
		String msgType = map.get("MsgType");
		switch (msgType) {
		case MessageType.TEXT:
			onReceiveText(map);
			break;
		case MessageType.VOICE:
			onReceiveVoice(map);
			break;
		case MessageType.IMAGE:
			onReceiveImage(map);
			break;
		case MessageType.SHORTVIDEO:
			onReceiveShortvideo(map);
			break;
		case MessageType.VIDEO:
			onReceiveVideo(map);
			break;
		case MessageType.LOCATION:
			onReceiveLocation(map);
			break;
		case MessageType.EVENT:
			onReceiveEvent(map);
			break;
		case MessageType.LINK:
			onReceiveLink(map);
			break;
		default:System.out.println("无法处理该类型:"+msgType);

		}

		System.out.println("---------------request end wxservlet-------------------");

	}

	private void onReceiveEvent(Map<String, String> map) {
		String event = map.get("Event");
		String eventKey = map.get("EventKey");
		if (event.equals("subscribe") && eventKey == null) {
			ReceiveEvent e = new ReceiveEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));

			wxAdapter.onSubscriptionEvent(e);
		} else if (event.equals("unsubscribe")) {
			ReceiveEvent e = new ReceiveEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));

			wxAdapter.onUnSubscriptionEvent(e);

		} else if (event.equals("subscribe")) {
			ReceiveScanEvent e = new ReceiveScanEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setEventKey(map.get("EventKey"));
			e.setTicket(map.get("Ticket"));

			wxAdapter.onScanWithSubscribeEvent(e);

		} else if (event.equals("CLICK")) {
			ReceiveClickMenuEvent e = new ReceiveClickMenuEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setEventKey(map.get("EventKey"));

			wxAdapter.onClickMenuEvent(e);
		} else if (event.equals("SCAN")) {
			ReceiveScanEvent e = new ReceiveScanEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setEventKey(map.get("EventKey"));
			e.setTicket(map.get("Ticket"));

			wxAdapter.onScanWithSubscribedEvent(e);
		} else if (event.equals("LOCATION")) {
			ReceiveLocationEvent e = new ReceiveLocationEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setLatitude(map.get("Latitude"));
			e.setLongitude(map.get("Longitude"));
			e.setPrecision(map.get("Precision"));

			wxAdapter.onLocationEvent(e);
		} else if (event.equals("VIEW")) {
			ReceiveViewMenuEvent e = new ReceiveViewMenuEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setEventKey(map.get("EventKey"));
			e.setMenuID(map.get("MenuId"));

			wxAdapter.onViewMenuEvent(e);
		} else if (event.equals("scancode_push")) {
			ReceiveScanCodeEvent e = new ReceiveScanCodeEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setScanCodeInfo(map.get("ScanCodeInfo"));
			e.setScanResult(map.get("ScanResult"));
			e.setScanType(map.get("ScanType"));
			e.setMenuID(map.get("MenuId"));
			e.setEventKey(map.get("EventKey"));

			wxAdapter.onScanCodePushEvent(e);
		} else if (event.equals("scancode_waitmsg")) {
			ReceiveScanCodeEvent e = new ReceiveScanCodeEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setScanCodeInfo(map.get("ScanCodeInfo"));
			e.setScanResult(map.get("ScanResult"));
			e.setScanType(map.get("ScanType"));
			e.setMenuID(map.get("MenuId"));
			e.setEventKey(map.get("EventKey"));
			wxAdapter.onScanCodeWaitMsgEvent(e);
		} else if (event.equals("pic_sysphoto")) {
			ReceivePicEvent e = new ReceivePicEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setPicList(map.get("PicList"));
			e.setPicMd5Sum(map.get("PicMd5Sum"));
			e.setSendPicsInfo(map.get("SendPicsInfo"));
			e.setCount(map.get("Count"));

			wxAdapter.onPicSysPhotoEvent(e);
		} else if (event.equals("pic_photo_or_album")) {
			ReceivePicEvent e = new ReceivePicEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setPicList(map.get("PicList"));
			e.setPicMd5Sum(map.get("PicMd5Sum"));
			e.setSendPicsInfo(map.get("SendPicsInfo"));
			e.setCount(map.get("Count"));

			wxAdapter.onPicPhotoOrAlbumnEvent(e);
		} else if (event.equals("pic_weixin")) {
			ReceivePicEvent e = new ReceivePicEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setPicList(map.get("PicList"));
			e.setPicMd5Sum(map.get("PicMd5Sum"));
			e.setSendPicsInfo(map.get("SendPicsInfo"));
			e.setCount(map.get("Count"));

			wxAdapter.onPicWeixinEvent(e);
		} else if (event.equals("location_select")) {
			ReceiveLocationSelectEvent e = new ReceiveLocationSelectEvent();
			e.setCreateTime(Long.valueOf(map.get("CreateTime")));
			e.setEvent(map.get("Event"));
			e.setFromUserName(map.get("FromUserName"));
			e.setMsgType(map.get("MsgType"));
			e.setToUserName(map.get("ToUserName"));
			e.setEventKey(eventKey);
			e.setSendLocationInfo(map.get("SendLocationInfo"));
			e.setScale(map.get("Scale"));
			e.setPoiname(map.get("Poiname"));
			e.setLocation_Y(map.get("Location_Y"));
			e.setLocation_X(map.get("Location_X"));
			e.setLabel(map.get("Label"));

			wxAdapter.onLocationSelectEvent(e);
		}else if (event.equals("MASSSENDJOBFINISH")) {
			

			wxAdapter.onMassSendJobFinishEvent(map);
		}
	}

	private void onReceiveText(Map<String, String> map) {
		ReceiveTextMessage message = new ReceiveTextMessage();
		message.setContent(map.get("Content"));
		message.setCreateTime(Long.valueOf(map.get("CreateTime")));
		message.setFromUserName(map.get("FromUserName"));
		message.setToUserName(map.get("ToUserName"));
		message.setMsgId(map.get("MsgId"));
		message.setMsgType(map.get("MsgType"));

		wxAdapter.onReceiveText(message);
	}

	private void onReceiveVoice(Map<String, String> map) {
		ReceiveVoiceMessage message = new ReceiveVoiceMessage();
		message.setCreateTime(Long.valueOf(map.get("CreateTime")));
		message.setFromUserName(map.get("FromUserName"));
		message.setToUserName(map.get("ToUserName"));
		message.setMsgId(map.get("MsgId"));
		message.setMsgType(map.get("MsgType"));
		message.setFormat(map.get("Format"));
		message.setMediaId(map.get("MediaId"));
		message.setRecognition(map.get("Recognition"));
		wxAdapter.onReceiveVoice(message);
	}

	private void onReceiveVideo(Map<String, String> map) {
		ReceiveVideoMessage message = new ReceiveVideoMessage();

		message.setCreateTime(Long.valueOf(map.get("CreateTime")));
		message.setFromUserName(map.get("FromUserName"));
		message.setToUserName(map.get("ToUserName"));
		message.setMsgId(map.get("MsgId"));
		message.setMsgType(map.get("MsgType"));
		message.setMediaId(map.get("MediaId"));
		message.setThumbMediaId(map.get("ThumbMediaId"));

		wxAdapter.onReceiveVideo(message);
	}

	private void onReceiveShortvideo(Map<String, String> map) {
		ReceiveShortvideoMessage message = new ReceiveShortvideoMessage();
		message.setCreateTime(Long.valueOf(map.get("CreateTime")));
		message.setFromUserName(map.get("FromUserName"));
		message.setToUserName(map.get("ToUserName"));
		message.setMsgId(map.get("MsgId"));
		message.setMsgType(map.get("MsgType"));
		message.setMediaId(map.get("MediaId"));
		message.setThumbMediaId(map.get("ThumbMediaId"));

		wxAdapter.onReceiveShortvideo(message);
	}

	private void onReceiveLocation(Map<String, String> map) {
		ReceiveLocationMessage message = new ReceiveLocationMessage();
		message.setCreateTime(Long.valueOf(map.get("CreateTime")));
		message.setFromUserName(map.get("FromUserName"));
		message.setToUserName(map.get("ToUserName"));
		message.setMsgId(map.get("MsgId"));
		message.setMsgType(map.get("MsgType"));
		message.setLocation_X(map.get("Location_X"));
		message.setLocation_Y(map.get("Location_Y"));
		message.setLabel(map.get("Label"));
		message.setScale(map.get("Scale"));
		wxAdapter.onReceiveLocation(message);
	}

	private void onReceiveImage(Map<String, String> map) {
		ReceiveImageMessage message = new ReceiveImageMessage();
		message.setCreateTime(Long.valueOf(map.get("CreateTime")));
		message.setFromUserName(map.get("FromUserName"));
		message.setToUserName(map.get("ToUserName"));
		message.setMsgId(map.get("MsgId"));
		message.setMsgType(map.get("MsgType"));
		message.setPicUrl(map.get("PicUrl"));
		message.setMediaId(map.get("MediaId"));
		wxAdapter.onReceiveImage(message);
	}

	private void onReceiveLink(Map<String, String> map) {
		ReceiveLinkMessage message = new ReceiveLinkMessage();
		message.setCreateTime(Long.valueOf(map.get("CreateTime")));
		message.setFromUserName(map.get("FromUserName"));
		message.setToUserName(map.get("ToUserName"));
		message.setMsgId(map.get("MsgId"));
		message.setMsgType(map.get("MsgType"));
		message.setDescription(map.get("Description"));
		message.setTitle(map.get("Title"));
		message.setUrl(map.get("Url"));
		wxAdapter.onReceiveLink(message);
	}

	@Override
	public void init() throws ServletException {

		Class<?> clazz = null;
		try {
			clazz = Class.forName(WxUtils.ADAPTER_PATH);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			wxAdapter = (WxAdapter) clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		// // 如果是安全模式，使用代理
		// if (WxUtils.IS_SAFE_MODE) {
		// System.out.println("已经开启安全模式，启用代理中……");
		// wxAdapter = (WxAdapter)
		// Proxy.newProxyInstance(WxAdapter.class.getClassLoader(),
		// new Class[] { WxAdapter.class }, new
		// WxAdapterInvocationHandler(wxAdapter));
		//
		// }
		Menu m = wxAdapter.initMenu();
		MenuUtils.createMenu(m);
	}

}
