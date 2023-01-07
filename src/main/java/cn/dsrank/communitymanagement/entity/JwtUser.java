package cn.dsrank.communitymanagement.entity;

import lombok.Data;


public class JwtUser {
    private DsUser user;

    private String token;

    public DsUser getUser() {
        return user;
    }

    public void setUser(DsUser user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JwtUser( String token,DsUser user) {
        this.user = user;
        this.token = token;
    }
}
