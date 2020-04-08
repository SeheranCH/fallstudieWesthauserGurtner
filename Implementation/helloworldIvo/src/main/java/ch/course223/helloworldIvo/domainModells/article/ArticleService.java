package ch.course223.helloworldIvo.domainModells.article;

import java.util.List;

public interface ArticleService {

    Article create(Article article);

    List<Article> findAll();

    Article findById(String id);

    Article updateById(String id, Article article);

    void deleteById(String id);

}
