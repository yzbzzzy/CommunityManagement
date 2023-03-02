package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsStallbill;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsStallbillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (DsStallbill)表控制层
 *
 * @author makejava
 * @since 2023-02-02 10:58:22
 */
@RestController
@RequestMapping("/api/stall/bill")
public class DsStallbillController {
    /**
     * 服务对象
     */
    @Resource
    private DsStallbillService dsStallbillService;

    /**
     * 分页查询
     *
     * @param dsStallbill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DsStallbill>> queryByPage(DsStallbill dsStallbill, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dsStallbillService.queryByPage(dsStallbill, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DsStallbill> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dsStallbillService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dsStallbill 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DsStallbill> add(DsStallbill dsStallbill) {
        return ResponseEntity.ok(this.dsStallbillService.insert(dsStallbill));
    }

    /**
     * 编辑数据
     *
     * @param dsStallbill 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DsStallbill> edit(DsStallbill dsStallbill) {
        return ResponseEntity.ok(this.dsStallbillService.update(dsStallbill));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dsStallbillService.deleteById(id));
    }

    @PostMapping("queryStallBill")
    public ResultMap<List<DsStallbill>> queryStallBill(@RequestBody Map data){
        String username = (String) data.get("username");
        List<DsStallbill> dsStallbills = this.dsStallbillService.queryStallBill(username);
        return new ResultMap<>(200,"成功",dsStallbills);
    }

}

