package cn.zr.wx4j.model.receiveMsg;

public class ReceiveTextMessage extends ReceiveMessage {

	private String Content;

	public ReceiveTextMessage() {
		super();
	}

	public ReceiveTextMessage(Long createTime, String toUserName, String fromUserName, String msgType, String msgId,
			String content) {
		super(createTime, toUserName, fromUserName, msgType, msgId);
		Content = content;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

}
