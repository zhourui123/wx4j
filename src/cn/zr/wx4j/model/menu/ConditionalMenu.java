package cn.zr.wx4j.model.menu;

public class ConditionalMenu extends Menu {
	private MatchRule matchrule;

	public ConditionalMenu() {
		super();
	}

	public ConditionalMenu(BaseButton[] button, MatchRule matchrule) {
		super(button);
		this.matchrule = matchrule;
	}

	public MatchRule getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(MatchRule matchrule) {
		this.matchrule = matchrule;
	}
}
