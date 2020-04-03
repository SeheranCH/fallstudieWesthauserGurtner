package ch.noseryoung.uk.domainModels.article;

import java.util.List;

public interface ArticleService {

    public List<Article> sortListByValueAsc();
    public List<Article> sortListByValueDesc();
    public List<Article> getAllProducts();
    public Article getArticleById(String id);
    public Article createNewArticle(Article article);
    public Article updateArticle(Article article, String id);
    public Article deleteOneArticle(String id);
}
