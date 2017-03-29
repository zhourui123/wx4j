package cn.zr.wx4j.model.mass.preview;

import cn.zr.wx4j.model.container.CardIdContainer;

public class CardContainer extends CardIdContainer {
	private CardExt card_ext;

	public CardContainer() {
		super();
	}

	public CardContainer(String card_id, CardExt card_ext) {
		super(card_id);
		this.card_ext = card_ext;
	}

	public CardExt getCard_ext() {
		return card_ext;
	}

	public void setCard_ext(CardExt card_ext) {
		this.card_ext = card_ext;
	}
}
