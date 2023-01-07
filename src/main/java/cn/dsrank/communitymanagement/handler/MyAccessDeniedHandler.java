package cn.dsrank.communitymanagement.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class MyAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();
        String errorMsg = objectMapper.writeValueAsString(new HashMap<String,Object>(){
            {
                put("code",403);
                put("msg","没有权限");
            }
        });
        out.write(errorMsg);
//        out.write("{\"status\": \"error\", \"msg\":\"权限不足请联系管理员!!\"}");
        out.flush();
        out.close();

    }
}
