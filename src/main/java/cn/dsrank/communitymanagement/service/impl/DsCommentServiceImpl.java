package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsComment;
import cn.dsrank.communitymanagement.dao.DsCommentDao;
import cn.dsrank.communitymanagement.service.DsCommentService;
import cn.dsrank.communitymanagement.vo.UserComment;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DsComment)表服务实现类
 *
 * @author makejava
 * @since 2023-01-18 13:34:48
 */
@Service("dsCommentService")
public class DsCommentServiceImpl implements DsCommentService {
    @Resource
    private DsCommentDao dsCommentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsComment queryById(Integer id) {
        return this.dsCommentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dsComment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DsComment> queryByPage(DsComment dsComment, PageRequest pageRequest) {
        long total = this.dsCommentDao.count(dsComment);
        return new PageImpl<>(this.dsCommentDao.queryAllByLimit(dsComment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dsComment 实例对象
     * @return 实例对象
     */
    @Override
    public DsComment insert(DsComment dsComment) {
        this.dsCommentDao.insert(dsComment);
        return dsComment;
    }

    /**
     * 修改数据
     *
     * @param dsComment 实例对象
     * @return 实例对象
     */
    @Override
    public DsComment update(DsComment dsComment) {
        this.dsCommentDao.update(dsComment);
        return this.queryById(dsComment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsCommentDao.deleteById(id) > 0;
    }

    @Override
    public List<UserComment> queryAllComment(Integer fid) {
        return dsCommentDao.queryAllComment(fid);
    }
}
