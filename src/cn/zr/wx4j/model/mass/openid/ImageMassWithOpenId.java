package cn.zr.wx4j.model.mass.openid;

import cn.zr.wx4j.model.mass.MediaIdContainer;

public class ImageMassWithOpenId extends BaseMassWithOpenId {

	private MediaIdContainer image;

	public MediaIdContainer getImage() {
		return image;
	}

	public void setImage(MediaIdContainer image) {
		this.image = image;
	}
}
