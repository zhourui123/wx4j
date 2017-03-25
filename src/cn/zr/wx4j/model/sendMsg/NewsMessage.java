package cn.zr.wx4j.model.sendMsg;

import java.util.List;

public class NewsMessage extends Message {

	
	private List<Item> Articles;
	
	private int ArticleCount;
	public int getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}
	public List<Item> getArticles() {
		return Articles;
	}
	public void setArticles(List<Item> articles) {
		Articles = articles;
	}

	
	
	
}
