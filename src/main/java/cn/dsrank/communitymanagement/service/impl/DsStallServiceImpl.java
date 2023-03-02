package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.dao.DsStallbillDao;
import cn.dsrank.communitymanagement.entity.DsStall;
import cn.dsrank.communitymanagement.dao.DsStallDao;
import cn.dsrank.communitymanagement.service.DsStallService;
import cn.dsrank.communitymanagement.service.DsStallbillService;
import cn.dsrank.communitymanagement.utils.DateUtils;
import cn.dsrank.communitymanagement.vo.StallInfo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * (DsStall)表服务实现类
 *
 * @author makejava
 * @since 2023-01-27 18:38:27
 */
@Service("dsStallService")
public class DsStallServiceImpl implements DsStallService {
    @Resource
    private DsStallDao dsStallDao;

    @Resource
    private DsStallbillDao dsStallbillDao;

    @Resource
    private DsStallbillService dsStallbillService;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsStall queryById(Integer id) {
        return this.dsStallDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dsStall 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DsStall> queryByPage(DsStall dsStall, PageRequest pageRequest) {
        long total = this.dsStallDao.count(dsStall);
        return new PageImpl<>(this.dsStallDao.queryAllByLimit(dsStall, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dsStall 实例对象
     * @return 实例对象
     */
    @Override
    public DsStall insert(DsStall dsStall) {
        this.dsStallDao.insert(dsStall);
        return dsStall;
    }

    /**
     * 修改数据
     *
     * @param dsStall 实例对象
     * @return 实例对象
     */
    @Override
    public DsStall update(DsStall dsStall) {
        this.dsStallDao.update(dsStall);
        return this.queryById(dsStall.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsStallDao.deleteById(id) > 0;
    }

    @Override
    public void multipleAdd(int amount) {
        for(int i =0;i<amount;i++)
        this.dsStallDao.insert(new DsStall());
    }

    /**
     * 查询闲置数量
     * @Author DareSasuke
     * @Date 19:09 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    @Override
    public Integer queryIdle() {
        Integer integer = this.dsStallDao.queryByStatus(0);
        return Optional.ofNullable(integer).orElse(0);
    }

    /**
     * 查询被占用数量
     * @Author DareSasuke
     * @Date 19:09 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    @Override
    public Integer queryBusy() {
        Integer integer = this.dsStallDao.queryByStatus(1);
        return Optional.ofNullable(integer).orElse(0);
    }

    /**
     * 查询终身使用的数量
     * @Author DareSasuke
     * @Date 19:10 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    @Override
    public Integer queryLifeTime() {
        Integer integer = this.dsStallDao.queryByStatus(2);
        return Optional.ofNullable(integer).orElse(0);
    }

    /**
     * 查询出现故障的数量
     * @Author DareSasuke
     * @Date 19:11 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    @Override
    public Integer queryIssue() {
        Integer integer = this.dsStallDao.queryByStatus(3);
        return Optional.ofNullable(integer).orElse(0);
    }

    /**
     * 查询总数
     * @Author DareSasuke
     * @Date 19:15 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    @Override
    public Integer queryTotal() {
        return Optional.ofNullable(this.dsStallDao.queryTotal()).orElse(0);
    }

    /**
     * 查询占用停车位的所有信息
     * @author DareSasuke
     * @date 17:01 2023/1/28
     * @param page 页数
     * @param count 数量
     * @return java.util.List<cn.dsrank.communitymanagement.vo.StallInfo>
     **/
    @Override
    public List<StallInfo> queryStallInfo(int page,int count) {
        return this.dsStallDao.queryStallInfo((page-1)*count,count);
    }

    /**
     * 根据关键字查询
     * @author DareSasuke
     * @date 19:42 2023/1/28
     * @param keyword
     * @return java.util.List<cn.dsrank.communitymanagement.vo.StallInfo>
     **/
    @Override
    public List<StallInfo> queryStallByKeyword(String keyword){
        return this.dsStallDao.queryStallByKeyword(keyword);
    }

    @Override
    public void postCar(int id) {
        this.dsStallDao.postCar(id);
        this.dsStallbillDao.postCarStart(id);
    }

    @Override
    public void driveCar(int userId) {
        this.dsStallDao.driveCar(userId);
        this.dsStallbillDao.postCarEnd(userId);
        this.dsStallbillService.updatePrice(userId);
    }

    @Override
    public void buyStall(int id) {
        this.dsStallDao.buyStall(id);
    }

}
