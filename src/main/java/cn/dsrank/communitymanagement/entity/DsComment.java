package cn.dsrank.communitymanagement.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DsComment)实体类
 *
 * @author makejava
 * @since 2023-01-18 13:34:47
 */
public class DsComment implements Serializable {
    private static final long serialVersionUID = -18977571875982464L;
    
    private Integer id;
    
    private Integer feedbackid;
    
    private Integer userid;
    
    private String content;
    
    private Date time;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFeedbackid() {
        return feedbackid;
    }

    public void setFeedbackid(Integer feedbackid) {
        this.feedbackid = feedbackid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public DsComment() {
    }

    public DsComment(Integer feedbackid, Integer userid, String content) {
        this.feedbackid = feedbackid;
        this.userid = userid;
        this.content = content;
    }
}

