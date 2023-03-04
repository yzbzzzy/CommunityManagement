package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsLease;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (DsLease)表数据库访问层
 *
 * @author makejava
 * @since 2023-03-03 15:25:22
 */
public interface DsLeaseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    DsLease queryById( );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DsLease> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param dsLease 实例对象
     * @return 对象列表
     */
    List<DsLease> queryAll(DsLease dsLease);

    /**
     * 新增数据
     *
     * @param dsLease 实例对象
     * @return 影响行数
     */
    int insert(DsLease dsLease);

    /**
     * 修改数据
     *
     * @param dsLease 实例对象
     * @return 影响行数
     */
    int update(DsLease dsLease);


    int deleteById( );

    Integer getLeaser(int id);
}