package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.mass.MediaIdContainer;
import cn.zr.wx4j.model.mass.tag.BaseMassWithTag;

public class VideoPreviewMass extends BasePreviewMass {
	public MediaIdContainer getMpvideo() {
		return mpvideo;
	}

	public void setMpvideo(MediaIdContainer mpvideo) {
		this.mpvideo = mpvideo;
	}

	private MediaIdContainer mpvideo;
	
}
