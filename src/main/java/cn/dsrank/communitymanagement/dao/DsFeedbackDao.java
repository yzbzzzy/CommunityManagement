package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsFeedback;
import cn.dsrank.communitymanagement.vo.TableFeedback;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DsFeedback)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-18 13:34:36
 */
public interface DsFeedbackDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsFeedback queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param dsFeedback 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DsFeedback> queryAllByLimit(DsFeedback dsFeedback, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dsFeedback 查询条件
     * @return 总行数
     */
    long count(DsFeedback dsFeedback);

    /**
     * 新增数据
     *
     * @param dsFeedback 实例对象
     * @return 影响行数
     */
    int insert(DsFeedback dsFeedback);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsFeedback> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DsFeedback> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsFeedback> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DsFeedback> entities);

    /**
     * 修改数据
     *
     * @param dsFeedback 实例对象
     * @return 影响行数
     */
    int update(DsFeedback dsFeedback);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 查询反馈中条数
     * @return
     */
    Integer queryTotalCount();


    /**
     * 分页查询反馈列表
     * @param page
     * @param count
     * @return
     */
    List<TableFeedback> queryTableFeedback(int page,int count);

}

