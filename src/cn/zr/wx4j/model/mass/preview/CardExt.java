package cn.zr.wx4j.model.mass.preview;

public class CardExt {
	private String code;
	private String openid;
	private String timestamp;
	private String signature;

	public CardExt(String code, String openid, String timestamp, String signature) {
		super();
		this.code = code;
		this.openid = openid;
		this.timestamp = timestamp;
		this.signature = signature;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}
}
