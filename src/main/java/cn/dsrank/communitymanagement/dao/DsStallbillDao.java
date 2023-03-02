package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsStallbill;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DsStallbill)表数据库访问层
 *
 * @author makejava
 * @since 2023-02-02 10:58:22
 */
public interface DsStallbillDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsStallbill queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param dsStallbill 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DsStallbill> queryAllByLimit(DsStallbill dsStallbill, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dsStallbill 查询条件
     * @return 总行数
     */
    long count(DsStallbill dsStallbill);

    /**
     * 新增数据
     *
     * @param dsStallbill 实例对象
     * @return 影响行数
     */
    int insert(DsStallbill dsStallbill);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsStallbill> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DsStallbill> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsStallbill> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DsStallbill> entities);

    /**
     * 修改数据
     *
     * @param dsStallbill 实例对象
     * @return 影响行数
     */
    int update(DsStallbill dsStallbill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    /**
     * 停车计时
     * @author DareSasuke
     * @date 11:17 2023/2/2
     * @param id 用户id
     * @return void
     **/
    void  postCarStart(Integer id);
    
    /**
     * 停车结束
     * @author DareSasuke
     * @date 11:30 2023/2/2
     * @param id
     * @return void
     **/
    void postCarEnd(Integer id);
    
    /**
     * 设置价格
     * @author DareSasuke
     * @date 11:32 2023/2/2
     * @param id
     * @return void
     **/
    void updatePrice(Integer id);
    
    /**
     * 最后一次记录
     * @author DareSasuke
     * @date 11:33 2023/2/2
     * @param id
     * @return cn.dsrank.communitymanagement.entity.DsStallbill
     **/
    DsStallbill getEnd(Integer id);

    void setFee(Integer id,Float fee);

    /**
     * 查询用户的所有停车记录
     * @author DareSasuke
     * @date 15:59 2023/2/3
     * @param id
     * @return java.util.List<cn.dsrank.communitymanagement.entity.DsStallbill>
     **/
    List<DsStallbill> queryUserBill(Integer id);
}

