package cn.zr.wx4j.model.mass.preview;

public class CardPreviewMass extends BasePreviewMass {
	private CardContainer wxcard;

	public CardPreviewMass() {
		super();
	}

	public CardPreviewMass(String msgtype, String touser, CardContainer wxcard) {
		super(msgtype, touser);
		this.wxcard = wxcard;
	}

	public CardContainer getWxcard() {
		return wxcard;
	}

	public void setWxcard(CardContainer wxcard) {
		this.wxcard = wxcard;
	}
}
