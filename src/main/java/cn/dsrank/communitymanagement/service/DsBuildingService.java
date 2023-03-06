package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsBuilding;
import cn.dsrank.communitymanagement.entity.DsBuildingInfo;

import java.util.List;

/**
 * (DsBuilding)表服务接口
 *
 * @author makejava
 * @since 2023-01-10 15:41:03
 */
public interface DsBuildingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsBuilding queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DsBuilding> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dsBuilding 实例对象
     * @return 实例对象
     */
    DsBuilding insert(DsBuilding dsBuilding);

    /**
     * 修改数据
     *
     * @param dsBuilding 实例对象
     * @return 实例对象
     */
    DsBuilding update(DsBuilding dsBuilding);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    void addBuilding(int f,int r,String desc,float area);

    List<DsBuildingInfo> getBuildingInfo();
    List<DsBuilding> getAll();

}