package ch.course223.helloworldIvo.domainModells.authority;
import ch.course223.helloworldIvo.domainModells.auction.dto.AuctionDTO;
import ch.course223.helloworldIvo.domainModells.auction.dto.AuctionMapper;
import ch.course223.helloworldIvo.domainModells.authority.dto.AuthorityDTO;
import ch.course223.helloworldIvo.domainModells.authority.dto.AuthorityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This is an example controller with CRUD logic
@RestController
@RequestMapping("/authorities")
public class AuthorityController {

    // The newly created service to be injected
    private AuthorityService authorityService;

    // The mapper to be injected
    private AuthorityMapper authorityMapper;

    // Injecting the dependency via constructor
    @Autowired
    public AuthorityController(AuthorityService authorityService, AuthorityMapper authorityMapper) {
        this.authorityService = authorityService;
        this.authorityMapper = authorityMapper;
    }

    // This endpoint creates a new authority with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<AuthorityDTO> create(@RequestBody AuthorityDTO authorityDTO) {
        return new ResponseEntity<>(authorityMapper.toDTO(authorityService.create(authorityMapper.fromDTO(authorityDTO))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all authorities as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<AuthorityDTO>> getAll() {

        return new ResponseEntity<>(authorityMapper.toDTOs(authorityService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single authority by it's id
    @GetMapping("/{id}")
    public ResponseEntity<AuthorityDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(authorityMapper.toDTO(authorityService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing authority with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<AuthorityDTO> updateById(@PathVariable String id, @RequestBody AuthorityDTO authorityDTO) {
        return new ResponseEntity<>(authorityMapper.toDTO(authorityService.updateById(id, authorityMapper.fromDTO(authorityDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing authority with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        authorityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
