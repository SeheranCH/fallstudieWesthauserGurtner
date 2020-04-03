package ch.noseryoung.uk.domainModels.auction;

import ch.noseryoung.uk.domainModels.article.Article;
import ch.noseryoung.uk.domainModels.bid.Bid;
import ch.noseryoung.uk.domainModels.user.User;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    @Generated(GenerationTime.ALWAYS)
    @Column(name = "id")
    private String id;
    @Column(name = "description")
    private String description;
    @Column(name = "fixed_price")
    private double fixedPrice;
    @Column(name = "starting_price")
    private double startingPrice;
    @Column(name = "is_public")
    private boolean isPublic;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    private Article article;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

   @OneToMany(fetch = FetchType.LAZY, mappedBy = "auction")
    private List<Bid> bids;



    public Auction() {
    }


    public Auction(String description, double fixedPrice, double startingPrice, boolean isPublic, Article article, User user) {
        this.description = description;
        this.fixedPrice = fixedPrice;
        this.startingPrice = startingPrice;
        this.isPublic = isPublic;
        this.article = article;
        this.user = user;

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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /*
    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

     */
}
