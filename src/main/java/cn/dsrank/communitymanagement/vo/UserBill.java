package cn.dsrank.communitymanagement.vo;

import lombok.Data;

import java.util.Date;


@Data
public class UserBill {
    private float area;
    private float price;
    private Date date;

    private String desc;
}
