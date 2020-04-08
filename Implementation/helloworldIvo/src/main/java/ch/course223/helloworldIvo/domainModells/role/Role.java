package ch.course223.helloworldIvo.domainModells.role;

import ch.course223.helloworldIvo.domainModells.authority.Authority;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Set;

// This is an example class on a domain model could be built
@Entity
@Table(name = "role")
public class Role {

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

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id")
    )
    @OnDelete(action = OnDeleteAction.CASCADE)

    // Example of a dependency
    private Set<Authority> authorities;

    // Standard empty constructor
    public Role() {
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public Role setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Role setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public Role setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }

}

