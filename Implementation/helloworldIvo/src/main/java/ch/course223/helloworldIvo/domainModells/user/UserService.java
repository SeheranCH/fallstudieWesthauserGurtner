package ch.course223.helloworldIvo.domainModells.user;

import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

// This is an example service with method signatures for CRUD logic
public interface UserService extends UserDetailsService {

    User create(User user);

    List<User> findAll();

    // The logic for retrieving a single user with a given id
    User findById(String id);

    // The logic for updating an existing user with a given id and data
    User updateById(String id, User user);

    // The logic for deleting a user with a given id
    void deleteById(String id);

    List<User> findUsersWithSalary(int min, int max);

}