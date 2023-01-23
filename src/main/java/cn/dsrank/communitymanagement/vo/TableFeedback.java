package cn.dsrank.communitymanagement.vo;

import lombok.Data;

import java.util.Date;

@Data
public class TableFeedback {
    private int id;
    private Date date;

    private String title;

    private int status;

    private String username;
}
