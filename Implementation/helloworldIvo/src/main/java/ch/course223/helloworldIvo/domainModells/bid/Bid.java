package ch.course223.helloworldIvo.domainModells.bid;


import ch.course223.helloworldIvo.domainModells.auction.Auction;
import ch.course223.helloworldIvo.domainModells.user.User;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

// This is an example class on how a domain model could be built
@Entity
@Table(name = "bid")
public class Bid {

    //Regular attributes
    @Id
    // This annotation makes sure that our id gets generated
    @GeneratedValue(generator = "system-uuid")
    // With this annotation we define the generator for our UUIDs
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    // And lastly this annotation ensures when it will get generated
    @Generated(GenerationTime.ALWAYS)
    // This annotation simply defines that this attribute has it's own column and how that column is called
    @Column(name = "id")
    private String id;

    @Column(nullable = false, name = "amount")
    private double amount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "auction_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Auction auction;

    public Bid() {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }
}
