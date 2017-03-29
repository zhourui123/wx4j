package cn.zr.wx4j.model.mass.tag;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class ImageMassWithTag extends BaseMassWithTag {
	private MediaIdContainer image;

	public ImageMassWithTag() {
		super();
	}

	public ImageMassWithTag(String msgtype, MassFilter filter, MediaIdContainer image) {
		super(msgtype, filter);
		this.image = image;
	}

	public MediaIdContainer getImage() {
		return image;
	}

	public void setImage(MediaIdContainer image) {
		this.image = image;
	}
}
