package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsPropertyfee;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DsPropertyfee)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-13 11:03:58
 */
public interface DsPropertyfeeDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsPropertyfee queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param dsPropertyfee 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DsPropertyfee> queryAllByLimit(DsPropertyfee dsPropertyfee, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dsPropertyfee 查询条件
     * @return 总行数
     */
    long count(DsPropertyfee dsPropertyfee);

    /**
     * 新增数据
     *
     * @param dsPropertyfee 实例对象
     * @return 影响行数
     */
    int insert(DsPropertyfee dsPropertyfee);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsPropertyfee> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DsPropertyfee> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsPropertyfee> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DsPropertyfee> entities);

    /**
     * 修改数据
     *
     * @param dsPropertyfee 实例对象
     * @return 影响行数
     */
    int update(DsPropertyfee dsPropertyfee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Integer queryCount();

    List<DsPropertyfee> queryByPage(int start,int count);

    Integer queryUserPayCount(int userid);

    List<DsPropertyfee> queryUserByPage(int userid,int start,int count);

}

