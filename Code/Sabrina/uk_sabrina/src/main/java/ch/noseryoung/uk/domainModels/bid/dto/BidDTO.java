package ch.noseryoung.uk.domainModels.bid.dto;

import ch.noseryoung.uk.domainModels.auction.Auction;
import ch.noseryoung.uk.domainModels.user.User;

public class BidDTO {
    private String id;
    private double amount;
    private Auction auction;
    private User user;

    public BidDTO(){}

    public BidDTO(String id, double amount, Auction auction, User user) {
        this.id = id;
        this.amount = amount;
        this.auction = auction;
        this.user = user;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
