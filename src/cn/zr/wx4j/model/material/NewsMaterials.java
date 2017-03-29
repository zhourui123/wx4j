package cn.zr.wx4j.model.material;

import java.util.List;

public class NewsMaterials {
	private List<NewsMaterial> articles;

	public NewsMaterials() {
		super();
	}

	public NewsMaterials(List<NewsMaterial> articles) {
		super();
		this.articles = articles;
	}

	public List<NewsMaterial> getArticles() {
		return articles;
	}

	public void setArticles(List<NewsMaterial> articles) {
		this.articles = articles;
	}
}
