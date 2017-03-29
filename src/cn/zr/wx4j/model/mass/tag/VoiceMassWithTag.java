package cn.zr.wx4j.model.mass.tag;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class VoiceMassWithTag extends BaseMassWithTag {
	private MediaIdContainer voice;

	public VoiceMassWithTag() {
		super();
	}

	public VoiceMassWithTag(String msgtype, MassFilter filter, MediaIdContainer voice) {
		super(msgtype, filter);
		this.voice = voice;
	}

	public MediaIdContainer getVoice() {
		return voice;
	}

	public void setVoice(MediaIdContainer voice) {
		this.voice = voice;
	}

}
