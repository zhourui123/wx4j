package cn.zr.wx4j.model.mass.openid;

import cn.zr.wx4j.model.mass.MediaIdContainer;

public class NewsMassWithOpenId extends BaseMassWithOpenId {

	private MediaIdContainer mpnews;
	private int send_ignore_reprint;
	public MediaIdContainer getMpnews() {
		return mpnews;
	}
	public void setMpnews(MediaIdContainer mpnews) {
		this.mpnews = mpnews;
	}
	public int getSend_ignore_reprint() {
		return send_ignore_reprint;
	}
	public void setSend_ignore_reprint(int send_ignore_reprint) {
		this.send_ignore_reprint = send_ignore_reprint;
	}



}
