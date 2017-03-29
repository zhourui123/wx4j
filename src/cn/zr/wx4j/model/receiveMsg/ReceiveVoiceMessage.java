package cn.zr.wx4j.model.receiveMsg;

public class ReceiveVoiceMessage extends ReceiveMessage {
	private String Format;
	private String MediaId;
	private String Recognition;

	public ReceiveVoiceMessage() {
		super();
	}

	public ReceiveVoiceMessage(Long createTime, String toUserName, String fromUserName, String msgType, String msgId,
			String format, String mediaId, String recognition) {
		super(createTime, toUserName, fromUserName, msgType, msgId);
		Format = format;
		MediaId = mediaId;
		Recognition = recognition;
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

}
