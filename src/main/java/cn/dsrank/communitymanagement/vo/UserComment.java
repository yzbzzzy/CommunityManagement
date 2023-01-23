package cn.dsrank.communitymanagement.vo;

import lombok.Data;

import java.util.Date;

@Data
public class UserComment {
    private String content;
    private Date time;

    private String username;

    private int identity;
}
