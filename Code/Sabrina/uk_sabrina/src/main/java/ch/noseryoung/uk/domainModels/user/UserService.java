package ch.noseryoung.uk.domainModels.user;

import ch.noseryoung.uk.domainModels.auction.Auction;

import java.util.List;

// This is an example service with method signatures for CRUD logic
public interface UserService {

    User create(User user);

    List<User> findAll();

    User findById(int id);

    User updateById(int id, User user);

    User deleteById(int id);

    // List<Auction> getAllBidOnAuction(int userId);

}
