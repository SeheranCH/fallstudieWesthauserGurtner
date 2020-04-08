package ch.course223.helloworldIvo.domainModells.user;

import ch.course223.helloworldIvo.domainModells.user.dto.UserDTO;
import ch.course223.helloworldIvo.domainModells.user.dto.UserMapper;
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

    // The mapper to be injected
    private UserMapper userMapper;

    // Injecting the dependency via constructor
    @Autowired
    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    // This endpoint creates a new user with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userMapper.toDTO(userService.create(userMapper.fromDTO(userDTO))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all users as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<UserDTO>> getAll() {
        return new ResponseEntity<>(userMapper.toDTOs(userService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single user by it's id
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getById(@PathVariable String id) {
        return new ResponseEntity<>(userMapper.toDTO(userService.findById(id)), HttpStatus.OK);
    }

    @GetMapping("/salary/{min}/{max}")
    public ResponseEntity<List<UserDTO>> getAllUsersWithSalary (@PathVariable int min, @PathVariable int max) {
        return new ResponseEntity<>(userMapper.toDTOs(userService.findUsersWithSalary(min, max)), HttpStatus.OK);
    }

    // This endpoint updates an existing user with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateById(@PathVariable String id, @RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userMapper.toDTO(userService.updateById(id, userMapper.fromDTO(userDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing user with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        userService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
