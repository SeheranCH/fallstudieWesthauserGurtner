package ch.course223.helloworldIvo.domainModells.role;
import ch.course223.helloworldIvo.domainModells.role.dto.RoleDTO;
import ch.course223.helloworldIvo.domainModells.role.dto.RoleMapper;
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

    // The mapper to be injected
    private RoleMapper roleMapper;

    // Injecting the dependency via constructor
    @Autowired
    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.roleService = roleService;
        this.roleMapper = roleMapper;
    }

    // This endpoint creates a new role with the data given
    @PostMapping({"/", ""})
    public ResponseEntity<RoleDTO> create(@RequestBody RoleDTO roleDTO) {
        // In this line we now convert the DTO to an business object first to create it via the service, and then back into a DTO to send it back as a response
        return new ResponseEntity<>(roleMapper.toDTO(roleService.create(roleMapper.fromDTO(roleDTO))), HttpStatus.CREATED);
    }

    // This endpoint retrieves all roles as a list
    @GetMapping({"/", ""})
    public ResponseEntity<List<RoleDTO>> getAll() {
        // In this line we now convert the list of business objects into a list of DTOs
        return new ResponseEntity<>(roleMapper.toDTOs(roleService.findAll()), HttpStatus.OK);
    }

    // This endpoint retrieves a single role by it's id
    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getById(@PathVariable String id) {
        // In this line we now convert the business object into a DTO
        return new ResponseEntity<>(roleMapper.toDTO(roleService.findById(id)), HttpStatus.OK);
    }

    // This endpoint updates an existing role with the id and data given
    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateById(@PathVariable String id, @RequestBody RoleDTO roleDTO) {
        return new ResponseEntity<>(roleMapper.toDTO(roleService.updateById(id, roleMapper.fromDTO(roleDTO))), HttpStatus.OK);
    }

    // This endpoint deletes an existing role with the id given
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        roleService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
