package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsUser;
import java.util.List;

/**
 * (DsUser)表服务接口
 *
 * @author makejava
 * @since 2023-01-06 21:39:39
 */
public interface DsUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DsUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dsUser 实例对象
     * @return 实例对象
     */
    DsUser insert(DsUser dsUser);

    /**
     * 修改数据
     *
     * @param dsUser 实例对象
     * @return 实例对象
     */
    DsUser update(DsUser dsUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    DsUser queryByName(String name);

    int queryCount();

    Integer getUserCount();

    List<DsUser> getUserByPage(Integer page, Integer count);
}