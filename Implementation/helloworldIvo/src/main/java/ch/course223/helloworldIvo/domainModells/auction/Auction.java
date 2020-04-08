package ch.course223.helloworldIvo.domainModells.auction;

import ch.course223.helloworldIvo.domainModells.article.Article;
import ch.course223.helloworldIvo.domainModells.user.User;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

// This is an example class on how a domain model could be built
@Entity
@Table(name = "auction")
public class Auction {

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

    @Column(name = "description")
    private String description;

    @Column(name = "fixedPrice")
    private String fixed_price;

    @Column(name = "startingPrice")
    private String starting_price;

    @Column(name = "isPublic")
    private Boolean isPublic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "article_id", referencedColumnName = "id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Article article;

    public Auction() {}

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
