package ch.noseryoung.uk.domainModels.user;

import ch.noseryoung.uk.domainModels.auction.Auction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This is an example controller with CRUD logic
@RestController
@RequestMapping("/users")
public class UserController {

    // The newly created service to be injected
    private UserService userService;

    // Injecting the dependency via constructor
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // This endpoint creates a new user with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<User> create(@RequestBody User user) {
        return new ResponseEntity<>(userService.create(user), HttpStatus.CREATED);
    }

    // This endpoint retrieves all users as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    // This endpoint retrieves a single user by it's id
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable int id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    /*
    @GetMapping("/{id}/bidOnAuctions")
    public ResponseEntity<List<Auction>> getAllBidOnAuctionsByUser(@PathVariable int id){
        return new ResponseEntity<>(userService.getAllBidOnAuction(id), HttpStatus.OK);
    }

     */

    // This endpoint updates an existing user with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable int id, @RequestBody User user) {
        return new ResponseEntity<>(userService.updateById(id, user), HttpStatus.OK);
    }

    // This endpoint deletes an existing user with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable int id) {
        return new ResponseEntity<>(userService.deleteById(id),HttpStatus.NO_CONTENT);
    }

}
