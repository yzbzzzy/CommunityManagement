package cn.dsrank.communitymanagement.vo;

import lombok.Data;

import java.util.Date;

/**
 * @ClassName StallInfo
 * @Description TODO
 * @Author DareSasuke
 * @Date 2023/1/28 16:53
 */

@Data
public class StallInfo {
    private String licenseplateNumber;
    private Date startTime;
    private String phone;
}
