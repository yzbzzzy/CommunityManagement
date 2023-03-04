package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsStall;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.DsUserinfo;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsStallService;
import cn.dsrank.communitymanagement.service.DsUserService;
import cn.dsrank.communitymanagement.service.DsUserinfoService;
import cn.dsrank.communitymanagement.vo.StallInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (DsStall)表控制层
 *
 * @author makejava
 * @since 2023-01-27 18:38:27
 */
@RestController
@RequestMapping("/api/stall")
public class DsStallController {
    /**
     * 服务对象
     */
    @Resource
    private DsStallService dsStallService;

    @Resource
    private DsUserService dsUserService;

    @Resource
    private DsUserinfoService dsUserinfoService;
    /**
     * 分页查询
     *
     * @param dsStall 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DsStall>> queryByPage(DsStall dsStall, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dsStallService.queryByPage(dsStall, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DsStall> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dsStallService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dsStall 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DsStall> add(DsStall dsStall) {
        return ResponseEntity.ok(this.dsStallService.insert(dsStall));
    }

    /**
     * 编辑数据
     *
     * @param dsStall 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DsStall> edit(DsStall dsStall) {
        return ResponseEntity.ok(this.dsStallService.update(dsStall));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dsStallService.deleteById(id));
    }

    @PostMapping("queryInUse")
    public ResultMap<Integer> queryInUse(){
        Integer count = this.dsStallService.queryBusy();
        return  new ResultMap<Integer>(200,"成功",count);
    }

    @PostMapping("multAdd")
    public ResultMap<Object> multAdd(@RequestBody Map data){
        Integer count = (Integer) data.get("count");
        this.dsStallService.multipleAdd(count);
        return  new ResultMap<>(200,"成功",null);
    }

    @PostMapping("queryStallInfo")
    public ResultMap<List<StallInfo>> queryStallInfo(@RequestBody Map data){
        Integer page = (Integer) data.get("page");
        Integer count = (Integer) data.get("count");
        return new ResultMap<>(200,"成功",this.dsStallService.queryStallInfo(page,count));
    }

    @PostMapping("queryStallByKeyWord")
    public ResultMap<List<StallInfo>> queryStallByKeyWord(@RequestBody Map data){
        String key = (String) data.get("key");
        return new ResultMap<>(200,"成功",this.dsStallService.queryStallByKeyword(key));
    }

    @PostMapping("queryIdle")
    public ResultMap<Integer> queryIdle(){
        return new ResultMap<>(200,"成功",this.dsStallService.queryIdle());
    }
    @PostMapping("postCar")
    public ResultMap<Object> postCar(@RequestBody Map data){
        String name = (String)data.get("name");
        DsUser dsUser = this.dsUserService.queryByName(name);
        this.dsStallService.postCar(dsUser.getId());
        return new ResultMap<>(200,"成功",null);
    }

    @PostMapping("endPostCar")
    public  ResultMap<Object> endPostCar(@RequestBody Map data){
        String name = (String)data.get("name");
        DsUser dsUser = this.dsUserService.queryByName(name);
        this.dsStallService.driveCar(dsUser.getId());
        return new ResultMap<>(200,"成功",null);
    }

    @PostMapping("buyStall")
    public ResultMap<Object> buyStall(@RequestBody Map data){
        String name = (String)data.get("name");
        DsUser dsUser = this.dsUserService.queryByName(name);
        this.dsStallService.buyStall(dsUser.getId());
        DsUserinfo dsUserinfo = this.dsUserinfoService.queryById(dsUser.getId());
        dsUserinfo.setStall(1);
        this.dsUserinfoService.update(dsUserinfo);
        return new ResultMap<>(200,"成功",null);
    }
    @PostMapping("buyStallByMouth/{id}")
    public ResultMap<Object> buyStallByMouth(@PathVariable int id){
        this.dsStallService.buyStallByMouth(id);
        return new ResultMap<>(200,"成功",null);
    }
}

