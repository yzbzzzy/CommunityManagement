package cn.dsrank.communitymanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.dsrank.communitymanagement.dao")
public class CommunityManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommunityManagementApplication.class, args);
    }

}
