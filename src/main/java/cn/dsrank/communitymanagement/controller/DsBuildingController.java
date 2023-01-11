package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsBuilding;
import cn.dsrank.communitymanagement.entity.DsBuildingInfo;
import cn.dsrank.communitymanagement.service.DsBuildingService;
import org.hibernate.annotations.Parameter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (DsBuilding)表控制层
 *
 * @author makejava
 * @since 2023-01-10 15:41:03
 */
@RestController
@RequestMapping("/api/building")
public class DsBuildingController {
    /**
     * 服务对象
     */
    @Resource
    private DsBuildingService dsBuildingService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public DsBuilding selectOne(Integer id) {
        return this.dsBuildingService.queryById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/add")
    public Map<String,Object> addBuilding(@RequestBody Map params) {
        HashMap<String, Object> map = new HashMap<>();
        try {
            dsBuildingService.addBuilding(Integer.valueOf((String) params.get("floors")),
                    Integer.valueOf((String)params.get("residents")),
                    (String)params.get("desc"));
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",103);
            map.put("msg","添加失败");
            return map;
        }
        map.put("code",200);
        map.put("msg","添加成功");
        return map;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("infos")
    public Map<String,Object> getBuildingsInfo(){
        Map<String, Object> map = new HashMap<>();
        List<DsBuildingInfo> infos = dsBuildingService.getBuildingInfo();
        map.put("code",200);
        map.put("data",infos);
        return map;
    }

}