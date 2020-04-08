package ch.course223.helloworldIvo.domainModells.user.dto;

import ch.course223.helloworldIvo.domainModells.role.Role;

import java.util.Set;

// This an example class on how a DTO could be built
// A DTO is pretty much just a regular POJO, there is no need for any fancy annotations
// This DTO is a special example as it shows that you don't need to map every single attribute
public class UserDTO {

    // Representative attributes, make sure they are called the same way as the attribute that they represent
    private String id;

    private String username;

    private String password;

    private double salary;

    private Set<Role> roles;

    private Boolean locked;

    private Boolean enabled;

    public UserDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}

