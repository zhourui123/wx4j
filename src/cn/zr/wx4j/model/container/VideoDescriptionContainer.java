package cn.zr.wx4j.model.container;

public class VideoDescriptionContainer {
	private String MediaId;
	private String Title;
	private String Description;

	public VideoDescriptionContainer() {
		super();
	}

	public VideoDescriptionContainer(String mediaId, String title, String description) {
		super();
		MediaId = mediaId;
		Title = title;
		Description = description;
	}

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

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}
}
