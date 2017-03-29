package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class ImagePreviewMass extends BasePreviewMass {
	private MediaIdContainer image;

	public ImagePreviewMass() {
		super();
	}

	public ImagePreviewMass(String msgtype, String touser, MediaIdContainer image) {
		super(msgtype, touser);
		this.image = image;
	}

	public MediaIdContainer getImage() {
		return image;
	}

	public void setImage(MediaIdContainer image) {
		this.image = image;
	}

}
