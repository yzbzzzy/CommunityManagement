package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.DsUserinfo;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsUserService;
import cn.dsrank.communitymanagement.service.DsUserinfoService;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (DsUser)表控制层
 *
 * @author makejava
 * @since 2023-01-06 21:39:40
 */
@RestController
@RequestMapping("api/users/")
public class DsUserController {
    /**
     * 服务对象
     */
    @Resource
    private DsUserService dsUserService;
    @Resource
    private DsUserinfoService dsUserinfoService;

    @PostMapping("register")
    public ResponseEntity<Void> register(@RequestBody @Valid DsUser userRegister){
        dsUserService.insert(userRegister);
        return ResponseEntity.ok().build();
    }
    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN') ")
    @GetMapping("selectOne")
    public DsUser selectOne(Integer id) {
        return this.dsUserService.queryById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
    @GetMapping("count")
    public int getCount(){
        return  dsUserService.queryCount();
    }

    @PostMapping("getuserinfo")
    public Map<String,Object> getUserInfo(@RequestBody Map data){
        HashMap<String, Object> map = new HashMap<>();
        DsUser user = dsUserService.queryByName((String)data.get("name"));
        DsUserinfo userinfo = dsUserinfoService.queryById(user.getId());
        map.put("data",userinfo);
        map.put("code",200);
        return map;
    }

    @PostMapping("getUserCount")
    public ResultMap<Integer> getUserCount(){
        Integer userCount = this.dsUserService.getUserCount();
        return new ResultMap<>(200,"成功",userCount);
    }
    @PostMapping("getUser")
    public ResultMap<List<DsUser>> getUserByPage(@RequestBody Map data){
        Integer page = (Integer) data.get("page");
        Integer count = (Integer) data.get("count");
        List<DsUser> userByPage = this.dsUserService.getUserByPage(page, count);
        return new ResultMap<>(200,"成功",userByPage);
    }



}