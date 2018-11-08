package com.brokerage.payload;

import com.brokerage.model.RoleName;

import java.util.List;

public class ListRolesResponse {
    List<RoleName> roles;

    public List<RoleName> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleName> roles) {
        this.roles = roles;
    }
}
