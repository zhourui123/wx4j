package cn.zr.wx4j.model.mass.tag;

public class BaseMassWithTag {
	private String msgtype;

	public BaseMassWithTag() {
		super();
	}

	public BaseMassWithTag(String msgtype, MassFilter filter) {
		super();
		this.msgtype = msgtype;
		this.filter = filter;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public MassFilter getFilter() {
		return filter;
	}

	public void setFilter(MassFilter filter) {
		this.filter = filter;
	}

	private MassFilter filter;

}
