package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class VideoPreviewMass extends BasePreviewMass {
	private MediaIdContainer mpvideo;

	public MediaIdContainer getMpvideo() {
		return mpvideo;
	}

	public void setMpvideo(MediaIdContainer mpvideo) {
		this.mpvideo = mpvideo;
	}

	public VideoPreviewMass() {
		super();
	}

	public VideoPreviewMass(String msgtype, String touser, MediaIdContainer mpvideo) {
		super(msgtype, touser);
		this.mpvideo = mpvideo;
	}

}
