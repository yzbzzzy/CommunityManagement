package cn.dsrank.communitymanagement.entity;

import lombok.Data;

@Data
public class DsBuildingInfo {
    private Integer floors;
    private Integer preResidents;
    private Integer empRooms;
    private Integer occRooms;
    private String desc;
    private float area;
}
