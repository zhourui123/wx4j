package cn.zr.wx4j.model.receiveMsg;

public class ReceiveShortvideoMessage extends ReceiveMessage {
	private String ThumbMediaId;
	private String MediaId;
	
	
	public String getMediaId() {
		return MediaId;
	}
	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
	public String getThumbMediaId() {
		return ThumbMediaId;
	}
	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

}
