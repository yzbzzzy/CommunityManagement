package cn.dsrank.communitymanagement.dao;

import cn.dsrank.communitymanagement.entity.DsRoom;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DsRoom)表数据库访问层
 *
 * @author makejava
 * @since 2023-01-11 11:30:20
 */
public interface DsRoomDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsRoom queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param dsRoom 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DsRoom> queryAllByLimit(DsRoom dsRoom, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param dsRoom 查询条件
     * @return 总行数
     */
    long count(DsRoom dsRoom);

    /**
     * 新增数据
     *
     * @param dsRoom 实例对象
     * @return 影响行数
     */
    int insert(DsRoom dsRoom);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsRoom> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DsRoom> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DsRoom> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DsRoom> entities);

    /**
     * 修改数据
     *
     * @param dsRoom 实例对象
     * @return 影响行数
     */
    int update(DsRoom dsRoom);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    DsRoom getRandRoom();

    List<DsRoom> queryByBuilding(int id);
}

