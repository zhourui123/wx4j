package cn.zr.wx4j.model;

public class KefuInvite {
	private String kf_account;
	private String invite_wx;

	public KefuInvite(String kf_account, String invite_wx) {
		super();
		this.kf_account = kf_account;
		this.invite_wx = invite_wx;
	}

	public KefuInvite() {
		super();
	}

	public String getKf_account() {
		return kf_account;
	}

	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}

	public String getInvite_wx() {
		return invite_wx;
	}

	public void setInvite_wx(String invite_wx) {
		this.invite_wx = invite_wx;
	}

}
