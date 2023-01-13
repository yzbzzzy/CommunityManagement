package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsBill;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DsBill)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-13 11:22:32
 */
public interface DsBillDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsBill queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param dsBill 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DsBill> queryAllByLimit(DsBill dsBill, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dsBill 查询条件
     * @return 总行数
     */
    long count(DsBill dsBill);

    /**
     * 新增数据
     *
     * @param dsBill 实例对象
     * @return 影响行数
     */
    int insert(DsBill dsBill);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsBill> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DsBill> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsBill> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DsBill> entities);

    /**
     * 修改数据
     *
     * @param dsBill 实例对象
     * @return 影响行数
     */
    int update(DsBill dsBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    Integer queryExistCount(int id);

}

