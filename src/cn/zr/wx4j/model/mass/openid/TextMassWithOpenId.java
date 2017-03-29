package cn.zr.wx4j.model.mass.openid;

import cn.zr.wx4j.model.container.ContentContainer;

public class TextMassWithOpenId extends BaseMassWithOpenId {

	private ContentContainer text;

	public TextMassWithOpenId() {
		super();
	}

	public TextMassWithOpenId(String msgtype, String[] touser, ContentContainer text) {
		super(msgtype, touser);
		this.text = text;
	}

	public ContentContainer getText() {
		return text;
	}

	public void setText(ContentContainer text) {
		this.text = text;
	}

}
