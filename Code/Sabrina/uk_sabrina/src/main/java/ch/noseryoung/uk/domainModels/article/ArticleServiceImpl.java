package ch.noseryoung.uk.domainModels.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleRepository articleRepository;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @Override
    public List<Article> sortListByValueAsc() {
        List<Article> articleList = articleRepository.findAll();
        articleList.sort(Comparator.comparing(Article::getValue));
        return articleList;
    }

    @Override
    public List<Article> sortListByValueDesc() {
        List<Article> articleList = articleRepository.findAll();
        articleList.sort(Comparator.comparing(Article::getValue).reversed());
        return articleList;
    }

    @Override
    public List<Article> getAllProducts() {
        List<Article> articleList = articleRepository.findAll();
        return articleList;
    }

    @Override
    public Article getArticleById(String id) {
        return findAllThrow(articleRepository.findById(id));
    }

    @Override
    public Article createNewArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public Article updateArticle(Article article, String id) {
        findAllThrow(articleRepository.findById(id));
        article.setId(id);
        articleRepository.save(article);
        return article;
    }

    @Override
    public Article deleteOneArticle(String id) {
        articleRepository.deleteById(id);
        return null;
    }

    private Article findAllThrow(Optional<Article> optional) throws NoSuchElementException {
        if(optional.isPresent()){
            return optional.get();
        } else throw new NoSuchElementException("No value present");
    }
}
