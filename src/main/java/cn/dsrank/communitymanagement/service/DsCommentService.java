package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsComment;
import cn.dsrank.communitymanagement.vo.UserComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (DsComment)表服务接口
 *
 * @author makejava
 * @since 2023-01-18 13:34:48
 */
public interface DsCommentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsComment queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dsComment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DsComment> queryByPage(DsComment dsComment, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dsComment 实例对象
     * @return 实例对象
     */
    DsComment insert(DsComment dsComment);

    /**
     * 修改数据
     *
     * @param dsComment 实例对象
     * @return 实例对象
     */
    DsComment update(DsComment dsComment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 查询反馈的所有评论
     * @param fid
     * @return
     */
    List<UserComment> queryAllComment(Integer fid);


}
