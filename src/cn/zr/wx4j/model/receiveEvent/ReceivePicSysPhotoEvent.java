package cn.zr.wx4j.model.receiveEvent;

public class ReceivePicSysPhotoEvent extends ReceiveEvent {
	private String EventKey;// 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String SendPicsInfo; // 发送的图片信息

	public ReceivePicSysPhotoEvent() {
		super();
	}

	public ReceivePicSysPhotoEvent(String toUserName, String fromUserName, Long createTime, String msgType,
			String event, String eventKey, String sendPicsInfo, String count, String picList, String picMd5Sum) {
		super(toUserName, fromUserName, createTime, msgType, event);
		EventKey = eventKey;
		SendPicsInfo = sendPicsInfo;
		Count = count;
		PicList = picList;
		PicMd5Sum = picMd5Sum;
	}

	public String getSendPicsInfo() {
		return SendPicsInfo;
	}

	public void setSendPicsInfo(String sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}

	public String getCount() {
		return Count;
	}

	public void setCount(String count) {
		Count = count;
	}

	public String getPicList() {
		return PicList;
	}

	public void setPicList(String picList) {
		PicList = picList;
	}

	public String getPicMd5Sum() {
		return PicMd5Sum;
	}

	public void setPicMd5Sum(String picMd5Sum) {
		PicMd5Sum = picMd5Sum;
	}

	private String Count; // 发送的图片数量
	private String PicList; // 图片列表
	private String PicMd5Sum; // 图片的MD5值，开发者若需要，可用于验证接收到图片

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
