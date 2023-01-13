package cn.dsrank.communitymanagement.entity;

import java.io.Serializable;

/**
 * (DsBuilding)实体类
 *
 * @author makejava
 * @since 2023-01-10 15:41:03
 */
public class DsBuilding implements Serializable {
    private static final long serialVersionUID = 704058559580935093L;
    
    private Integer id;
    
    private String desc;


    private float area;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public DsBuilding(Integer id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public DsBuilding() {

    }

    public DsBuilding(Integer id, String desc, float area) {
        this.id = id;
        this.desc = desc;
        this.area = area;
    }
}