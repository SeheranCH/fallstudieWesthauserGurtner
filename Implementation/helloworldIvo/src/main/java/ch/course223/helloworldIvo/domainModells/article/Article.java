package ch.course223.helloworldIvo.domainModells.article;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "article")
public class Article {

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

    @Column(nullable = false, name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(nullable = false, name = "value")
    private double value;

    public Article() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
