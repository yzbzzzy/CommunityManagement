package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsBuildingInfo;
import cn.dsrank.communitymanagement.entity.DsRoom;
import cn.dsrank.communitymanagement.dao.DsRoomDao;
import cn.dsrank.communitymanagement.service.DsRoomService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (DsRoom)表服务实现类
 *
 * @author makejava
 * @since 2023-01-11 11:30:21
 */
@Service("dsRoomService")
public class DsRoomServiceImpl implements DsRoomService {
    @Resource
    private DsRoomDao dsRoomDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsRoom queryById(Integer id) {
        return this.dsRoomDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dsRoom 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DsRoom> queryByPage(DsRoom dsRoom, PageRequest pageRequest) {
        long total = this.dsRoomDao.count(dsRoom);
        return new PageImpl<>(this.dsRoomDao.queryAllByLimit(dsRoom, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dsRoom 实例对象
     * @return 实例对象
     */
    @Override
    public DsRoom insert(DsRoom dsRoom) {
        this.dsRoomDao.insert(dsRoom);
        return dsRoom;
    }

    /**
     * 修改数据
     *
     * @param dsRoom 实例对象
     * @return 实例对象
     */
    @Override
    public DsRoom update(DsRoom dsRoom) {
        this.dsRoomDao.update(dsRoom);
        return this.queryById(dsRoom.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsRoomDao.deleteById(id) > 0;
    }

    @Override
    public Integer getFloors(int buildingId) {
        return null;
    }

    @Override
    public Integer getRooms(int buildingId) {
        return null;
    }

    @Override
    public Integer getEmpRooms(int buildingId) {
        return null;
    }

    @Override
    public Integer getPreRooms(int buildingId) {
        return null;
    }


}
