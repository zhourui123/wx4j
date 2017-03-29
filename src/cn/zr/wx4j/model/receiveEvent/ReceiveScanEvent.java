package cn.zr.wx4j.model.receiveEvent;

public class ReceiveScanEvent extends ReceiveEvent {
	private String EventKey;// 事件KEY值，qrscene_为前缀，后面为二维码的参数值
	private String Ticket;// 二维码的ticket，可用来换取二维码图片

	public ReceiveScanEvent() {
		super();
	}

	public ReceiveScanEvent(String toUserName, String fromUserName, Long createTime, String msgType, String event,
			String eventKey, String ticket) {
		super(toUserName, fromUserName, createTime, msgType, event);
		EventKey = eventKey;
		Ticket = ticket;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
