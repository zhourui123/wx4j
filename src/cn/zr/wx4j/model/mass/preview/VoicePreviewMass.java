package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.mass.MediaIdContainer;
import cn.zr.wx4j.model.mass.tag.BaseMassWithTag;

public class VoicePreviewMass extends BasePreviewMass {
	private MediaIdContainer voice;

	public MediaIdContainer getVoice() {
		return voice;
	}

	public void setVoice(MediaIdContainer voice) {
		this.voice = voice;
	}
	
}
