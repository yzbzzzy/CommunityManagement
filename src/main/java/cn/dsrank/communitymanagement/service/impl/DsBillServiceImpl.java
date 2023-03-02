package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsBill;
import cn.dsrank.communitymanagement.dao.DsBillDao;
import cn.dsrank.communitymanagement.service.DsBillService;
import cn.dsrank.communitymanagement.vo.UserBill;
import cn.dsrank.communitymanagement.vo.UserPayRate;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * (DsBill)表服务实现类
 *
 * @author makejava
 * @since 2023-01-13 11:22:32
 */
@Service("dsBillService")
public class DsBillServiceImpl implements DsBillService {
    @Resource
    private DsBillDao dsBillDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsBill queryById(Integer id) {
        return this.dsBillDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dsBill 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DsBill> queryByPage(DsBill dsBill, PageRequest pageRequest) {
        long total = this.dsBillDao.count(dsBill);
        return new PageImpl<>(this.dsBillDao.queryAllByLimit(dsBill, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dsBill 实例对象
     * @return 实例对象
     */
    @Override
    public DsBill insert(DsBill dsBill) {
        this.dsBillDao.insert(dsBill);
        return dsBill;
    }

    /**
     * 修改数据
     *
     * @param dsBill 实例对象
     * @return 实例对象
     */
    @Override
    public DsBill update(DsBill dsBill) {
        this.dsBillDao.update(dsBill);
        return this.queryById(dsBill.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsBillDao.deleteById(id) > 0;
    }

    @Override
    public DsBill queryStatus(int userid, int propertyFeeId) {
        return null;
    }

    @Override
    public List<UserBill> queryUserBillByPage(int userid, int page, int count) {
        return dsBillDao.queryUserBillByPage(userid,page,count);
    }

    @Override
    public Integer queryUserBillCount(int userid) {
        return Optional.ofNullable(dsBillDao.queryUserBillCount(userid)).orElse(0);
    }

    @Override
    public UserPayRate queryPayRate() {
        UserPayRate userPayRate = this.dsBillDao.queryPayRate();
        userPayRate.setPaid(Optional.ofNullable(userPayRate.getPaid()).orElse(0));
        userPayRate.setTotal(Optional.ofNullable(userPayRate.getTotal()).orElse(0));
        return userPayRate;
    }
}
