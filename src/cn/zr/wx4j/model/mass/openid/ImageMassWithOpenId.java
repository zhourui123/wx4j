package cn.zr.wx4j.model.mass.openid;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class ImageMassWithOpenId extends BaseMassWithOpenId {

	private MediaIdContainer image;

	public ImageMassWithOpenId() {
		super();
	}

	public ImageMassWithOpenId(String msgtype, String[] touser, MediaIdContainer image) {
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
