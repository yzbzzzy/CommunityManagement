package cn.dsrank.communitymanagement.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DsLease)实体类
 *
 * @author makejava
 * @since 2023-03-03 16:03:42
 */
public class DsLease implements Serializable {
    private static final long serialVersionUID = 825976189507369329L;
    
    private Integer userid;
    
    private Date starttime;
    
    private Date endtime;
    
    private Integer hostid;


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

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

}