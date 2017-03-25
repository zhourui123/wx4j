package cn.zr.wx4j.model.receiveEvent;

public class ReceivePicEvent extends ReceiveEvent {
	private String EventKey;	//事件KEY值，由开发者在创建菜单时设定
	private String SendPicsInfo;	//发送的图片信息
	private String Count;	//发送的图片数量
	private String PicList;	//图片列表
	private String PicMd5Sum;	//图片的MD5值，开发者若需要，可用于验证接收到图片
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
	
	public String getEventKey() {
		return EventKey;
	}
	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
	
}
