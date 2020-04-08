package ch.course223.helloworldIvo.domainModells.authority;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

// This is an example class on a domain model could be built
@Entity
@Table (name = "authority")
public class Authority {

    // Regular attributes
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

    // Standard empty constructor
    public Authority() {}

    // Getters and setters
    public String getId() {
        return id;
    }

    public Authority setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Authority setName(String name) {
        this.name = name;
        return this;
    }

}

