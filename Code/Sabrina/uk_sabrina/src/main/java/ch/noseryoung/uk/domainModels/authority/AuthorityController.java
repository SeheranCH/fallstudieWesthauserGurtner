package ch.noseryoung.uk.domainModels.authority;

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

    // Injecting the dependency via constructor
    @Autowired
    public AuthorityController(AuthorityService authorityService) {
        this.authorityService = authorityService;
    }

    // This endpoint creates a new authority with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<Authority> create(@RequestBody Authority authority) {
        return new ResponseEntity<>(authorityService.create(authority), HttpStatus.CREATED);
    }

    // This endpoint retrieves all authorities as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<Authority>> getAll() {

        return new ResponseEntity<>(authorityService.findAll(), HttpStatus.OK);
    }

    // This endpoint retrieves a single authority by it's id
    @GetMapping("/{id}")
    public ResponseEntity<Authority> getById(@PathVariable int id) {
        return new ResponseEntity<>(authorityService.findById(id), HttpStatus.OK);
    }

    // This endpoint updates an existing authority with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<Authority> updateById(@PathVariable int id, @RequestBody Authority authority) {
        return new ResponseEntity<>(authorityService.updateById(id, authority), HttpStatus.OK);
    }

    // This endpoint deletes an existing authority with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        authorityService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
