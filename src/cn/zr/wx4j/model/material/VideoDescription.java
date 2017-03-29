package cn.zr.wx4j.model.material;

public class VideoDescription {

	private String title;
	private String introduction;

	public VideoDescription(String title, String introduction) {
		this.title = title;
		this.introduction = introduction;
	}

	public VideoDescription() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

}
