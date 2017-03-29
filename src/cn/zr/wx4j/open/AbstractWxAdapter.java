package cn.zr.wx4j.open;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq.weixin.mp.aes.AesException;

import cn.zr.wx4j.model.sendMsg.ImageMessage;
import cn.zr.wx4j.model.sendMsg.MusicMessage;
import cn.zr.wx4j.model.sendMsg.NewsMessage;
import cn.zr.wx4j.model.sendMsg.TextMessage;
import cn.zr.wx4j.model.sendMsg.VideoMessage;
import cn.zr.wx4j.model.sendMsg.VoiceMessage;
import cn.zr.wx4j.util.WxUtils;

public abstract class AbstractWxAdapter implements WxAdapter {

	private PrintWriter writer;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private ServletContext servletContext;

	// public WxServerAdapter(PrintWriter writer) {
	// this.writer = writer;
	//
	// }

	public HttpServletResponse getResponse() {
		return response;
	}

	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public PrintWriter getWriter() {
		return writer;
	}

	@Override
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	@Override
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public void sendTextMessage(TextMessage msg) {
		String xml = WxUtils.message2Xml(msg);
		if (WxUtils.IS_SAFE_MODE) {
			xml = encryptMsg(xml);
		}

		System.out.println("send to wx：" + xml);
		writer.write(xml);
		System.out.println("发送了一条textmessage");
	}

	public void sendNews(NewsMessage msg) {
		String xml = WxUtils.message2Xml(msg);
		if (WxUtils.IS_SAFE_MODE) {
			xml = encryptMsg(xml);
		}
		System.out.println("send to wx：" + xml);
		writer.write(xml);
		System.out.println("发送了一条news");
	}

	public void sendImage(ImageMessage msg) {
		String xml = WxUtils.message2Xml(msg);
		if (WxUtils.IS_SAFE_MODE) {
			xml = encryptMsg(xml);
		}
		System.out.println("send to wx：" + xml);
		writer.write(xml);

		System.out.println("发送了一条Image");
	}

	public void sendVoice(VoiceMessage msg) {
		String xml = WxUtils.message2Xml(msg);
		if (WxUtils.IS_SAFE_MODE) {
			xml = encryptMsg(xml);
		}
		System.out.println("send to wx：" + xml);
		writer.write(xml);
		System.out.println("发送了一条Voice");
	}

	public void sendVideo(VideoMessage msg) {
		String xml = WxUtils.message2Xml(msg);
		if (WxUtils.IS_SAFE_MODE) {
			xml = encryptMsg(xml);
		}
		writer.write(xml);
		System.out.println("send to wx：" + xml);
		System.out.println("发送了一条Video");
	}

	public void sendMusic(MusicMessage msg) {
		String xml = WxUtils.message2Xml(msg);
		if (WxUtils.IS_SAFE_MODE) {
			xml = encryptMsg(xml);
		}
		writer.write(xml);
		System.out.println("send to wx：" + xml);
		System.out.println("发送了一条Music");
	}

	@Override
	public void setWriter(PrintWriter writer) {
		this.writer = writer;
	}

	private String encryptMsg(String srcXML) {
		String result = null;
		try {
			return WxUtils.encryptMsg(WxUtils.WX_TOKEN, WxUtils.AES_KEY, WxUtils.APP_ID, srcXML,String.valueOf(System.currentTimeMillis()), "zhourdotnet");
		} catch (AesException e) {
			e.printStackTrace();
		}
		return result;

	}

}
