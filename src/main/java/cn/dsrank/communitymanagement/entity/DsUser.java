package cn.dsrank.communitymanagement.entity;

import java.io.Serializable;

/**
 * (DsUser)实体类
 *
 * @author makejava
 * @since 2023-01-06 21:39:37
 */
public class DsUser implements Serializable {
    private static final long serialVersionUID = -59156211975158499L;
    
    private Integer id;
    
    private String username;
    
    private String password;
    
    private String salt;
    
    private Integer identity;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public DsUser(Integer id, String username, String password, String salt, Integer identity) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "DsUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", identity=" + identity +
                '}';
    }

    public DsUser(String username, String password,String salt,int identity) {
        this.username = username;
        this.password = password;
        this.salt=salt;
        this.identity=identity;
    }

    public DsUser() {
    }
}