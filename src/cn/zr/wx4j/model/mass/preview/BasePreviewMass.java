package cn.zr.wx4j.model.mass.preview;

public class BasePreviewMass {
	private String msgtype;
	private String touser;

	public BasePreviewMass() {
		super();
	}

	public BasePreviewMass(String msgtype, String touser) {
		super();
		this.msgtype = msgtype;
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

}
