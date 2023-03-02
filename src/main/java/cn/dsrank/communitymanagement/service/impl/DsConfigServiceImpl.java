package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsConfig;
import cn.dsrank.communitymanagement.dao.DsConfigDao;
import cn.dsrank.communitymanagement.service.DsConfigService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Optional;

/**
 * (DsConfig)表服务实现类
 *
 * @author makejava
 * @since 2023-01-29 15:35:42
 */
@Service("dsConfigService")
public class DsConfigServiceImpl implements DsConfigService {
    @Resource
    private DsConfigDao dsConfigDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsConfig queryById(Integer id) {
        return this.dsConfigDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param dsConfig 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<DsConfig> queryByPage(DsConfig dsConfig, PageRequest pageRequest) {
        long total = this.dsConfigDao.count(dsConfig);
        return new PageImpl<>(this.dsConfigDao.queryAllByLimit(dsConfig, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param dsConfig 实例对象
     * @return 实例对象
     */
    @Override
    public DsConfig insert(DsConfig dsConfig) {
        this.dsConfigDao.insert(dsConfig);
        return dsConfig;
    }

    /**
     * 修改数据
     *
     * @param dsConfig 实例对象
     * @return 实例对象
     */
    @Override
    public DsConfig update(DsConfig dsConfig) {
        this.dsConfigDao.update(dsConfig);
        return this.queryById(dsConfig.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsConfigDao.deleteById(id) > 0;
    }

    /**
     * 查询单价
     * @author DareSasuke
     * @date 15:36 2023/1/29
     * @param
     * @return java.lang.Float
     **/
    @Override
    public  Float queryUnitCost(){
        return Optional.ofNullable(this.dsConfigDao.queryUnitCost()).orElse(0F);
    };

    @Override
    public void setUnitCost(Float price) {
        this.dsConfigDao.setUnitCost(price);
    }
}
