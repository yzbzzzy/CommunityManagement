package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsLease;

import java.util.Date;
import java.util.List;

/**
 * (DsLease)表服务接口
 *
 * @author makejava
 * @since 2023-03-03 15:25:23
 */
public interface DsLeaseService {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    DsLease queryById( );

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<DsLease> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param dsLease 实例对象
     * @return 实例对象
     */
    DsLease insert(DsLease dsLease);

    boolean deleteById( );

    void setLease(String username, int id, List<Date> dates);

}