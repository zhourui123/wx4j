package cn.zr.wx4j.model.sendMsg;

import cn.zr.wx4j.model.container.VideoDescriptionContainer;

public class VideoMessage extends BaseMessage {

	private VideoDescriptionContainer Video;

	public VideoMessage() {
		super();
	}

	public VideoMessage(String toUserName, String fromUserName, Long createTime, String msgType,
			cn.zr.wx4j.model.container.VideoDescriptionContainer video) {
		super(toUserName, fromUserName, createTime, msgType);
		Video = video;
	}

	public VideoDescriptionContainer getVideo() {
		return Video;
	}

	public void setVideo(VideoDescriptionContainer video) {
		Video = video;
	}

}
