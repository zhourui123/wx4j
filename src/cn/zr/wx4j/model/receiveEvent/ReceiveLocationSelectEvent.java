package cn.zr.wx4j.model.receiveEvent;

public class ReceiveLocationSelectEvent extends ReceiveEvent {
	private String EventKey; // 事件KEY值，由开发者在创建菜单时设定
	private String SendLocationInfo; // 发送的位置信息
	private String Location_X; // X坐标信息
	private String Location_Y; // Y坐标信息
	private String Scale; // 精度，可理解为精度或者比例尺、越精细的话 scale越高
	private String Label; // 地理位置的字符串信息
	private String Poiname; // 朋友圈POI的名字，可能为空

	public ReceiveLocationSelectEvent() {
		super();
	}

	public ReceiveLocationSelectEvent(String toUserName, String fromUserName, Long createTime, String msgType,
			String event, String eventKey, String sendLocationInfo, String location_X, String location_Y, String scale,
			String label, String poiname) {
		super(toUserName, fromUserName, createTime, msgType, event);
		EventKey = eventKey;
		SendLocationInfo = sendLocationInfo;
		Location_X = location_X;
		Location_Y = location_Y;
		Scale = scale;
		Label = label;
		Poiname = poiname;
	}

	public String getSendLocationInfo() {
		return SendLocationInfo;
	}

	public void setSendLocationInfo(String sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getPoiname() {
		return Poiname;
	}

	public void setPoiname(String poiname) {
		Poiname = poiname;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
