package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class NewsPreviewMass extends BasePreviewMass {
	private MediaIdContainer mpnews;

	public NewsPreviewMass() {
		super();
	}

	public NewsPreviewMass(String msgtype, String touser, MediaIdContainer mpnews) {
		super(msgtype, touser);
		this.mpnews = mpnews;
	}

	public MediaIdContainer getMpnews() {
		return mpnews;
	}

	public void setMpnews(MediaIdContainer mpnews) {
		this.mpnews = mpnews;
	}

}
