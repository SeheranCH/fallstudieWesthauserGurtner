package ch.course223.helloworldIvo.domainModells.user;

import ch.course223.helloworldIvo.domainModells.role.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

// This is an example class on how a domain model could be built
@Entity
@Table(name = "users")
public class User {

    // Regular attributes
    // The primary key, this annotation defines that this is a primary key:
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

    @Column(nullable = false, name = "username")
    private String username;

    @Column(nullable = false, name = "password")
    private String password;

    @Column(nullable = false, name = "salary")
    private double salary;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_role",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )

    // Examples of dependencies
    private Set<Role> roles;

    // TODO, create attribute once the auction entity has been made
    //private List<Auction> auctions;

    // Attributes necessary for use in a spring boot environment
    private LocalDate accountExpirationDate;

    private LocalDate credentialsExpirationDate;

    @Column(name = "locked")
    private Boolean locked;

    @Column(name = "enabled")
    private Boolean enabled;

    // Standard empty constructor
    public User() {}

    // Getters and setters
    public String getId() {
        return id;
    }

    public User setId(String id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    // TODO, create getters and setters once the auction entity has been created
    // public List<Auction> getAuctions() {
    //    return auctions;
    //}

    /*public User setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
        return this;
    }*/

    public LocalDate getAccountExpirationDate() {
        return accountExpirationDate;
    }

    public User setAccountExpirationDate(LocalDate accountExpirationDate) {
        this.accountExpirationDate = accountExpirationDate;
        return this;
    }

    public LocalDate getCredentialsExpirationDate() {
        return credentialsExpirationDate;
    }

    public User setCredentialsExpirationDate(LocalDate credentialsExpirationDate) {
        this.credentialsExpirationDate = credentialsExpirationDate;
        return this;
    }

    public Boolean getLocked() {
        return locked;
    }

    public User setLocked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public User setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }

}
