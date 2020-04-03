package ch.noseryoung.uk.domainModels.auction;

import java.util.List;

public interface AuctionService {

    public List<Auction> getAllAuctions();
    public Auction getAuctionById(String id);
    public Auction createNewAuction(Auction auction);
    public Auction updateAuction(Auction auction, String id);
    public Auction deleteOneAuction(String id);
    public List<Auction> findAllByUser(int userId);
   // public Auction getAllBids(String id);

}
