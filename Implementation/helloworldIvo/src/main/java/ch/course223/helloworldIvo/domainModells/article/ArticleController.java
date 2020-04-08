package ch.course223.helloworldIvo.domainModells.article;

import ch.course223.helloworldIvo.domainModells.article.dto.ArticleDTO;
import ch.course223.helloworldIvo.domainModells.article.dto.ArticleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    // The newly created service to be injected
    private ArticleService articleService;

    // The mapper to be injected
    private ArticleMapper articleMapper;

    // Injecting the dependency via constructor
    @Autowired
    public ArticleController (ArticleService articleService, ArticleMapper articleMapper) {
        this.articleService = articleService;
        this.articleMapper = articleMapper;
    }

    // This endpoint creates a new user with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<ArticleDTO> create(@RequestBody ArticleDTO articleDTO) {
        return new ResponseEntity<>(articleMapper.toDTO(articleService.create(articleMapper.fromDTO(articleDTO))), HttpStatus.OK);
    }

    // This endpoint retrieves all articles as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<ArticleDTO>> getAll() {
        return new ResponseEntity<>(articleMapper.toDTOs(articleService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single article by its id
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(articleMapper.toDTO(articleService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing article with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<ArticleDTO> updateById(@PathVariable String id, @RequestBody ArticleDTO articleDTO) {
        return new ResponseEntity<>(articleMapper.toDTO(articleService.updateById(id, articleMapper.fromDTO(articleDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing article with the given id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
       articleService.deleteById(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
