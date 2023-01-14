package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsPropertyfee;
import cn.dsrank.communitymanagement.vo.TableFee;
import cn.dsrank.communitymanagement.vo.UserTableFee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (DsPropertyfee)表服务接口
 *
 * @author makejava
 * @since 2023-01-13 11:03:59
 */
public interface DsPropertyfeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsPropertyfee queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dsPropertyfee 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DsPropertyfee> queryByPage(DsPropertyfee dsPropertyfee, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dsPropertyfee 实例对象
     * @return 实例对象
     */
    DsPropertyfee insert(DsPropertyfee dsPropertyfee);

    /**
     * 修改数据
     *
     * @param dsPropertyfee 实例对象
     * @return 实例对象
     */
    DsPropertyfee update(DsPropertyfee dsPropertyfee);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    Integer queryCount();


    List<TableFee> queryByPage(int start, int count);

    Integer queryUserPayCount(int userid);

    List<UserTableFee> queryUserPayData(int userid,int start,int count);

}
