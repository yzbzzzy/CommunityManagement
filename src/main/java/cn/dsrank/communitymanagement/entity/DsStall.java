package cn.dsrank.communitymanagement.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DsStall)实体类
 *
 * @author makejava
 * @since 2023-01-27 18:38:27
 */
public class DsStall implements Serializable {
    private static final long serialVersionUID = 652954864612619720L;
    
    private Integer id;
    
    private Integer userid;
    
    private Date starttime;
    
    private Date endtime;
    /**
     * 0 闲置
1 被占用
2 有所属

     */
    private Integer status;


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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}

