package cn.dsrank.communitymanagement.utils;

import java.util.Date;

/**
 * @ClassName DateUtils
 * @Description TODO
 * @Author DareSasuke
 * @Date 2023/2/2 11:29
 */

public class DateUtils {
    public static int getDifferHour(Date startDate, Date endDate) {
        long dayM = 1000 * 24 * 60 * 60;
        long hourM = 1000 * 60 * 60;
        long differ = endDate.getTime() - startDate.getTime();
        long hour = differ % dayM / hourM + 24 * (differ / dayM);
        return Integer.parseInt(String.valueOf(hour));
    }
}
