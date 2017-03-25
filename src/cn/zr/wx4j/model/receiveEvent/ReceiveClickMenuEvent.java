package cn.zr.wx4j.model.receiveEvent;

public class ReceiveClickMenuEvent extends ReceiveEvent {
	private String EventKey;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
