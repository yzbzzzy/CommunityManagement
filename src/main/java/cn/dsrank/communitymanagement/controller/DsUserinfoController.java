package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.dao.DsUserDao;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.DsUserinfo;
import cn.dsrank.communitymanagement.service.DsUserinfoService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * (DsUserinfo)表控制层
 *
 * @author makejava
 * @since 2023-01-09 22:07:40
 */
@RestController
@RequestMapping("/api/userinfo/")
public class DsUserinfoController {
    /**
     * 服务对象
     */
    @Resource
    private DsUserinfoService dsUserinfoService;
    @Resource
    DsUserDao dsUserDao;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Map<String,Object> selectOne(Integer id) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("data",this.dsUserinfoService.queryById(id));
        map.put("code",200);
        return map;
    }

    @PostMapping("update")
    public Map<String,Object> update(@RequestBody Map data){
        DsUser user = dsUserDao.queryByName((String) data.get("name"));
        Map<String,Object> map = (HashMap)data.get("form");
        DsUserinfo userinfo = dsUserinfoService.queryById(user.getId());
        userinfo.setAge(Integer.valueOf( map.get("age").toString()));
        userinfo.setTruename((String)map.get("truename"));
        userinfo.setEmail((String)map.get("email"));
        userinfo.setGander((String)map.get("gander"));
        userinfo.setLicenseplatenumber((String)map.get("licenseplatenumber"));
        userinfo.setPhone((String)map.get("phone"));
        userinfo.setUserid(user.getId());
        DsUserinfo update = dsUserinfoService.update(userinfo);
        map = new HashMap<String,Object>();
        map.put("code",200);
        map.put("data",update);
        return map;
    }

}