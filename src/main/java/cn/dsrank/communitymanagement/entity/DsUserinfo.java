package cn.dsrank.communitymanagement.entity;

import java.io.Serializable;

/**
 * (DsUserinfo)实体类
 *
 * @author makejava
 * @since 2023-01-09 22:07:40
 */
public class DsUserinfo implements Serializable {
    private static final long serialVersionUID = 143231110776726199L;
    
    private Integer userid;
    
    private String truename;
    
    private String phone;
    
    private Integer buildingid;
    
    private Integer roomid;
    
    private Integer age;
    
    private String gander;
    
    private String email;
    
    private String licenseplatenumber;
    
    private String icon;


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getTruename() {
        return truename;
    }

    public void setTruename(String truename) {
        this.truename = truename;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Integer buildingid) {
        this.buildingid = buildingid;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGander() {
        return gander;
    }

    public void setGander(String gander) {
        this.gander = gander;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLicenseplatenumber() {
        return licenseplatenumber;
    }

    public void setLicenseplatenumber(String licenseplatenumber) {
        this.licenseplatenumber = licenseplatenumber;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @Override
    public String toString() {
        return "DsUserinfo{" +
                "userid=" + userid +
                ", truename='" + truename + '\'' +
                ", phone='" + phone + '\'' +
                ", buildingid=" + buildingid +
                ", roomid=" + roomid +
                ", age=" + age +
                ", gander='" + gander + '\'' +
                ", email='" + email + '\'' +
                ", licenseplatenumber=" + licenseplatenumber +
                ", icon='" + icon + '\'' +
                '}';
    }

    public DsUserinfo(Integer userid, String truename, String phone, Integer buildingid, Integer roomid, Integer age, String gander, String email, String licenseplatenumber, String icon) {
        this.userid = userid;
        this.truename = truename;
        this.phone = phone;
        this.buildingid = buildingid;
        this.roomid = roomid;
        this.age = age;
        this.gander = gander;
        this.email = email;
        this.licenseplatenumber = licenseplatenumber;
        this.icon = icon;
    }

    public DsUserinfo() {
    }
}