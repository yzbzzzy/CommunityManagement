package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.dao.DsUserDao;
import cn.dsrank.communitymanagement.service.DsUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DsUser)表服务实现类
 *
 * @author makejava
 * @since 2023-01-06 21:39:40
 */
@Service("dsUserService")
public class DsUserServiceImpl implements DsUserService {
    @Resource
    private DsUserDao dsUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsUser queryById(Integer id) {
        return this.dsUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DsUser> queryAllByLimit(int offset, int limit) {
        return this.dsUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dsUser 实例对象
     * @return 实例对象
     */
    @Override
    public DsUser insert(DsUser dsUser) {
        this.dsUserDao.insert(dsUser);
        return dsUser;
    }

    /**
     * 修改数据
     *
     * @param dsUser 实例对象
     * @return 实例对象
     */
    @Override
    public DsUser update(DsUser dsUser) {
        this.dsUserDao.update(dsUser);
        return this.queryById(dsUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsUserDao.deleteById(id) > 0;
    }

    @Override
    public DsUser queryByName(String name) {
        return this.dsUserDao.queryByName(name);
    }

    @Override
    public int queryCount() {
        return this.dsUserDao.queryCount();
    }
}