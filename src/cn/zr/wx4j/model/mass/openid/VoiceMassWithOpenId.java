package cn.zr.wx4j.model.mass.openid;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class VoiceMassWithOpenId extends BaseMassWithOpenId {

	private MediaIdContainer voice;

	public VoiceMassWithOpenId() {
		super();
	}

	public VoiceMassWithOpenId(String msgtype, String[] touser, MediaIdContainer voice) {
		super(msgtype, touser);
		this.voice = voice;
	}

	public MediaIdContainer getVoice() {
		return voice;
	}

	public void setVoice(MediaIdContainer voice) {
		this.voice = voice;
	}

}
