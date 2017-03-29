package cn.zr.wx4j.model.menu;

public class BaseButton {

	private BaseButton[] sub_button;
	private String type;
	private String media_id;
	private String name;

	public BaseButton() {
		super();
	}

	public BaseButton(BaseButton[] sub_button, String type, String media_id, String name) {
		super();
		this.sub_button = sub_button;
		this.type = type;
		this.media_id = media_id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BaseButton[] getSub_button() {
		return sub_button;
	}

	public void setSub_button(BaseButton[] sub_button) {
		this.sub_button = sub_button;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}
}
