package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsLease;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsLeaseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (DsLease)表控制层
 *
 * @author makejava
 * @since 2023-03-03 15:25:24
 */
@RestController
@RequestMapping("/api/lease")
public class DsLeaseController {

    @Resource
    private  DsLeaseService dsLeaseService;

    @PostMapping("/setLease")
    public ResultMap<Object> setLease(@RequestBody Map map){
        Integer userid = (Integer)map.get("userid");
        List<Long> time = (List<Long>)map.get("time");
        ArrayList<Date> dates = new ArrayList<>();
        dates.add(new Date(time.get(0)));
        dates.add(new Date(time.get(1)));
        String username = (String)map.get("username");
        this.dsLeaseService.setLease(username,userid,dates);
        return new ResultMap<>(200,"成功",null);
    }

}