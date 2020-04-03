package ch.noseryoung.uk.domainModels.user.dto;

import ch.noseryoung.uk.domainModels.role.Role;

import java.util.Set;

public class UserDTO {

    private String userId;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Set<Role> roles;

    private Boolean locked;

    private Boolean enabled;


    public UserDTO() {
    }


    public String getId() {
        return userId;
    }

    public UserDTO setId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public UserDTO setRoles(Set<Role> roles) {
        this.roles = roles;
        return this;
    }

    public Boolean getLocked() {
        return locked;
    }

    public UserDTO setLocked(Boolean locked) {
        this.locked = locked;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public UserDTO setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
