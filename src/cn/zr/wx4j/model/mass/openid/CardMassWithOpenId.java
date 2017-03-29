package cn.zr.wx4j.model.mass.openid;

import cn.zr.wx4j.model.container.CardIdContainer;

public class CardMassWithOpenId extends BaseMassWithOpenId {

	private CardIdContainer wxcard;

	public CardMassWithOpenId() {
		super();
	}

	public CardMassWithOpenId(String msgtype, String[] touser, CardIdContainer wxcard) {
		super(msgtype, touser);
		this.wxcard = wxcard;
	}

	public CardIdContainer getWxcard() {
		return wxcard;
	}

	public void setWxcard(CardIdContainer wxcard) {
		this.wxcard = wxcard;
	}

}
