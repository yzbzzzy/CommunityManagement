package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.dao.DsConfigDao;
import cn.dsrank.communitymanagement.entity.DsStallbill;
import cn.dsrank.communitymanagement.dao.DsStallbillDao;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.service.DsStallbillService;
import cn.dsrank.communitymanagement.service.DsUserService;
import cn.dsrank.communitymanagement.utils.DateUtils;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (DsStallbill)表服务实现类
 *
 * @author makejava
 * @since 2023-02-02 10:58:22
 */
@Service("dsStallbillService")
public class DsStallbillServiceImpl implements DsStallbillService {
    @Resource
    private DsStallbillDao dsStallbillDao;

    @Resource
    private DsConfigDao dsConfigDao;

    @Resource
    private DsUserService dsUserService;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsStallbill queryById(Integer id) {
        return this.dsStallbillDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dsStallbill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DsStallbill> queryByPage(DsStallbill dsStallbill, PageRequest pageRequest) {
        long total = this.dsStallbillDao.count(dsStallbill);
        return new PageImpl<>(this.dsStallbillDao.queryAllByLimit(dsStallbill, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dsStallbill 实例对象
     * @return 实例对象
     */
    @Override
    public DsStallbill insert(DsStallbill dsStallbill) {
        this.dsStallbillDao.insert(dsStallbill);
        return dsStallbill;
    }

    /**
     * 修改数据
     *
     * @param dsStallbill 实例对象
     * @return 实例对象
     */
    @Override
    public DsStallbill update(DsStallbill dsStallbill) {
        this.dsStallbillDao.update(dsStallbill);
        return this.queryById(dsStallbill.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsStallbillDao.deleteById(id) > 0;
    }

    @Override
    public void postCarStart(Integer id) {
        this.dsStallbillDao.postCarStart(id);
    }

    @Override
    public void updatePrice(Integer id) {
        DsStallbill end = this.dsStallbillDao.getEnd(id);
        Float aFloat = dsConfigDao.queryUnitCost();
        end.setFee(aFloat*(DateUtils.getDifferHour(end.getStarttime(),end.getEndtime())));
        this.dsStallbillDao.setFee(end.getId(),end.getFee());
    }

    @Override
    public List<DsStallbill> queryStallBill(String username) {
        DsUser dsUser = this.dsUserService.queryByName(username);
        List<DsStallbill> bill = this.dsStallbillDao.queryUserBill(dsUser.getId());
        return bill;
    }

    @Override
    public List<DsStallbill> queryUserBill(Integer id) {
        return this.dsStallbillDao.queryUserBill(id);
    }
}
