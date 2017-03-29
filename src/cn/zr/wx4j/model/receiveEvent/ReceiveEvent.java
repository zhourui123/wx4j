package cn.zr.wx4j.model.receiveEvent;

import cn.zr.wx4j.model.sendMsg.BaseMessage;

public class ReceiveEvent extends BaseMessage {

	private String Event;

	public ReceiveEvent() {
		super();
	}

	public ReceiveEvent(String toUserName, String fromUserName, Long createTime, String msgType, String event) {
		super(toUserName, fromUserName, createTime, msgType);
		Event = event;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
}
