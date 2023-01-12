package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsBuildingInfo;
import cn.dsrank.communitymanagement.entity.DsRoom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DsRoom)表服务接口
 *
 * @author makejava
 * @since 2023-01-11 11:30:21
 */
public interface DsRoomService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsRoom queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dsRoom 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DsRoom> queryByPage(DsRoom dsRoom, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dsRoom 实例对象
     * @return 实例对象
     */
    DsRoom insert(DsRoom dsRoom);

    /**
     * 修改数据
     *
     * @param dsRoom 实例对象
     * @return 实例对象
     */
    DsRoom update(DsRoom dsRoom);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    //获取楼层数
    Integer getFloors(int buildingId);
    //获取总共房间数
    Integer getRooms(int buildingId);
    //获取空房间数
    Integer getEmpRooms(int buildingId);

    Integer getPreRooms(int buildingId);


}
