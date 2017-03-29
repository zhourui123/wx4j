package cn.zr.wx4j.model.container;

public class MusicDescriptionContainer {
	private String Title;
	private String Description;
	private String MusicURL;
	private String HQMusicUrl;
	private String ThumbMediaId;

	public MusicDescriptionContainer() {
		super();
	}

	public MusicDescriptionContainer(String title, String description, String musicURL, String hQMusicUrl,
			String thumbMediaId) {
		super();
		Title = title;
		Description = description;
		MusicURL = musicURL;
		HQMusicUrl = hQMusicUrl;
		ThumbMediaId = thumbMediaId;
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

	public String getMusicURL() {
		return MusicURL;
	}

	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}
}
