package ch.noseryoung.uk.domainModels.role.dto;

import ch.noseryoung.uk.domainModels.authority.Authority;

import java.util.Set;

public class RoleDTO {

    // Representative attributes, make sure they are called the same way as the attribute that they represent
    private String id;

    private String name;

    private Set<Authority> authorities;

    // Standard empty constructor
    public RoleDTO() {}

    // Standard getters and setters
    public String getId() {
        return id;
    }

    public RoleDTO setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoleDTO setName(String name) {
        this.name = name;
        return this;
    }

    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public RoleDTO setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
        return this;
    }
}
