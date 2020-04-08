package ch.course223.helloworldIvo.domainModells.bid;

import java.util.List;

public interface BidService {

    Bid create(Bid bid);

    List<Bid> findAll();

    Bid findById(String id);

    Bid updateById(String id, Bid bid);

    void deleteById(String id);

}
