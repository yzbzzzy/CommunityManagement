package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsBill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (DsBill)表服务接口
 *
 * @author makejava
 * @since 2023-01-13 11:22:32
 */
public interface DsBillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsBill queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dsBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DsBill> queryByPage(DsBill dsBill, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dsBill 实例对象
     * @return 实例对象
     */
    DsBill insert(DsBill dsBill);

    /**
     * 修改数据
     *
     * @param dsBill 实例对象
     * @return 实例对象
     */
    DsBill update(DsBill dsBill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    DsBill queryStatus(int userid,int propertyFeeId);

}
