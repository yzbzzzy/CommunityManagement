package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsConfig;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DsConfig)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-29 15:35:41
 */
public interface DsConfigDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsConfig queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param dsConfig 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DsConfig> queryAllByLimit(DsConfig dsConfig, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dsConfig 查询条件
     * @return 总行数
     */
    long count(DsConfig dsConfig);

    /**
     * 新增数据
     *
     * @param dsConfig 实例对象
     * @return 影响行数
     */
    int insert(DsConfig dsConfig);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsConfig> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DsConfig> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsConfig> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DsConfig> entities);

    /**
     * 修改数据
     *
     * @param dsConfig 实例对象
     * @return 影响行数
     */
    int update(DsConfig dsConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    
    /**
     * 查询单价
     * @author DareSasuke
     * @date 15:37 2023/1/29
     * @param 
     * @return java.lang.Float
     **/
    Float queryUnitCost();

    /**
     * 设置单价
     * @author DareSasuke
     * @date 16:15 2023/1/29
     * @param price
     * @return void
     **/
    void setUnitCost(Float price);
}

