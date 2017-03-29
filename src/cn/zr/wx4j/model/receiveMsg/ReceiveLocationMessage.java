package cn.zr.wx4j.model.receiveMsg;

public class ReceiveLocationMessage extends ReceiveMessage {
	private String Location_X;
	private String Location_Y;
	private String Label;
	private String Scale;

	public ReceiveLocationMessage() {
		super();
	}

	public ReceiveLocationMessage(Long createTime, String toUserName, String fromUserName, String msgType, String msgId,
			String location_X, String location_Y, String label, String scale) {
		super(createTime, toUserName, fromUserName, msgType, msgId);
		Location_X = location_X;
		Location_Y = location_Y;
		Label = label;
		Scale = scale;
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

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public String getScale() {
		return Scale;
	}

	public void setScale(String scale) {
		Scale = scale;
	}

}
