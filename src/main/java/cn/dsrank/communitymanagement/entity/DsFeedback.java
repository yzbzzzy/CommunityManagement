package cn.dsrank.communitymanagement.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (DsFeedback)实体类
 *
 * @author makejava
 * @since 2023-01-18 13:34:36
 */
public class DsFeedback implements Serializable {
    private static final long serialVersionUID = 604083064360414087L;
    
    private Integer id;
    
    private Integer userid;
    
    private String content;
    
    private Date date;
    
    private Integer status;
    
    private String title;


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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DsFeedback() {

    }

    public DsFeedback(Integer userid, String content, Integer status, String title) {
        this.userid = userid;
        this.content = content;
        this.status = status;
        this.title = title;
    }
}

