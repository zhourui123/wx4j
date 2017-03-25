package cn.zr.wx4j.model.sendMsg;

public class Item {
	private String Title;

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	private String Description;
	private String PicUrl;
	private String Url;

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}
}
