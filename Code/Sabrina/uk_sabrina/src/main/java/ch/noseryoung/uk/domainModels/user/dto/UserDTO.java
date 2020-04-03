package ch.noseryoung.uk.domainModels.user.dto;

import ch.noseryoung.uk.domainModels.role.Role;

import java.util.Set;

public class UserDTO {

    private int id;

    private String firstName;

    private String lastName;

    private String username;

    private String password;

    private Set<Role> roles;

    private Boolean locked;

    private Boolean enabled;


    public UserDTO() {
    }


    public int getId() {
        return id;
    }

    public UserDTO setId(int id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    /*
    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }

     */

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

}
