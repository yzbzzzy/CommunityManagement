package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsLease;
import cn.dsrank.communitymanagement.dao.DsLeaseDao;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.service.DsLeaseService;
import cn.dsrank.communitymanagement.service.DsUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (DsLease)表服务实现类
 *
 * @author makejava
 * @since 2023-03-03 15:25:23
 */
@Service("dsLeaseService")
public class DsLeaseServiceImpl implements DsLeaseService {
    @Resource
    private DsLeaseDao dsLeaseDao;

    @Resource
    private DsUserService dsUserService;

    @Override
    public DsLease queryById( ) {
        return this.dsLeaseDao.queryById();
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DsLease> queryAllByLimit(int offset, int limit) {
        return this.dsLeaseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dsLease 实例对象
     * @return 实例对象
     */
    @Override
    public DsLease insert(DsLease dsLease) {
        this.dsLeaseDao.insert(dsLease);
        return dsLease;
    }


    @Override
    public boolean deleteById( ) {
        return this.dsLeaseDao.deleteById() > 0;
    }

    @Override
    public void setLease(String username, int id, List<Date> dates) {
        DsUser dsUser = this.dsUserService.queryByName(username);
        dsUser.setIdentity(4);
        DsUser dsUser1 = this.dsUserService.queryById(id);
        dsUser1.setIdentity(2);
        DsLease dsLease = new DsLease();
        dsLease.setUserid(id);
        dsLease.setHostid(dsUser.getId());
        dsLease.setStarttime(dates.get(0));
        dsLease.setEndtime(dates.get(1));
        this.dsLeaseDao.insert(dsLease);
        this.dsUserService.update(dsUser);
        this.dsUserService.update(dsUser1);
    }

}