package cn.zr.wx4j.test;

import java.util.Map;
import cn.zr.wx4j.model.menu.BaseButton;
import cn.zr.wx4j.model.menu.Menu;
import cn.zr.wx4j.model.menu.ViewButton;
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
import cn.zr.wx4j.model.sendMsg.TextMessage;
import cn.zr.wx4j.open.AbstractWxAdapter;
import cn.zr.wx4j.util.ButtonType;
import cn.zr.wx4j.util.MessageType;

public class WxAdapterImpl extends AbstractWxAdapter {

	private String serverName = "http://www.baidu.com";

	@Override
	public Menu initMenu() {
		System.out.println("on create menu");
		Menu m = new Menu();

		BaseButton b1 = new BaseButton();
		b1.setName("客户服务");
		ViewButton b11 = new ViewButton();
		b11.setName("订单位置查询");
		b11.setType(ButtonType.VIEW);
		b11.setUrl("SERVER_ADDRESS/queryOrder.html".replace("SERVER_ADDRESS", serverName));
		ViewButton b12 = new ViewButton();
		b12.setName("车辆位置查询");
		b12.setType(ButtonType.VIEW);
		b12.setUrl("SERVER_ADDRESS/login.jsp".replace("SERVER_ADDRESS", serverName));
		ViewButton b13 = new ViewButton();
		b13.setName("投诉");
		b13.setType(ButtonType.VIEW);
		b13.setUrl("SERVER_ADDRESS/complaint.html".replace("SERVER_ADDRESS", serverName));
		ViewButton b14 = new ViewButton();
		b14.setName("建议");
		b14.setType(ButtonType.VIEW);

		b14.setUrl("SERVER_ADDRESS/suggestion.html".replace("SERVER_ADDRESS", serverName));
		b1.setSub_button(new BaseButton[] { b11, b12, b13, b14 });

		BaseButton b2 = new BaseButton();
		b2.setName("公司信息");
		ViewButton b21 = new ViewButton();
		b21.setName("公司官网");
		b21.setType(ButtonType.VIEW);
		b21.setUrl("http://www.huapengfei.com");
		ViewButton b22 = new ViewButton();
		b22.setName("公司APP");
		b22.setType(ButtonType.VIEW);
		b22.setUrl("SERVER_ADDRESS/driverHome.html".replace("SERVER_ADDRESS", serverName));

		b2.setSub_button(new BaseButton[] { b21, b22 });

		ViewButton b3 = new ViewButton();
		b3.setName("联系我们");
		b3.setType(ButtonType.VIEW);
		b3.setUrl("SERVER_ADDRESS/collaborate.html".replace("SERVER_ADDRESS", serverName));

		m.setButton(new BaseButton[] { b1, b2, b3 });
		// return m;
		return m;
	}

	@Override
	public void onReceiveText(ReceiveTextMessage message) {

		System.out.println("onReceiveTextMessage");
		TextMessage text = new TextMessage();
		text.setContent("哈咯，这是一条文本消息");
		text.setCreateTime(System.currentTimeMillis());
		text.setFromUserName(message.getToUserName());
		text.setToUserName(message.getFromUserName());
		text.setMsgType(MessageType.TEXT);
		sendTextMessage(text);
		
		// //测试发送image 正常
		// ImageMessage img = new ImageMessage();
		// img.setCreateTime(System.currentTimeMillis());
		// img.setFromUserName(message.getToUserName());
		// img.setToUserName(message.getFromUserName());
		// img.setMsgType(MessageType.IMAGE);
		// Image i = new Image();
		// i.setMediaId("7fpHF8Shpc1twvKp7OAfFPByeottLSsyzTK5u_By5Uc");
		// img.setImage(i);
		// // 7fpHF8Shpc1twvKp7OAfFPByeottLSsyzTK5u_By5Uc
		// // oxajh0ogRHaVtzDNCiHQ4oe_CEoI
		// sendImage(img);

		// 测试发送text消息 正常
	

		// 测试添加imagematerial代码 正常
		// String imagePath =
		// getServletContext().getRealPath("/res/img/i1.jpg");
		// try {
		//
		// String mediaId = WxUtil.addPerpetualOtherMaterial(MaterialType.IMAGE,
		// imagePath);
		// System.out.println(mediaId);
		// } catch (IllegalFileNameException e) {
		// e.printStackTrace();
		// }

		// 测试添加Videomaterial代码 正常
		// String videoPath =
		// getServletContext().getRealPath("/res/video/v1.mp4");
		// try {
		//
		// String mediaId = WxUtil.addPerpetualVideoMaterial(videoPath,new
		// VideoDescription("好看的视频", "很好看很好看"));
		// System.out.println(mediaId);
		// } catch (IllegalFileNameException e) {
		// e.printStackTrace();
		// }

		// 测试获取菜单
		//System.out.println(MenuUtils.getMenu());

	}

