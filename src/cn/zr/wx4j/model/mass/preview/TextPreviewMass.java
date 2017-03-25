package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.mass.ContentContainer;
import cn.zr.wx4j.model.mass.MediaIdContainer;
import cn.zr.wx4j.model.mass.tag.BaseMassWithTag;

public class TextPreviewMass extends BasePreviewMass {
	private ContentContainer text;

	public ContentContainer getText() {
		return text;
	}

	public void setText(ContentContainer text) {
		this.text = text;
	}
	

	
}
