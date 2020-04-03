package ch.noseryoung.uk.domainModels.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

// This is an example controller with CRUD logic
@RestController
@RequestMapping("/roles")
public class RoleController {

    // The newly created service to be injected
    private RoleService roleService;

    // Injecting the dependency via constructor
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    // This endpoint creates a new role with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<Role> create(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.create(role), HttpStatus.CREATED);
    }

    // This endpoint retrieves all roles as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<Role>> getAll() {
        return new ResponseEntity<>(roleService.findAll(), HttpStatus.OK);
    }

    // This endpoint retrieves a single role by it's id
    @GetMapping("/{id}")
    public ResponseEntity<Role> getById(@PathVariable int id) {
        return new ResponseEntity<>(roleService.findById(id), HttpStatus.OK);
    }

    // This endpoint updates an existing role with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<Role> updateById(@PathVariable int id, @RequestBody Role role) {
        return new ResponseEntity<>(roleService.updateById(id, role), HttpStatus.OK);
    }

    // This endpoint deletes an existing role with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id) {
        roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
