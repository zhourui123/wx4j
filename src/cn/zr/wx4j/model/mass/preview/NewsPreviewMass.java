package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.mass.MediaIdContainer;
import cn.zr.wx4j.model.mass.tag.BaseMassWithTag;

public class NewsPreviewMass extends BasePreviewMass {
	private MediaIdContainer mpnews;
	public MediaIdContainer getMpnews() {
		return mpnews;
	}

	public void setMpnews(MediaIdContainer mpnews) {
		this.mpnews = mpnews;
	}

	
}
