package cn.zr.wx4j.model.sendMsg;

public class TextMessage extends BaseMessage {
	private String Content;

	public TextMessage() {
		super();
	}

	public TextMessage(String toUserName, String fromUserName, Long createTime, String msgType, String content) {
		super(toUserName, fromUserName, createTime, msgType);
		Content = content;
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		this.Content = content;
	}
}
