package ch.noseryoung.uk.domainModels.article;

import ch.noseryoung.uk.domainModels.article.dto.ArticleDTO;
import ch.noseryoung.uk.domainModels.article.dto.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    private ArticleService articleService;
    private ArticleMapper articleMapper;

    public ArticleController(ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    @GetMapping("")
    public @ResponseBody
    ResponseEntity<List<ArticleDTO>> getAll(){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.getAllProducts()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<ArticleDTO> getById(@PathVariable String id){
        return new ResponseEntity<>(articleMapper.toDTO(articleService.getArticleById(id)), HttpStatus.OK);
    }

    @GetMapping("/asc")
    public @ResponseBody
    ResponseEntity<List<ArticleDTO>> getAllAsc(){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.sortListByValueAsc()), HttpStatus.OK);
    }

    @GetMapping("/desc")
    public @ResponseBody
    ResponseEntity<List<ArticleDTO>> getAllDesc(){
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.sortListByValueDesc()), HttpStatus.OK);
    }

    @PostMapping("")
    public @ResponseBody
    ResponseEntity<ArticleDTO> create(@RequestBody ArticleDTO articleDTO){
        return new ResponseEntity<>(articleMapper.toDTO(articleService.createNewArticle(articleMapper.fromDTO(articleDTO))), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    ResponseEntity<ArticleDTO> update(@PathVariable String id, @RequestBody ArticleDTO articleDTO){
        return new ResponseEntity<>(articleMapper.toDTO(articleService.updateArticle(articleMapper.fromDTO(articleDTO), id)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    ResponseEntity<ArticleDTO> delete(@PathVariable String id){
        return new ResponseEntity<>(articleMapper.toDTO(articleService.deleteOneArticle(id)), HttpStatus.NO_CONTENT);
    }


}
