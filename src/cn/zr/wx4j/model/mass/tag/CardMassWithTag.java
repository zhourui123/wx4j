package cn.zr.wx4j.model.mass.tag;

import cn.zr.wx4j.model.container.CardIdContainer;

public class CardMassWithTag extends BaseMassWithTag {
	private CardIdContainer wxcard;

	public CardMassWithTag() {
		super();
	}

	public CardMassWithTag(String msgtype, MassFilter filter, CardIdContainer wxcard) {
		super(msgtype, filter);
		this.wxcard = wxcard;
	}

	public CardIdContainer getWxcard() {
		return wxcard;
	}

	public void setWxcard(CardIdContainer wxcard) {
		this.wxcard = wxcard;
	}

}
