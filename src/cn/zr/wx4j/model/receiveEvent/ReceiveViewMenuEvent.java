package cn.zr.wx4j.model.receiveEvent;

public class ReceiveViewMenuEvent extends ReceiveEvent {
	private String EventKey;
	private String MenuID;

	public ReceiveViewMenuEvent() {
		super();
	}

	public ReceiveViewMenuEvent(String toUserName, String fromUserName, Long createTime, String msgType, String event,
			String eventKey, String menuID) {
		super(toUserName, fromUserName, createTime, msgType, event);
		EventKey = eventKey;
		MenuID = menuID;
	}

	public String getMenuID() {
		return MenuID;
	}

	public void setMenuID(String menuID) {
		MenuID = menuID;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
