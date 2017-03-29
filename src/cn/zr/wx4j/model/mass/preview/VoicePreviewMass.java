package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class VoicePreviewMass extends BasePreviewMass {
	private MediaIdContainer voice;

	public VoicePreviewMass() {
		super();
	}

	public VoicePreviewMass(String msgtype, String touser, MediaIdContainer voice) {
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
