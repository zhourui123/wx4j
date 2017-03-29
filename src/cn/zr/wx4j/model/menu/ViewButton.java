package cn.zr.wx4j.model.menu;

public class ViewButton extends BaseButton {

	private String url;

	public ViewButton() {
		super();
	}

	public ViewButton(BaseButton[] sub_button, String type, String media_id, String name, String url) {
		super(sub_button, type, media_id, name);
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
