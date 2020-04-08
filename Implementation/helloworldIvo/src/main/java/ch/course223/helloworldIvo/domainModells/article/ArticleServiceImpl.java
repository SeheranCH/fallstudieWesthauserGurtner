package ch.course223.helloworldIvo.domainModells.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) { this.articleRepository = articleRepository; }

    // The logic for creating a new article
    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public List<Article> findAll() {
        return articleRepository.findAll();
    }

    @Override
    public Article findById(String id) {
        return articleRepository.findById(id).get();
    }

    // The logic for updating an existing bid with a give id and data
    @Override
    public Article updateById(String id, Article article) {
        if (articleRepository.existsById(id)) {
            article.setId(id);
            articleRepository.save(article);
            return article;
        } else {
            throw new NoSuchElementException("No values present");
        }
    }

    // The logic for deleting an article with a given id
    @Override
    public void deleteById(String id) {
        articleRepository.deleteById(id);
    }
}
