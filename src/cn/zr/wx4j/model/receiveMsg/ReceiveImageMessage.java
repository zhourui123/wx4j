package cn.zr.wx4j.model.receiveMsg;

public class ReceiveImageMessage extends ReceiveMessage {
	private String PicUrl;
	private String MediaId;

	public ReceiveImageMessage() {
		super();
	}

	public ReceiveImageMessage(Long createTime, String toUserName, String fromUserName, String msgType, String msgId,
			String picUrl, String mediaId) {
		super(createTime, toUserName, fromUserName, msgType, msgId);
		PicUrl = picUrl;
		MediaId = mediaId;
	}

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
