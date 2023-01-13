package cn.dsrank.communitymanagement;

import cn.dsrank.communitymanagement.dao.DsBuildingDao;
import cn.dsrank.communitymanagement.dao.DsRoomDao;
import cn.dsrank.communitymanagement.dao.DsUserinfoDao;
import cn.dsrank.communitymanagement.entity.DsRoom;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.DsUserinfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootTest
class CommunityManagementApplicationTests {

    @Resource
    DsBuildingDao dsBuildingDao;

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

}
