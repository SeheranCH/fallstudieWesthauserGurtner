package ch.noseryoung.uk.domainModels.user;

import ch.noseryoung.uk.domainModels.auction.Auction;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

// This is an example service with method signatures for CRUD logic
public interface UserService extends UserDetailsService {

    User create(User user);

    List<User> findAll();

    User findById(String id);

    User updateById(String id, User user);

    User deleteById(String id);

    User findByEmail(String email);

    // List<Auction> getAllBidOnAuction(int userId);

}
