package cn.zr.wx4j.model.menu;

public class MatchRule {

	private String tag_id;
	private String sex;
	private String country;
	private String province;
	private String city;
	private String client_platform_type;
	private String language;

	public MatchRule() {
		super();
	}

	public MatchRule(String tag_id, String sex, String country, String province, String city,
			String client_platform_type, String language) {
		super();
		this.tag_id = tag_id;
		this.sex = sex;
		this.country = country;
		this.province = province;
		this.city = city;
		this.client_platform_type = client_platform_type;
		this.language = language;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getClient_platform_type() {
		return client_platform_type;
	}

	public void setClient_platform_type(String client_platform_type) {
		this.client_platform_type = client_platform_type;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
