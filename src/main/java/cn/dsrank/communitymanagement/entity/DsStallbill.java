package cn.dsrank.communitymanagement.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DsStallbill)实体类
 *
 * @author makejava
 * @since 2023-02-02 10:58:22
 */
public class DsStallbill implements Serializable {
    private static final long serialVersionUID = -88363135353585881L;
    
    private Integer id;
    
    private Integer userid;
    
    private Date starttime;
    
    private Date endtime;
    
    private Float fee;


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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public Float getFee() {
        return fee;
    }

    public void setFee(Float fee) {
        this.fee = fee;
    }

}

