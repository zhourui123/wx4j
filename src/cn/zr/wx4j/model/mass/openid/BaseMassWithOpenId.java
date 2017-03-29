package cn.zr.wx4j.model.mass.openid;

public class BaseMassWithOpenId {
	private String msgtype;
	private String[] touser;

	public BaseMassWithOpenId(String msgtype, String[] touser) {
		super();
		this.msgtype = msgtype;
		this.touser = touser;
	}

	public BaseMassWithOpenId() {
		super();
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String[] getTouser() {
		return touser;
	}

	public void setTouser(String[] touser) {
		this.touser = touser;
	}

}
