package cn.dsrank.communitymanagement.controller;

import cn.dsrank.communitymanagement.entity.DsRoom;
import cn.dsrank.communitymanagement.entity.ResultMap;
import cn.dsrank.communitymanagement.service.DsRoomService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DsRoom)表控制层
 *
 * @author makejava
 * @since 2023-01-11 11:30:19
 */
@RestController
@RequestMapping("/api/dsRoom")
public class DsRoomController {
    /**
     * 服务对象
     */
    @Resource
    private DsRoomService dsRoomService;

    /**
     * 分页查询
     *
     * @param dsRoom 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<DsRoom>> queryByPage(DsRoom dsRoom, PageRequest pageRequest) {
        return ResponseEntity.ok(this.dsRoomService.queryByPage(dsRoom, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<DsRoom> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.dsRoomService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param dsRoom 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<DsRoom> add(DsRoom dsRoom) {
        return ResponseEntity.ok(this.dsRoomService.insert(dsRoom));
    }

    /**
     * 编辑数据
     *
     * @param dsRoom 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<DsRoom> edit(DsRoom dsRoom) {
        return ResponseEntity.ok(this.dsRoomService.update(dsRoom));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.dsRoomService.deleteById(id));
    }

    @PostMapping("getRoomById/{id}")
    public ResultMap<Object> getRoomById(@PathVariable int id){
        List<DsRoom> dsRooms = this.dsRoomService.queryByBuilding(id);
        return  new ResultMap<>(200,"成功",dsRooms);
    }
}

