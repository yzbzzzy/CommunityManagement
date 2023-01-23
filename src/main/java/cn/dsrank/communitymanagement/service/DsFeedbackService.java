package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsFeedback;
import cn.dsrank.communitymanagement.vo.TableFeedback;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (DsFeedback)表服务接口
 *
 * @author makejava
 * @since 2023-01-18 13:34:36
 */
public interface DsFeedbackService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsFeedback queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dsFeedback 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DsFeedback> queryByPage(DsFeedback dsFeedback, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dsFeedback 实例对象
     * @return 实例对象
     */
    DsFeedback insert(DsFeedback dsFeedback);

    /**
     * 修改数据
     *
     * @param dsFeedback 实例对象
     * @return 实例对象
     */
    DsFeedback update(DsFeedback dsFeedback);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询总反馈条数
     * @return
     */
    Integer queryTotalCount();

    /**
     * 分页查询反馈列表
     * @param page
     * @param count
     * @return
     */
    List<TableFeedback> queryTableFeedback(int page, int count);

}
