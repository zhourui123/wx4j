package cn.zr.wx4j.model;

public class AcessToken {

	public int getExpires_in() {
		return expires_in;
	}

	public AcessToken(int expires_in, String access_token) {
		super();
		this.expires_in = expires_in;
		this.access_token = access_token;
	}

	public AcessToken() {
		super();

	}

	public void setExpires_in(int expires_in) {
		this.expires_in = expires_in;
	}

	public String getAccess_token() {
		return access_token;
	}

	public void setAccess_token(String access_token) {
		this.access_token = access_token;
	}

	private int expires_in;

	private String access_token;

}
