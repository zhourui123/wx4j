package cn.zr.wx4j.model.receiveEvent;

import cn.zr.wx4j.model.sendMsg.Message;

public class ReceiveEvent extends Message{

	
	private String Event;

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
}
