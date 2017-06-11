package com.tneciv.poseidon.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import static java.util.Collections.emptyList;

public class TokenAuthenticationService {

    public static void addAuthentication(HttpServletResponse res, String username) throws IOException {
        res.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=utf-8");
        
        String jwtToken = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + WebSecurityConfig.EXPIRATIONTIME))
                .signWith(SignatureAlgorithm.HS512, WebSecurityConfig.SECRET)
                .compact();
        
        ObjectMapper mapper = new ObjectMapper();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("username", username);
        hashMap.put("token", jwtToken);
        String json = mapper.writeValueAsString(hashMap);
        res.getWriter().append(json);
    }

    public static Authentication getAuthentication(HttpServletRequest request) {

        String token = request.getHeader(WebSecurityConfig.HEADER_STRING);

        if (token != null) {
            // parse the token.
            String user = Jwts.parser()
                    .setSigningKey(WebSecurityConfig.SECRET)
                    .parseClaimsJws(token.replace(WebSecurityConfig.TOKEN_PREFIX, ""))
                    .getBody()
                    .getSubject();

            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                    null;
        }

        return null;
    }
}