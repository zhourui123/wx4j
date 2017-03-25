package cn.zr.wx4j.open;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import cn.zr.wx4j.model.sendMsg.ImageMessage;
import cn.zr.wx4j.model.sendMsg.MusicMessage;
import cn.zr.wx4j.model.sendMsg.NewsMessage;
import cn.zr.wx4j.model.sendMsg.TextMessage;
import cn.zr.wx4j.model.sendMsg.VideoMessage;
import cn.zr.wx4j.model.sendMsg.VoiceMessage;

public interface WxAdapter {

	public Menu initMenu();

	public void onReceiveText(ReceiveTextMessage message);

	public void onReceiveImage(ReceiveImageMessage message);

	public void onReceiveShortvideo(ReceiveShortvideoMessage message);

	public void onReceiveVideo(ReceiveVideoMessage message);

	public void onReceiveLocation(ReceiveLocationMessage message);

	public void onReceiveVoice(ReceiveVoiceMessage message);

	public void onReceiveLink(ReceiveLinkMessage message);

	public void onSubscriptionEvent(ReceiveEvent event);

	public void onUnSubscriptionEvent(ReceiveEvent event);

	public void onScanWithSubscribeEvent(ReceiveScanEvent event);

	public void onScanWithSubscribedEvent(ReceiveScanEvent event);

	public void onClickMenuEvent(ReceiveClickMenuEvent event);

	public void onLocationSelectEvent(ReceiveLocationSelectEvent event);

	public void onPicWeixinEvent(ReceivePicEvent event);

	public void onPicPhotoOrAlbumnEvent(ReceivePicEvent event);

	public void onPicSysPhotoEvent(ReceivePicEvent event);

	public void onScanCodeWaitMsgEvent(ReceiveScanCodeEvent event);

	public void onScanCodePushEvent(ReceiveScanCodeEvent event);

	public void onViewMenuEvent(ReceiveViewMenuEvent event);

	public void onLocationEvent(ReceiveLocationEvent event);
	
	public void onMassSendJobFinishEvent(Map<String,String> map);

	public void setWriter(PrintWriter writer);

	public void setRequest(HttpServletRequest request);

	public void setResponse(HttpServletResponse response);

	public void setServletContext(ServletContext servletContext);

	public void sendTextMessage(TextMessage msg);

	public void sendNews(NewsMessage msg);

	public void sendImage(ImageMessage msg);

	public void sendVoice(VoiceMessage msg);

	public void sendVideo(VideoMessage msg);

	public void sendMusic(MusicMessage msg);

}
