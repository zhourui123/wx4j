package cn.zr.wx4j.model.menu;

public class Menu {

	private BaseButton[] button;

	public Menu() {
		super();
	}

	public Menu(BaseButton[] button) {
		super();
		this.button = button;
	}

	public BaseButton[] getButton() {
		return button;
	}

	public void setButton(BaseButton[] button) {
		this.button = button;
	}
}
