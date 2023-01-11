package cn.dsrank.communitymanagement;

import cn.dsrank.communitymanagement.dao.DsBuildingDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;
import java.util.Optional;

@SpringBootTest
class CommunityManagementApplicationTests {

    @Resource
    DsBuildingDao dsBuildingDao;
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

}
