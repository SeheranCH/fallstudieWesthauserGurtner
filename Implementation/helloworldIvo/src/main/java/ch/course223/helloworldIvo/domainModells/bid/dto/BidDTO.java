package ch.course223.helloworldIvo.domainModells.bid.dto;

import ch.course223.helloworldIvo.domainModells.auction.Auction;

// This an example class on how a DTO could be built
// A DTO is pretty much just a regular POJO, there is no need for any fancy annotations
public class BidDTO {

    // Representative attributes, make sure they are called the same way as the attribute that they represent
    private String id;

    private double amount;

    private Auction auction;

    // Standard empty constructor
    public BidDTO() {}

    // Standard getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
