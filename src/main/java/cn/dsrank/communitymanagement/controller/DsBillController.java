package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsBill;
import cn.dsrank.communitymanagement.service.DsBillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (DsBill)表控制层
 *
 * @author makejava
 * @since 2023-01-13 11:22:32
 */
@RestController
@RequestMapping("dsBill")
public class DsBillController {
    /**
     * 服务对象
     */
    @Resource
    private DsBillService dsBillService;

    /**
     * 分页查询
     *
     * @param dsBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DsBill>> queryByPage(DsBill dsBill, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dsBillService.queryByPage(dsBill, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DsBill> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dsBillService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dsBill 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DsBill> add(DsBill dsBill) {
        return ResponseEntity.ok(this.dsBillService.insert(dsBill));
    }

    /**
     * 编辑数据
     *
     * @param dsBill 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DsBill> edit(DsBill dsBill) {
        return ResponseEntity.ok(this.dsBillService.update(dsBill));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dsBillService.deleteById(id));
    }


}

