package ch.noseryoung.uk.domainModels.auction.dto;

public class AuctionDTO {

    private String id;
    private String description;
    private double fixedPrice;
    private double startingPrice;
    private boolean isPublic;

    public AuctionDTO(){}

    public AuctionDTO(String id, String description, double fixedPrice, double startingPrice, boolean isPublic) {
        this.id = id;
        this.description = description;
        this.fixedPrice = fixedPrice;
        this.startingPrice = startingPrice;
        this.isPublic = isPublic;
    }

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

    public double getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(double fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
