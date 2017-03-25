package cn.zr.wx4j.model.receiveMsg;

public class ReceiveImageMessage extends ReceiveMessage {
	private String PicUrl;
	private String MediaId;
	
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getPicUrl() {
		return PicUrl;
	}
	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	
}
