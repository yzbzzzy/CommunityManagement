package cn.dsrank.communitymanagement.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (DsPropertyfee)实体类
 *
 * @author makejava
 * @since 2023-01-13 11:03:58
 */

@Data
public class DsPropertyfee implements Serializable {
    private static final long serialVersionUID = 240913284154024567L;
    
    private Integer id;
    
    private Float price;
    
    private String desc;

    private java.util.Date time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}

