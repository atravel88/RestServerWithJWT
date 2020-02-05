package ru.atavrel.restserverdemo.dto;

import java.util.List;

public class AuthenticationResponseDTO {

    private String jwtToken;
    private List<String> roleList;

    public AuthenticationResponseDTO() {
    }

    public AuthenticationResponseDTO(String jwtToken, List<String> roleList) {
        this.jwtToken = jwtToken;
        this.roleList = roleList;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public List<String> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<String> roleList) {
        this.roleList = roleList;
    }
}
