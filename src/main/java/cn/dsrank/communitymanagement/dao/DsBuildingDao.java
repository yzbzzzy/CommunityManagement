package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsBuilding;
import cn.dsrank.communitymanagement.entity.DsBuildingInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DsBuilding)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-10 15:41:03
 */
public interface DsBuildingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsBuilding queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DsBuilding> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dsBuilding 实例对象
     * @return 对象列表
     */
    List<DsBuilding> queryAll(DsBuilding dsBuilding);

    /**
     * 新增数据
     *
     * @param dsBuilding 实例对象
     * @return 影响行数
     */
    int insert(DsBuilding dsBuilding);

    /**
     * 修改数据
     *
     * @param dsBuilding 实例对象
     * @return 影响行数
     */
    int update(DsBuilding dsBuilding);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Integer getLastId();

    Integer getCount();

    DsBuildingInfo getBuildInfo(int buildingId);

    float getAreaByUserId(int userid);
    List<DsBuilding> getAll();
}