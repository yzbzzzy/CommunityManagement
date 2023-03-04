package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsStall;
import cn.dsrank.communitymanagement.vo.StallInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

/**
 * (DsStall)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-27 18:38:27
 */
public interface DsStallDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsStall queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param dsStall 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DsStall> queryAllByLimit(DsStall dsStall, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dsStall 查询条件
     * @return 总行数
     */
    long count(DsStall dsStall);

    /**
     * 新增数据
     *
     * @param dsStall 实例对象
     * @return 影响行数
     */
    int insert(DsStall dsStall);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsStall> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DsStall> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsStall> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DsStall> entities);

    /**
     * 修改数据
     *
     * @param dsStall 实例对象
     * @return 影响行数
     */
    int update(DsStall dsStall);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);


    /**
     * 通过状态查询
     * @Author DareSasuke
     * @Date 19:06 2023/1/27
     * @param status 状态码
     * @return java.lang.Integer
     **/
    Integer queryByStatus(int status);
    
    /**
     * 查询总数
     * @Author DareSasuke
     * @Date 19:14 2023/1/27
     * @param 
     * @return java.lang.Integer
     **/
    Integer queryTotal();

    /**
     * 随机分配车位 测试用
     * @author DareSasuke
     * @date 16:16 2023/1/28
     * @param
     * @return void
     **/
    void randStall();


    /**
     * 查询占用停车位的所有信息
     * @author DareSasuke
     * @date 17:01 2023/1/28
     * @param start 开始位置
     * @param count 数量
     * @return java.util.List<cn.dsrank.communitymanagement.vo.StallInfo>
     **/
    List<StallInfo> queryStallInfo(int start,int count);

    /**
     * 根据关键字查询
     * @author DareSasuke
     * @date 19:42 2023/1/28
     * @param keyword
     * @return java.util.List<cn.dsrank.communitymanagement.vo.StallInfo>
     **/
    List<StallInfo> queryStallByKeyword(String keyword);

    /**
     * 停车
     * @author DareSasuke
     * @date 11:01 2023/2/2
     * @param id 用户id
     * @return void
     **/
    void postCar(int id);
    
    /**
     * 停车结束
     * @author DareSasuke
     * @date 11:46 2023/2/2
     * @param id
     * @return void
     **/
    void driveCar(int id);

    void buyStall(int id);

    void buyStallByMouth(int id, Date time);
}

