package cn.zr.wx4j.model.mass.tag;

import cn.zr.wx4j.model.container.ContentContainer;

public class TextMassWithTag extends BaseMassWithTag {
	private ContentContainer text;

	public TextMassWithTag() {
		super();
	}

	public TextMassWithTag(String msgtype, MassFilter filter, ContentContainer text) {
		super(msgtype, filter);
		this.text = text;
	}

	public ContentContainer getText() {
		return text;
	}

	public void setText(ContentContainer text) {
		this.text = text;
	}

}