	@Override
	public void onReceiveVoice(ReceiveVoiceMessage message) {
		System.out.println("onReceiveVoice");
		// 测试发送voice，正常
		// VoiceMessage voice = new VoiceMessage();
		// voice.setCreateTime(System.currentTimeMillis());
		// voice.setFromUserName(message.getToUserName());
		// voice.setToUserName(message.getFromUserName());
		// voice.setMsgType(MessageType.VOICE);
		// Voice v = new Voice();
		// v.setMediaId(message.getMediaId());
		// voice.setVoice(v);
		// sendVoice(voice);

	}

	@Override
	public void onReceiveImage(ReceiveImageMessage message) {
		System.out.println("onReceiveImage");

	}

	@Override
	public void onReceiveShortvideo(ReceiveShortvideoMessage message) {
		System.out.println("onReceiveShortvideo");

	}

	@Override
	public void onReceiveVideo(ReceiveVideoMessage message) {
		System.out.println("onReceiveVideo");

		// 测试发送video 正常
		// VideoMessage video = new VideoMessage();
		// video.setCreateTime(System.currentTimeMillis());
		// video.setFromUserName(message.getToUserName());
		// video.setToUserName(message.getFromUserName());
		// video.setMsgType(MessageType.VIDEO);
		// Video v = new Video();
		// v.setDescription("很好看的视频，人人都喜欢看");
		// v.setTitle("精彩视频");
		// v.setMediaId("7fpHF8Shpc1twvKp7OAfFIOV1ztRBP_zjTQXeS7lO04");
		// video.setVideo(v);
		// sendVideo(video);

	}

	@Override
	public void onReceiveLocation(ReceiveLocationMessage message) {

		System.out.println("onReceiveLocation");

	}

	@Override
	public void onReceiveLink(ReceiveLinkMessage message) {
		System.out.println("onReceiveLink");
	}

	@Override
	public void onSubscriptionEvent(ReceiveEvent event) {
		System.out.println("onSubscriptionEvent");
	}

	@Override
	public void onUnSubscriptionEvent(ReceiveEvent event) {
		System.out.println("onUnSubscriptionEvent");

	}

	@Override
	public void onScanWithSubscribeEvent(ReceiveScanEvent event) {
		System.out.println("onScanWithSubscribeEvent");

	}

	@Override
	public void onScanWithSubscribedEvent(ReceiveScanEvent event) {
		System.out.println("onScanWithSubscribedEvent");

	}

	@Override
	public void onClickMenuEvent(ReceiveClickMenuEvent event) {
		System.out.println("onClickMenuEvent");

	}

	@Override
	public void onLocationEvent(ReceiveLocationEvent event) {
		System.out.println("onLocationEvent");

	}



	@Override
	public void onLocationSelectEvent(ReceiveLocationSelectEvent event) {
		System.out.println("onLocationSelectEvent");
	}

	@Override
	public void onPicWeixinEvent(ReceivePicEvent event) {
		System.out.println("onPicWeixinEvent");
	}

	@Override
	public void onPicPhotoOrAlbumnEvent(ReceivePicEvent event) {
		System.out.println("onPicPhotoOrAlbumnEvent");
	}

	@Override
	public void onPicSysPhotoEvent(ReceivePicEvent event) {
		System.out.println("onPicSysPhotoEvent");
	}

	@Override
	public void onScanCodeWaitMsgEvent(ReceiveScanCodeEvent event) {
		System.out.println("onScanCodeWaitMsgEvent");
	}

	@Override
	public void onScanCodePushEvent(ReceiveScanCodeEvent event) {
		System.out.println("onScanCodePushEvent");
	}

	@Override
	public void onViewMenuEvent(ReceiveViewMenuEvent event) {
		System.out.println("onViewMenuEvent");
	}

	@Override
	public void onMassSendJobFinishEvent(Map<String, String> map) {
		System.out.println("onMassSendJobFinishEvent");
		map.toString();
		
	}

}
