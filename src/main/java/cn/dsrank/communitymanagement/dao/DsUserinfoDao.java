package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsUserinfo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * (DsUserinfo)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-09 22:07:40
 */
public interface DsUserinfoDao {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    DsUserinfo queryById(Integer userid);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DsUserinfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dsUserinfo 实例对象
     * @return 对象列表
     */
    List<DsUserinfo> queryAll(DsUserinfo dsUserinfo);

    /**
     * 新增数据
     *
     * @param dsUserinfo 实例对象
     * @return 影响行数
     */
    int insert(DsUserinfo dsUserinfo);

    /**
     * 修改数据
     *
     * @param dsUserinfo 实例对象
     * @return 影响行数
     */
    int update(DsUserinfo dsUserinfo);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 影响行数
     */
    int deleteById(Integer userid);

    DsUserinfo getRandUserinfo();

    Integer queryCountBefore(int feeId);
}