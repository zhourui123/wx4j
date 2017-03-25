package cn.zr.wx4j.model.receiveMsg;

public class ReceiveLinkMessage extends ReceiveMessage {
	private String Title; // 消息标题
	private String Description; // 消息描述
	private String Url; // 消息链接

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
