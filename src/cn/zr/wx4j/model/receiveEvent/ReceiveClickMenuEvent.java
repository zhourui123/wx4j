package cn.zr.wx4j.model.receiveEvent;

public class ReceiveClickMenuEvent extends ReceiveEvent {
	private String EventKey;

	public ReceiveClickMenuEvent() {
		super();
	}

	public ReceiveClickMenuEvent(String toUserName, String fromUserName, Long createTime, String msgType, String event,
			String eventKey) {
		super(toUserName, fromUserName, createTime, msgType, event);
		EventKey = eventKey;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
