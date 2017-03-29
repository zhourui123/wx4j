package cn.zr.wx4j.model.menu;

public class ClickButton extends BaseButton {
	private String key;

	public ClickButton() {
		super();
	}

	public ClickButton(BaseButton[] sub_button, String type, String media_id, String name, String key) {
		super(sub_button, type, media_id, name);
		this.key = key;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
