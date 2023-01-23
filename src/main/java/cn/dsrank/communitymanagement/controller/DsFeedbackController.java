package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsFeedback;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsFeedbackService;
import cn.dsrank.communitymanagement.service.DsUserService;
import cn.dsrank.communitymanagement.vo.TableFeedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (DsFeedback)表控制层
 *
 * @author makejava
 * @since 2023-01-18 13:34:35
 */
@RestController
@RequestMapping("/api/feedback")
public class DsFeedbackController {
    /**
     * 服务对象
     */
    @Resource
    private DsFeedbackService dsFeedbackService;

    @Resource
    private DsUserService dsUserService;
    /**
     * 分页查询
     *
     * @param dsFeedback 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DsFeedback>> queryByPage(DsFeedback dsFeedback, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dsFeedbackService.queryByPage(dsFeedback, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DsFeedback> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dsFeedbackService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param data 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public ResultMap<Object> add(@RequestBody  Map data) {
        ResultMap<Object> resultMap = new ResultMap<>();
        try{
            this.dsFeedbackService.insert(new DsFeedback(
                    this.dsUserService.queryByName((String)data.get("name")).getId(),
                    (String)data.get("content"),
                    0,
                    (String)data.get("title")
            ));
            resultMap.setCode(200);
            resultMap.setMsg("成功");
        }catch (Exception e){
            resultMap.setCode(301);
            resultMap.setMsg("出现错误");
        }
        return resultMap;
    }

    /**
     * 编辑数据
     *
     * @param dsFeedback 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DsFeedback> edit(DsFeedback dsFeedback) {
        return ResponseEntity.ok(this.dsFeedbackService.update(dsFeedback));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dsFeedbackService.deleteById(id));
    }


    @PostMapping("queryTotalCount")
    public ResultMap<Object> queryTotalCount(){
        ResultMap<Object> resultMap = new ResultMap<>();
        resultMap.setMsg("成功");
        resultMap.setCode(200);
        resultMap.setData(this.dsFeedbackService.queryTotalCount());
        return resultMap;
    }

    /**
     * 分页查询反馈
     * @param data
     * @return
     */
    @PostMapping("queryTableFeedback")
    public ResultMap<List<TableFeedback>> queryTableFeedback(@RequestBody Map data){
        ResultMap<List<TableFeedback>>resultMap  = new ResultMap<>();
        Integer page = (Integer) data.get("page");
        Integer count = (Integer) data.get("count");
        resultMap.setData(this.dsFeedbackService.queryTableFeedback((page-1)*count,count));
        resultMap.setCode(200);
        resultMap.setMsg("成功");
        return resultMap;
    }

}

