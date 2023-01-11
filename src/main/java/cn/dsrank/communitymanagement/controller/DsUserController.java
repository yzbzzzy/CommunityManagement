package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.service.DsUserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

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
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("selectOne")
    public DsUser selectOne(Integer id) {
        return this.dsUserService.queryById(id);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("count")
    public int getCount(){
        return  dsUserService.queryCount();
    }

}