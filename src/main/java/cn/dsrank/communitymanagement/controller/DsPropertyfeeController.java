package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsPropertyfee;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsPropertyfeeService;
import cn.dsrank.communitymanagement.service.DsUserService;
import cn.dsrank.communitymanagement.vo.TableFee;
import cn.dsrank.communitymanagement.vo.UserTableFee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * (DsPropertyfee)表控制层
 *
 * @author makejava
 * @since 2023-01-13 11:03:58
 */
@RestController

@RequestMapping("/api/fee")
public class DsPropertyfeeController {
    /**
     * 服务对象
     */
    @Resource
    private DsPropertyfeeService dsPropertyfeeService;

    @Resource
    private DsUserService dsUserService;
    /**
     * 分页查询
     *
     * @param dsPropertyfee 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DsPropertyfee>> queryByPage(DsPropertyfee dsPropertyfee, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dsPropertyfeeService.queryByPage(dsPropertyfee, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
    @GetMapping("{id}")
    public ResponseEntity<DsPropertyfee> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dsPropertyfeeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dsPropertyfee 实体
     * @return 新增结果
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping
    public ResponseEntity<DsPropertyfee> add(DsPropertyfee dsPropertyfee) {
        return ResponseEntity.ok(this.dsPropertyfeeService.insert(dsPropertyfee));
    }

    /**
     * 编辑数据
     *
     * @param dsPropertyfee 实体
     * @return 编辑结果
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
    @PutMapping
    public ResponseEntity<DsPropertyfee> edit(DsPropertyfee dsPropertyfee) {
        return ResponseEntity.ok(this.dsPropertyfeeService.update(dsPropertyfee));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dsPropertyfeeService.deleteById(id));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping("querypage")
    public ResultMap<List<TableFee>> getPageData(@RequestBody Map data){
        Integer count = (Integer) data.get("count");
        Integer page = (Integer) data.get("page");
        List<TableFee> list = dsPropertyfeeService.queryByPage((page-1)*count,count);
        ResultMap<List<TableFee>> resultMap = new ResultMap<>();
        resultMap.setData(list);
        resultMap.setCode(200);
        resultMap.setMsg("成功");
        return resultMap;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping("add")
    public ResultMap<Object> addFee(@RequestBody DsPropertyfee form){
        ResultMap<Object> map = new ResultMap<>();
        try{
        dsPropertyfeeService.insert(form);
        map.setCode(200);
        map.setMsg("添加成功");
        return  map;
        }catch (Exception e){
            map.setMsg("出现错误");
            map.setCode(301);
            return map;
        }

    }

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_SUPER_ADMIN')")
    @PostMapping("count")
    public ResultMap<Integer> getCount(){
        Integer count = dsPropertyfeeService.queryCount();
        ResultMap<Integer> result = new ResultMap<>();
        result.setData(count);
        result.setMsg("success");
        result.setCode(200);
        return result;
    }


    @PostMapping("/queryUserPayCount")
    public ResultMap<Integer> queryUserPayCount(@RequestBody Map data){
        ResultMap<Integer> re = new ResultMap<>();
        Optional<Integer> optional =  Optional.ofNullable(dsPropertyfeeService.queryUserPayCount(dsUserService.queryByName((String)data.get("name")).getId()));
        re.setData(optional.orElse(0));
        re.setCode(200);
        re.setMsg("成功");
        return  re;
    }

    @PostMapping("queryUserBillData")
    public ResultMap<List<UserTableFee>>  queryUserPayData(@RequestBody Map data){
        ResultMap<List<UserTableFee>> re = new ResultMap<>();
        Integer count = (Integer) data.get("count");
        Integer page = (Integer) data.get("page");
        List<UserTableFee> userTableFees = dsPropertyfeeService.queryUserPayData(
                dsUserService.queryByName((String) data.get("name")).getId()
                , (page - 1) * count
                , count
        );
        re.setData(userTableFees);
        re.setCode(200);
        re.setMsg("成功");
        return re;
    }

}

