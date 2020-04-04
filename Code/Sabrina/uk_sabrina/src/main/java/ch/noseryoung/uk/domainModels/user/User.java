package ch.noseryoung.uk.domainModels.user;

import ch.noseryoung.uk.domainModels.role.Role;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid")
        @Generated(GenerationTime.ALWAYS)
        @Column(name = "id")
        private String userId;
        @Column(name = "fistname")
        private String firstName;
        @Column(name = "lastname")
        private String lastName;
        @Column(name = "email")
        private String email;
        @Column(name = "password")
        private String password;
        @Column(name = "username")
        private String username;
        @Column(name = "locked")
        @Type(type = "org.hibernate.type.NumericBooleanType")
        private Boolean locked;
        @Column(name = "enabled")
        @Type(type = "org.hibernate.type.NumericBooleanType")
        private Boolean enabled;

        @ManyToMany(fetch = FetchType.EAGER)
        @JoinTable(
                name = "users_roles",
                joinColumns = @JoinColumn(name = "users_id"),
                inverseJoinColumns = @JoinColumn(name = "role_id")
        )
        private Set<Role> roles;

        public User() {}


        public User(String firstName, String lastName, String email, String password, String username, Boolean locked, Boolean enabled, Set<Role> roles) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.password = password;
            this.username = username;
            this.locked = locked;
            this.enabled = enabled;
            this.roles = roles;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public Set<Role> getRoles() {
            return roles;
        }

        public void setRoles(Set<Role> roles) {
            this.roles = roles;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Boolean isLocked() {
            return locked;
        }

        public void setLocked(Boolean locked) {
            this.locked = locked;
        }

        public Boolean isEnabled() {
            return enabled;
        }

        public void setEnabled(Boolean enabled) {
            this.enabled = enabled;
        }
    }

    // TODO, create attribute once the auction entity has been made
    // @OneToMany(mappedBy = "user")
    // private List<Auction> auctions;

    // Attributes necessary for use in a spring boot environment
    // Simple column annotation with naming

    // TODO, create getters and setters once the auction entity has been created


    /*
    public List<Auction> getAuctions() {
        return auctions;
    }

    public void setAuctions(List<Auction> auctions) {
        this.auctions = auctions;
    }

     */



