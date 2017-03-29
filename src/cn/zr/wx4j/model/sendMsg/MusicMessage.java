package cn.zr.wx4j.model.sendMsg;

import cn.zr.wx4j.model.container.MusicDescriptionContainer;

public class MusicMessage extends BaseMessage {
	
	private MusicDescriptionContainer Music;

	public MusicMessage() {
		super();
	}

	public MusicMessage(String toUserName, String fromUserName, Long createTime, String msgType,
			cn.zr.wx4j.model.container.MusicDescriptionContainer music) {
		super(toUserName, fromUserName, createTime, msgType);
		Music = music;
	}

	public MusicDescriptionContainer getMusic() {
		return Music;
	}

	public void setMusic(MusicDescriptionContainer music) {
		Music = music;
	}
}
