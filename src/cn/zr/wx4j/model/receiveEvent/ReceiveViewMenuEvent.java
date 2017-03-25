package cn.zr.wx4j.model.receiveEvent;

public class ReceiveViewMenuEvent extends ReceiveEvent {
	private String EventKey;
	private String MenuID;
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
