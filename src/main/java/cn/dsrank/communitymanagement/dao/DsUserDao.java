package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsUser;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DsUser)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-06 21:39:39
 */
public interface DsUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsUser queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DsUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dsUser 实例对象
     * @return 对象列表
     */
    List<DsUser> queryAll(DsUser dsUser);

    /**
     * 新增数据
     *
     * @param dsUser 实例对象
     * @return 影响行数
     */
    int insert(DsUser dsUser);

    /**
     * 修改数据
     *
     * @param dsUser 实例对象
     * @return 影响行数
     */
    int update(DsUser dsUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    DsUser queryByName(String name);

    // 查询业主人数
    int queryCount();

    List<DsUser> getUserByPage(int start, Integer count);
}