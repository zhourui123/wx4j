package cn.zr.wx4j.model.sendMsg;

import cn.zr.wx4j.model.container.MediaIdContainer;

public class ImageMessage extends BaseMessage {

	private MediaIdContainer Image;

	public ImageMessage() {
		super();
	}

	public ImageMessage(String toUserName, String fromUserName, Long createTime, String msgType,
			MediaIdContainer image) {
		super(toUserName, fromUserName, createTime, msgType);
		Image = image;
	}

	public MediaIdContainer getImage() {
		return Image;
	}

	public void setImage(MediaIdContainer image) {
		Image = image;
	}

}
