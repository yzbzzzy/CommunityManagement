package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsUserinfo;
import cn.dsrank.communitymanagement.dao.DsUserinfoDao;
import cn.dsrank.communitymanagement.service.DsUserinfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DsUserinfo)表服务实现类
 *
 * @author makejava
 * @since 2023-01-09 22:07:40
 */
@Service("dsUserinfoService")
public class DsUserinfoServiceImpl implements DsUserinfoService {
    @Resource
    private DsUserinfoDao dsUserinfoDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public DsUserinfo queryById(Integer userid) {
        return this.dsUserinfoDao.queryById(userid);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DsUserinfo> queryAllByLimit(int offset, int limit) {
        return this.dsUserinfoDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dsUserinfo 实例对象
     * @return 实例对象
     */
    @Override
    public DsUserinfo insert(DsUserinfo dsUserinfo) {
        this.dsUserinfoDao.insert(dsUserinfo);
        return dsUserinfo;
    }

    /**
     * 修改数据
     *
     * @param dsUserinfo 实例对象
     * @return 实例对象
     */
    @Override
    public DsUserinfo update(DsUserinfo dsUserinfo) {
        this.dsUserinfoDao.update(dsUserinfo);
        return this.queryById(dsUserinfo.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.dsUserinfoDao.deleteById(userid) > 0;
    }



}