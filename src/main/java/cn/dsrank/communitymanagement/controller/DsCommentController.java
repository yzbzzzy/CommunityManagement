package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsComment;
import cn.dsrank.communitymanagement.entity.DsFeedback;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsCommentService;
import cn.dsrank.communitymanagement.service.DsFeedbackService;
import cn.dsrank.communitymanagement.service.DsUserService;
import cn.dsrank.communitymanagement.vo.UserComment;
import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * (DsComment)表控制层
 *
 * @author makejava
 * @since 2023-01-18 13:29:53
 */
@RestController
@RequestMapping("/api/comment")
public class DsCommentController {
    /**
     * 服务对象
     */
    @Resource
    private DsCommentService dsCommentService;

    @Resource
    private DsUserService dsUserService;

    @Resource
    private DsFeedbackService dsFeedbackService;

    /**
     * 分页查询
     *
     * @param dsComment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DsComment>> queryByPage(DsComment dsComment, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dsCommentService.queryByPage(dsComment, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DsComment> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dsCommentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param data 实体
     * @return 新增结果
     */
    @PostMapping("add")
    public ResultMap<Object> add(@RequestBody Map data) {
        ResultMap<Object> resultMap = new ResultMap<>();
        DsUser user = dsUserService.queryByName((String) data.get("name"));
        DsComment comment = new DsComment((Integer)data.get("id")
                ,user.getId()
                ,(String)data.get("content"));
        dsCommentService.insert(comment);
        if(user.getIdentity()==1){
            DsFeedback fee = dsFeedbackService.queryById((Integer) data.get("id"));
            fee.setStatus(1);
            dsFeedbackService.update(fee);
        }
        resultMap.setMsg("成功");
        resultMap.setCode(200);
        return resultMap;
    }

    /**
     * 编辑数据
     *
     * @param dsComment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DsComment> edit(DsComment dsComment) {
        return ResponseEntity.ok(this.dsCommentService.update(dsComment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dsCommentService.deleteById(id));
    }

    @PostMapping("queryAllUserComment")
    public ResultMap<List<UserComment>> queryAllUserComment(@RequestBody Map data){
        ResultMap<List<UserComment>> resltMap = new ResultMap<List<UserComment>>();
        List<UserComment> comments = dsCommentService.queryAllComment((Integer) data.get("id"));
        resltMap.setData(Optional.ofNullable(comments).orElse(new ArrayList<UserComment>()));
        resltMap.setCode(200);
        resltMap.setMsg("成功");
        return  resltMap;
    }
}

