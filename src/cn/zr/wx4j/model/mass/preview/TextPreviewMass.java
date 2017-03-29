package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.container.ContentContainer;

public class TextPreviewMass extends BasePreviewMass {
	private ContentContainer text;

	public TextPreviewMass() {
		super();
	}

	public TextPreviewMass(String msgtype, String touser, ContentContainer text) {
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
