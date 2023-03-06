package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.entity.DsBuilding;
import cn.dsrank.communitymanagement.dao.DsBuildingDao;
import cn.dsrank.communitymanagement.entity.DsBuildingInfo;
import cn.dsrank.communitymanagement.entity.DsRoom;
import cn.dsrank.communitymanagement.service.DsBuildingService;
import cn.dsrank.communitymanagement.service.DsRoomService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * (DsBuilding)表服务实现类
 *
 * @author makejava
 * @since 2023-01-10 15:41:03
 */
@Service("dsBuildingService")
public class DsBuildingServiceImpl implements DsBuildingService {
    @Resource
    private DsBuildingDao dsBuildingDao;
    @Resource
    private DsRoomService dsRoomService;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public DsBuilding queryById(Integer id) {
        return this.dsBuildingDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<DsBuilding> queryAllByLimit(int offset, int limit) {
        return this.dsBuildingDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param dsBuilding 实例对象
     * @return 实例对象
     */
    @Override
    public DsBuilding insert(DsBuilding dsBuilding) {
        this.dsBuildingDao.insert(dsBuilding);
        return dsBuilding;
    }

    /**
     * 修改数据
     *
     * @param dsBuilding 实例对象
     * @return 实例对象
     */
    @Override
    public DsBuilding update(DsBuilding dsBuilding) {
        this.dsBuildingDao.update(dsBuilding);
        return this.queryById(dsBuilding.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.dsBuildingDao.deleteById(id) > 0;
    }

    @Transactional
    @Override
    public void addBuilding(int f,int r,String desc,float area){
        Optional<Integer> lastId = Optional.ofNullable(this.dsBuildingDao.getLastId());
        dsBuildingDao.insert(new DsBuilding(lastId.orElse(0)+1,desc,area));
        for(int i =1;i<=f;i++){
            for(int j = 1;j<=r;j++){
                dsRoomService.insert(new DsRoom(lastId.orElse(0)+1,i,j,0));
            }
        }
    }

    @Override
    public List<DsBuildingInfo> getBuildingInfo() {
        Integer count = dsBuildingDao.getCount();
        ArrayList<DsBuildingInfo> infos = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            DsBuildingInfo info = dsBuildingDao.getBuildInfo(i);
            info.setDesc(dsBuildingDao.queryById(i).getDesc());
            info.setArea(dsBuildingDao.queryById(i).getArea());
            infos.add(info);
        }
        return infos;
    }

    @Override
    public List<DsBuilding> getAll() {
        return this.dsBuildingDao.getAll();
    }


}