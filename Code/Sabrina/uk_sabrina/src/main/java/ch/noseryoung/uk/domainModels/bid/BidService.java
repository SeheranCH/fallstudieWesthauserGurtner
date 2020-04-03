package ch.noseryoung.uk.domainModels.bid;

import java.util.List;

public interface BidService {

    public List<Bid> getAllBids();
    public Bid getBidById(String id);
    public Bid createNewBid(Bid bid);
    public Bid updateBid(Bid bid, String id);
    public Bid deleteOneBid(String id);
}
