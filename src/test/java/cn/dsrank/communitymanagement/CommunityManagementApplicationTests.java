package cn.dsrank.communitymanagement;

import cn.dsrank.communitymanagement.dao.DsBuildingDao;
import cn.dsrank.communitymanagement.dao.DsRoomDao;
import cn.dsrank.communitymanagement.dao.DsStallDao;
import cn.dsrank.communitymanagement.dao.DsUserinfoDao;
import cn.dsrank.communitymanagement.entity.DsRoom;
import cn.dsrank.communitymanagement.entity.DsUserinfo;
import cn.dsrank.communitymanagement.utils.RandData;
import cn.dsrank.communitymanagement.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.yaml.snakeyaml.Yaml;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Map;
import java.util.Optional;

@Slf4j
@SpringBootTest
class CommunityManagementApplicationTests {

    @Resource
    DsBuildingDao dsBuildingDao;

    @Resource
    DsStallDao dsStallDao;
    @Resource
    DsRoomDao dsRoomDao;
    @Resource
    DsUserinfoDao dsUserinfoDao;


    @Test
    void contextLoads() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String test = bCryptPasswordEncoder.encode("test");
        System.out.println(test);
    }
    @Test
    void getLastId(){
        Optional<Integer> lastId = Optional.ofNullable(null);
        System.out.println(lastId.orElse(0));
    }
    @Test
     void setHome(){
        for(int i = 0;i<150;i++){
            DsRoom room = dsRoomDao.getRandRoom();
            DsUserinfo userinfo = dsUserinfoDao.getRandUserinfo();
            userinfo.setBuildingid(room.getBuildingid());
            userinfo.setRoomid(room.getId());
            room.setStatus(1);
            dsRoomDao.update(room);
            dsUserinfoDao.update(userinfo);
        }

    }

    @Test
    void testSelect(){
        Integer integer = dsUserinfoDao.queryCountBefore(1);
        System.out.println(integer);
    }

    @Test
    void addInfo(){
        for(int i = 0 ;i<300;i++){
        DsUserinfo randUserinfo = this.dsUserinfoDao.getRandUserinfo();
        randUserinfo.setPhone(RandData.createMobile(i%3));
        dsUserinfoDao.update(randUserinfo);
        }
    }

    @Test
    void randPost(){
        for(int i=0;i<50;i++)
        dsStallDao.randStall();
    }

}
