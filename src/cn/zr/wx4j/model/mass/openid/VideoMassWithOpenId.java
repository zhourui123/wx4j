package cn.zr.wx4j.model.mass.openid;

import cn.zr.wx4j.model.mass.VideoMaterial;

public class VideoMassWithOpenId extends BaseMassWithOpenId {

	private VideoMaterial mpvideo;

	public VideoMassWithOpenId() {
		super();
	}

	public VideoMassWithOpenId(String msgtype, String[] touser, VideoMaterial mpvideo) {
		super(msgtype, touser);
		this.mpvideo = mpvideo;
	}

	public VideoMaterial getMpvideo() {
		return mpvideo;
	}

	public void setMpvideo(VideoMaterial mpvideo) {
		this.mpvideo = mpvideo;
	}

}
