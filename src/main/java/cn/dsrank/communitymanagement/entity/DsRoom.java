package cn.dsrank.communitymanagement.entity;

import java.io.Serializable;

/**
 * (DsRoom)实体类
 *
 * @author makejava
 * @since 2023-01-11 11:30:21
 */
public class DsRoom implements Serializable {
    private static final long serialVersionUID = -49418048851140736L;
    
    private Integer id;
    
    private Integer buildingid;
    
    private Integer floor;
    
    private Integer number;
    
    private Integer status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Integer buildingid) {
        this.buildingid = buildingid;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public DsRoom(Integer buildingid, Integer floor, Integer number, Integer status) {
        this.buildingid = buildingid;
        this.floor = floor;
        this.number = number;
        this.status = status;
    }

    public DsRoom() {
    }
}

