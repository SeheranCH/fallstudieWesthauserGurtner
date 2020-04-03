package ch.noseryoung.uk.domainModels.role.dto;

import ch.noseryoung.uk.domainModels.authority.Authority;

import java.util.Set;

public class RoleDTO {

    private int id;

    private String name;

    private Set<Authority> authorities;

    public RoleDTO() {}

    public int getId() {
        return id;
    }

    public RoleDTO setId(int id) {
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
