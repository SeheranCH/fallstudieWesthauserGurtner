package ch.noseryoung.uk.domainModels.role;

import ch.noseryoung.uk.domainModels.user.User;

import java.util.List;

// This is an example service with method signatures for CRUD logic
public interface RoleService {

    Role create(Role role);

    List<Role> findAll();

    Role findById(String id);

    Role updateById(String id, Role role);

    void deleteById(String id);

}
