package cn.zr.wx4j.model.mass.tag;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class VideoMassWithTag extends BaseMassWithTag {
	private MediaIdContainer mpvideo;

	public VideoMassWithTag() {
		super();
	}

	public VideoMassWithTag(String msgtype, MassFilter filter, MediaIdContainer mpvideo) {
		super(msgtype, filter);
		this.mpvideo = mpvideo;
	}

	public MediaIdContainer getMpvideo() {
		return mpvideo;
	}

	public void setMpvideo(MediaIdContainer mpvideo) {
		this.mpvideo = mpvideo;
	}

}
