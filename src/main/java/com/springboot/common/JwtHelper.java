package com.springboot.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.HashMap;

import static com.springboot.common.GlobalProperties.*;

@Component
public class JwtHelper {
    public static String GetToken(int Id) {
        try {
            return JWT.create()
                    .withHeader(new HashMap<String, Object>(2) {
                        {
                            put("typ", "JWT");
                            put("alg", "HS256");
                        }
                    })
                    .withClaim("Id", Id)
                    .withExpiresAt(new Date(System.currentTimeMillis() + Duration.ofHours(EXPIRE_TIME).toMillis()))
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     * 解析token并校验token
     */
    public static boolean VerifyToken(HttpServletRequest httpServletRequest) {
        try {
            String token = httpServletRequest.getHeader("Authorization");
            // 没有token直接返回false
            if (token == null || token.equals("")) {
                return false;
            }
            // 时间戳是秒数
            var claims = JWT.decode(token).getClaims();
            if(LocalDateTime.now().toEpochSecond(ZoneOffset.of("+8")) > claims.get("exp").asLong()){
                return false;
            }
            return true;
        } catch (Exception e) {
            //解码异常则抛出异常
            return false;
        }
    }

    public static Integer GetInfo(HttpServletRequest request) {
        try {
            var token = request.getHeader("Authorization");
            var verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("Id").asInt();
        } catch (Exception ex) {
            return null;
        }
    }
}
