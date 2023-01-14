package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.dao.DsUserDao;
import cn.dsrank.communitymanagement.entity.DsBill;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsBillService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * (DsBill)表控制层
 *
 * @author makejava
 * @since 2023-01-13 11:22:32
 */
@RestController
@RequestMapping("/api/bill")
public class DsBillController {
    /**
     * 服务对象
     */
    @Resource
    private DsBillService dsBillService;

    @Resource
    private DsUserDao dsUserDao;
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


    @Transactional
    @PostMapping("pay")
    public ResultMap<Object> pay(@RequestBody Map data){
        ResultMap<Object> result = new ResultMap<>();
        DsBill bill = new DsBill();
        bill.setPropertyfeeid((Integer) data.get("feeid"));
        bill.setUserid(dsUserDao.queryByName((String)data.get("name")).getId());
        try {
            DsBill insert = dsBillService.insert(bill);
            result.setCode(200);
            result.setMsg("支付成功");

        }catch (Exception e){
            result.setCode(301);
            result.setMsg("出现错误");
        }
        return result;
    }

}

