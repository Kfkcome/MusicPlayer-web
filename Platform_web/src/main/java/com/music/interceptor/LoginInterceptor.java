package com.music.interceptor;

import com.music.exception.loginErrorException;
import com.music.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.SignatureException;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws loginErrorException {
        //获取请求头中的token
        String token = request.getHeader("token");
        //判断token是否为空，如果为空也代表未登录 提醒重新登录（401）
        if(!StringUtils.hasText(token)){
            throw new loginErrorException("未登录请登录账号");
        }
        //解析token看看是否成功
        try {
            Claims claims = JwtUtil.parseJWT(token);
            String subject = claims.getSubject();
            System.out.println(subject);
        } catch (SignatureException e) {
            //如果解析过程中没有出现异常说明是登录状态
            //如果出现了异常，说明未登录，提醒重新登录（401）
            throw new loginErrorException("登录已超时，请重新登录");
        }
        return true;
    }
}