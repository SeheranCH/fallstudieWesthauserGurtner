package ch.noseryoung.uk.domainModels.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public @ResponseBody
    ResponseEntity<List<Article>> getAll(){
        return new ResponseEntity<>(articleService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Article> getById(@PathVariable String id){
        return new ResponseEntity<>(articleService.getArticleById(id), HttpStatus.OK);
    }

    @GetMapping("/asc")
    public @ResponseBody
    ResponseEntity<List<Article>> getAllAsc(){
        return new ResponseEntity<>(articleService.sortListByValueAsc(), HttpStatus.OK);
    }

    @GetMapping("/desc")
    public @ResponseBody
    ResponseEntity<List<Article>> getAllDesc(){
        return new ResponseEntity<>(articleService.sortListByValueDesc(), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody
    ResponseEntity<Article> create(@RequestBody Article article){
        return new ResponseEntity<>(articleService.createNewArticle(article), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Article> update(@PathVariable String id, @RequestBody Article article){
        return new ResponseEntity<>(articleService.updateArticle(article, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<Article> delete(@PathVariable String id){
        return new ResponseEntity<>(articleService.deleteOneArticle(id), HttpStatus.NO_CONTENT);
    }


}
