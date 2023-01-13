package cn.dsrank.communitymanagement.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DsBill)实体类
 *
 * @author makejava
 * @since 2023-01-13 11:22:32
 */
public class DsBill implements Serializable {
    private static final long serialVersionUID = 393347687197981398L;
    
    private Integer id;
    
    private Integer userid;
    
    private Integer propertyfeeid;
    
    private Date date;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getPropertyfeeid() {
        return propertyfeeid;
    }

    public void setPropertyfeeid(Integer propertyfeeid) {
        this.propertyfeeid = propertyfeeid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

