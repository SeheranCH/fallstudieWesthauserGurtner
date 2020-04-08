package ch.course223.helloworldIvo.domainModells.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

// This is an example service implementation with coded out CRUD logic
// Note that the @Service annotation belongs on here as the effective logic is found here
@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    // The logic for creating a new role
    @Override
    public Role create(Role role) {
        return roleRepository.save(role);
    }

    // The logic for retrieving all roles
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    // The logic for retrieving a single role with a given id
    @Override
    public Role findById(String id) {
        return roleRepository.findById(id).get();
    }

    // The logic for updating an existing role with a given id and data
    @Override
    public Role updateById(String id, Role role) {
        if(roleRepository.existsById(id)) {
            role.setId(id);
            roleRepository.save(role);

            return role;
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // The logic for deleting a role with a given id
    @Override
    public void deleteById(String id) {
        roleRepository.deleteById(id);
    }
}

