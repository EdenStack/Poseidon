package com.tneciv.poseidon.common;

import com.tneciv.poseidon.security.AccountCredentials;
import com.tneciv.poseidon.security.WebSecurityConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * Created by Tneciv on 2017/6/11.
 */
@Slf4j
public class LoginUserResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter,
                                  ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest,
                                  WebDataBinderFactory binderFactory) throws Exception {
        return this.readArgs(webRequest);
    }

    private Object readArgs(NativeWebRequest webRequest) throws Exception {

        try {
            String authorization = webRequest.getHeader(WebSecurityConfig.HEADER_STRING);
            String token = authorization.substring(WebSecurityConfig.TOKEN_PREFIX.length() + 1);
            Claims claims = Jwts.parser().setSigningKey(WebSecurityConfig.SECRET)
                    .parseClaimsJws(token).getBody();
            String username = claims.getSubject();
            AccountCredentials accountCredentials = new AccountCredentials();
            accountCredentials.setUsername(username);
            return accountCredentials;
        } catch (ExpiredJwtException e) {
            throw new Exception("Token 已过期");
        } catch (Exception e) {
            log.error(e.getMessage());
            e.printStackTrace();
            throw new Exception("Token 解析失败");
        }

    }

}
