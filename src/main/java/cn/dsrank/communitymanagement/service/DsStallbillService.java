package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsStallbill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (DsStallbill)表服务接口
 *
 * @author makejava
 * @since 2023-02-02 10:58:22
 */
public interface DsStallbillService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsStallbill queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dsStallbill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DsStallbill> queryByPage(DsStallbill dsStallbill, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dsStallbill 实例对象
     * @return 实例对象
     */
    DsStallbill insert(DsStallbill dsStallbill);

    /**
     * 修改数据
     *
     * @param dsStallbill 实例对象
     * @return 实例对象
     */
    DsStallbill update(DsStallbill dsStallbill);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    /**
     * 停车计时
     * @author DareSasuke
     * @date 11:17 2023/2/2
     * @param id 用户id
     * @return void
     **/
    void  postCarStart(Integer id);


    /**
     * 设置价格
     * @author DareSasuke
     * @date 11:31 2023/2/2
     * @param id
     * @return void
     **/
    void updatePrice(Integer id);

    List<DsStallbill> queryStallBill(String username);

    List<DsStallbill> queryUserBill(Integer id);
}
