package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.dao.DsBillDao;
import cn.dsrank.communitymanagement.dao.DsBuildingDao;
import cn.dsrank.communitymanagement.dao.DsUserinfoDao;
import cn.dsrank.communitymanagement.entity.DsPropertyfee;
import cn.dsrank.communitymanagement.dao.DsPropertyfeeDao;
import cn.dsrank.communitymanagement.service.DsBuildingService;
import cn.dsrank.communitymanagement.service.DsPropertyfeeService;
import cn.dsrank.communitymanagement.vo.TableFee;
import cn.dsrank.communitymanagement.vo.UserTableFee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * (DsPropertyfee)表服务实现类
 *
 * @author makejava
 * @since 2023-01-13 11:03:59
 */
@Slf4j
@Service("dsPropertyfeeService")
public class DsPropertyfeeServiceImpl implements DsPropertyfeeService {
    @Resource
    private DsPropertyfeeDao dsPropertyfeeDao;

    @Resource
    private DsUserinfoDao dsUserinfoDao;
    @Resource
    private DsBillDao dsBillDao;

    @Resource
    private DsBuildingDao dsBuildingDao;
    /**
     * 通过ID查询单条数据-
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsPropertyfee queryById(Integer id) {
        return this.dsPropertyfeeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dsPropertyfee 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DsPropertyfee> queryByPage(DsPropertyfee dsPropertyfee, PageRequest pageRequest) {
        long total = this.dsPropertyfeeDao.count(dsPropertyfee);
        return new PageImpl<>(this.dsPropertyfeeDao.queryAllByLimit(dsPropertyfee, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dsPropertyfee 实例对象
     * @return 实例对象
     */
    @Override
    public DsPropertyfee insert(DsPropertyfee dsPropertyfee) {
        this.dsPropertyfeeDao.insert(dsPropertyfee);
        return dsPropertyfee;
    }

    /**
     * 修改数据
     *
     * @param dsPropertyfee 实例对象
     * @return 实例对象
     */
    @Override
    public DsPropertyfee update(DsPropertyfee dsPropertyfee) {
        this.dsPropertyfeeDao.update(dsPropertyfee);
        return this.queryById(dsPropertyfee.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsPropertyfeeDao.deleteById(id) > 0;
    }

    @Override
    public Integer queryCount() {
        Optional<Integer> count = Optional.ofNullable(dsPropertyfeeDao.queryCount());
        return count.orElse(0);
    }

    @Override
    public List<TableFee> queryByPage(int start, int count) {
        List<DsPropertyfee> dsPropertyfees = dsPropertyfeeDao.queryByPage(start, count);
        ArrayList<TableFee> res = new ArrayList<>();
        dsPropertyfees.forEach(i->{
            res.add(new TableFee(i));
        });
        res.forEach(i->{
            i.setHas_over(Optional.ofNullable(dsBillDao.queryExistCount(i.getId())).orElse(0));
            i.setCount(Optional.ofNullable(dsUserinfoDao.queryCountBefore(i.getId())).orElse(0));
        });
        return res;
    }

    @Override
    public Integer queryUserPayCount(int userid) {
        return dsPropertyfeeDao.queryUserPayCount(userid);
    }

    @Override
    public List<UserTableFee> queryUserPayData(int userid, int start, int count) {
        List<DsPropertyfee> data = dsPropertyfeeDao.queryUserByPage(userid, start, count);
        ArrayList<UserTableFee> fees = new ArrayList<UserTableFee>();
        data.forEach(e->{
            UserTableFee i = new UserTableFee(e);
            i.setStatus(dsBillDao.queryUserBill(userid,e.getId())==null?0:1);
//            if(i.getStatus()==1){
//                i.setTime(dsBillDao.queryUserBill(userid,e.getId()).getDate());
//            }
            i.setPrice(i.getPrice()*dsBuildingDao.getAreaByUserId(userid));
            fees.add(i);
        });

        return fees;
    }

}
