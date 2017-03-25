package cn.zr.wx4j.model.receiveMsg;

public class ReceiveMessage {
	private Long CreateTime;
	private String ToUserName;
	private String FromUserName;
	private String MsgType;
	private String MsgId;

	public void setCreateTime(Long createTime) {
		CreateTime = createTime;
	}

	public String getToUserName() {
		return ToUserName;
	}

	public Long getCreateTime() {
		return CreateTime;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

	public String getMsgId() {
		return MsgId;
	}

	public void setMsgId(String msgId) {
		MsgId = msgId;
	}

}
