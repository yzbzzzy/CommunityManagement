package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsConfig;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsConfigService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (DsConfig)表控制层
 *
 * @author makejava
 * @since 2023-01-29 15:35:41
 */
@RestController
@RequestMapping("/api/config")
public class DsConfigController {
    /**
     * 服务对象
     */
    @Resource
    private DsConfigService dsConfigService;

    /**
     * 分页查询
     *
     * @param dsConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DsConfig>> queryByPage(DsConfig dsConfig, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dsConfigService.queryByPage(dsConfig, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DsConfig> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dsConfigService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dsConfig 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DsConfig> add(DsConfig dsConfig) {
        return ResponseEntity.ok(this.dsConfigService.insert(dsConfig));
    }

    /**
     * 编辑数据
     *
     * @param dsConfig 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DsConfig> edit(DsConfig dsConfig) {
        return ResponseEntity.ok(this.dsConfigService.update(dsConfig));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dsConfigService.deleteById(id));
    }

    @PostMapping("/queryUnitCost")
    public ResultMap<Float> queryUnitCost(){
        return new ResultMap<>(200,"成功",this.dsConfigService.queryUnitCost());
    }
    @PostMapping("/setUnitCost")
    public  ResultMap<Object> setUnitCost(@RequestBody Map data){
        this.dsConfigService.setUnitCost(Float.valueOf(data.get("price").toString()));
        return new ResultMap<>(200,"成功",null);
    }

}

