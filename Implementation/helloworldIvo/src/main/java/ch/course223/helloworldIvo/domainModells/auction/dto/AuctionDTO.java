package ch.course223.helloworldIvo.domainModells.auction.dto;

import ch.course223.helloworldIvo.domainModells.auction.Auction;


// This an example class on how a DTO could be built
// A DTO is pretty much just a regular POJO, there is no need for any fancy annotations
public class AuctionDTO {

    // Representative attributes, make sure they are called the same way as the attribute that they represent
    private String id;

    private String description;

    private String fixed_price;

    private String starting_price;

    private Boolean isPublic;

    private Auction auction;

    // Standard empty constructor
    public AuctionDTO() {}

    // Standard getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFixed_price() {
        return fixed_price;
    }

    public void setFixed_price(String fixed_price) {
        this.fixed_price = fixed_price;
    }

    public String getStarting_price() {
        return starting_price;
    }

    public void setStarting_price(String starting_price) {
        this.starting_price = starting_price;
    }

    public Boolean getPublic() {
        return isPublic;
    }

    public void setPublic(Boolean aPublic) {
        isPublic = aPublic;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
