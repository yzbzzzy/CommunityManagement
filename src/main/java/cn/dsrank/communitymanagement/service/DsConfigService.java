package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DsConfig)表服务接口
 *
 * @author makejava
 * @since 2023-01-29 15:35:42
 */
public interface DsConfigService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsConfig queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dsConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DsConfig> queryByPage(DsConfig dsConfig, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dsConfig 实例对象
     * @return 实例对象
     */
    DsConfig insert(DsConfig dsConfig);

    /**
     * 修改数据
     *
     * @param dsConfig 实例对象
     * @return 实例对象
     */
    DsConfig update(DsConfig dsConfig);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询单价
     * @author DareSasuke
     * @date 15:36 2023/1/29
     * @param
     * @return java.lang.Float
     **/
    Float queryUnitCost();

    /**
     * 设置单价
     * @author DareSasuke
     * @date 16:16 2023/1/29
     * @param price
     * @return
     **/
    void setUnitCost(Float price);
}
