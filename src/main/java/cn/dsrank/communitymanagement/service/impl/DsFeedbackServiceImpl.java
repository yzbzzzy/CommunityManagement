package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsFeedback;
import cn.dsrank.communitymanagement.dao.DsFeedbackDao;
import cn.dsrank.communitymanagement.service.DsFeedbackService;
import cn.dsrank.communitymanagement.vo.TableFeedback;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * (DsFeedback)表服务实现类
 *
 * @author makejava
 * @since 2023-01-18 13:34:36
 */
@Service("dsFeedbackService")
public class DsFeedbackServiceImpl implements DsFeedbackService {
    @Resource
    private DsFeedbackDao dsFeedbackDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsFeedback queryById(Integer id) {
        return this.dsFeedbackDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dsFeedback 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DsFeedback> queryByPage(DsFeedback dsFeedback, PageRequest pageRequest) {
        long total = this.dsFeedbackDao.count(dsFeedback);
        return new PageImpl<>(this.dsFeedbackDao.queryAllByLimit(dsFeedback, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dsFeedback 实例对象
     * @return 实例对象
     */
    @Override
    public DsFeedback insert(DsFeedback dsFeedback) {
        this.dsFeedbackDao.insert(dsFeedback);
        return dsFeedback;
    }

    /**
     * 修改数据
     *
     * @param dsFeedback 实例对象
     * @return 实例对象
     */
    @Override
    public DsFeedback update(DsFeedback dsFeedback) {
        this.dsFeedbackDao.update(dsFeedback);
        return this.queryById(dsFeedback.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsFeedbackDao.deleteById(id) > 0;
    }

    @Override
    public Integer queryTotalCount() {
        return Optional.ofNullable(this.dsFeedbackDao.queryTotalCount()).orElse(0);
    }

    @Override
    public List<TableFeedback> queryTableFeedback(int page, int count) {
        return this.dsFeedbackDao.queryTableFeedback(page,count);
    }
}
