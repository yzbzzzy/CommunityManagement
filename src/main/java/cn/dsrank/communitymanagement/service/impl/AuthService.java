package cn.dsrank.communitymanagement.service.impl;

import cn.dsrank.communitymanagement.constant.UserRoleConstants;
import cn.dsrank.communitymanagement.entity.DsUser;
import cn.dsrank.communitymanagement.entity.DsUserinfo;
import cn.dsrank.communitymanagement.entity.JwtUser;
import cn.dsrank.communitymanagement.service.DsUserinfoService;
import cn.dsrank.communitymanagement.utils.JwtUtils;
import cn.dsrank.communitymanagement.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.Resource;
import java.util.*;

@Service
public class AuthService {
    @Resource
    private DsUserServiceImpl userService;

    @Resource
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Resource
    private DsUserinfoService dsUserinfoService;

    /**
     * 用户登录认证
     *
     * @param userLogin 用户登录信息
     */
    public JwtUser authLogin(DsUser userLogin) throws BadCredentialsException{
        String userName = userLogin.getUsername();
        String password = userLogin.getPassword();
        // 根据登录名获取用户信息
        Optional<DsUser> userOptional = Optional.ofNullable(userService.queryByName(userName));
        if (!userOptional.isPresent()) {
            throw new UsernameNotFoundException("User not found with userName: " + userName);
        }
        DsUser user = userOptional.get();
        // 验证登录密码是否正确。如果正确，则赋予用户相应权限并生成用户认证信息
        if (this.bCryptPasswordEncoder.matches(password+user.getSalt(), user.getPassword())) {
            List<String> roles=new ArrayList<>();

            // 如果用户角色为空，则默认赋予 ROLE_USER 角色
            if (user.getIdentity()==0) {
                roles = Collections.singletonList(UserRoleConstants.ROLE_USER);
            }else{
                roles = Collections.singletonList(UserRoleConstants.ROLE_ADMIN);
            }
            // 生成 token
            String token = JwtUtils.generateToken(userName, roles, true);

            // 认证成功后，设置认证信息到 Spring Security 上下文中
            Authentication authentication = JwtUtils.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 用户信息
            DsUser userDTO = new DsUser();
            userDTO.setUsername(userName);
            return new JwtUser(token, userDTO);
        }
        throw new BadCredentialsException("The user name or password error.");
    }

    /**
     * 用户退出登录
     *
     * <p>
     * 清除 Spring Security 上下文中的认证信息
     */
    public void logout() {
        SecurityContextHolder.clearContext();
    }


    public Map<String,Object> register(DsUser register){
        Map<String, Object> map = new HashMap<>();
        Optional<DsUser> registerOp = Optional.ofNullable(userService.queryByName(register.getUsername()));
        if(registerOp.isPresent()){
            map.put("code",101);
            map.put("msg","用户已存在");
            return map;
        }
        String salt = StringUtils.createRandomStr2(5);
        DsUser dsUser = new DsUser(register.getUsername()
                , bCryptPasswordEncoder. encode(register.getPassword()+salt)
                ,salt
                ,0);
        userService.insert(dsUser);
        DsUserinfo userinfo = new DsUserinfo();
        userinfo.setUserid(userService.queryByName(dsUser.getUsername()).getId());
        dsUserinfoService.insert(userinfo);
        map.put("code",200);
        map.put("msg","注册成功");
        return map;
    }
    public Map<String,Object> getRole(String token){
        String username = JwtUtils.getUserName(token);
        HashMap<String, Object> map = new HashMap<>();
        DsUser user = userService.queryByName(username);
        System.out.println(user.toString());
        DsUserinfo info = dsUserinfoService.queryById(user.getId());
        System.out.println(info.toString());
        map.put("name",user.getUsername());
        map.put("roles",user.getIdentity()==1?UserRoleConstants.ROLE_ADMIN:UserRoleConstants.ROLE_USER);
        map.put("avatar",info.getIcon());
        map.put("introduction","");
        return map;
    }



}
