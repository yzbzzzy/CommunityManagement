package cn.dsrank.communitymanagement.service;

import cn.dsrank.communitymanagement.entity.DsStall;
import cn.dsrank.communitymanagement.vo.StallInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * (DsStall)表服务接口
 *
 * @author makejava
 * @since 2023-01-27 18:38:27
 */
public interface DsStallService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    DsStall queryById(Integer id);

    /**
     * 分页查询
     *
     * @param dsStall 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<DsStall> queryByPage(DsStall dsStall, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param dsStall 实例对象
     * @return 实例对象
     */
    DsStall insert(DsStall dsStall);

    /**
     * 修改数据
     *
     * @param dsStall 实例对象
     * @return 实例对象
     */
    DsStall update(DsStall dsStall);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    /**
     * 按数量添加
     * @Author DareSasuke
     * @Date 19:00 2023/1/27
     * @param i 添加个数
     * @return void
     **/
    void multipleAdd(int i);

    /**
     * 查询闲置的车位数量
     * @Author DareSasuke
     * @Date 19:01 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    Integer queryIdle();

    /**
     * 查询占用的数量
     * @Author DareSasuke
     * @Date 19:02 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    Integer queryBusy();

    /**
     * 查询终身使用数量
     * @Author DareSasuke
     * @Date 19:02 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    Integer queryLifeTime();

    /**
     * 查询出现问题的数量
     * @Author DareSasuke
     * @Date 19:03 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    Integer queryIssue();

    /**
     * 查询总数
     * @Author DareSasuke
     * @Date 19:15 2023/1/27
     * @param
     * @return java.lang.Integer
     **/
    Integer queryTotal();

    /**
     * 查询占用停车位的所有信息
     * @author DareSasuke
     * @date 17:01 2023/1/28
     * @param page 页数
     * @param count 数量
     * @return java.util.List<cn.dsrank.communitymanagement.vo.StallInfo>
     **/
    List<StallInfo> queryStallInfo(int page ,int count );

    /**
     * 根据关键字查询
     * @author DareSasuke
     * @date 19:42 2023/1/28
     * @param keyword
     * @return java.util.List<cn.dsrank.communitymanagement.vo.StallInfo>
     **/
    List<StallInfo> queryStallByKeyword(String keyword);

    /**
     * 停车
     * @author DareSasuke
     * @date 11:01 2023/2/2
     * @param id 用户id
     * @return void
     **/
    void postCar(int id);

    /**
     * 停车结束
     * @author DareSasuke
     * @date 11:46 2023/2/2
     * @param id
     * @return void
     **/
    void driveCar(int id);

    void buyStall(int id);
}
