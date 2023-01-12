package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsUserinfo;
import java.util.List;

/**
 * (DsUserinfo)表服务接口
 *
 * @author makejava
 * @since 2023-01-09 22:07:40
 */
public interface DsUserinfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    DsUserinfo queryById(Integer userid);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DsUserinfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dsUserinfo 实例对象
     * @return 实例对象
     */
    DsUserinfo insert(DsUserinfo dsUserinfo);

    /**
     * 修改数据
     *
     * @param dsUserinfo 实例对象
     * @return 实例对象
     */
    DsUserinfo update(DsUserinfo dsUserinfo);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userid);

}