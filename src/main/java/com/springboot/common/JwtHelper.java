package com.springboot.common;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.springboot.common.GlobalProperties.*;

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
     * 校验token并解析token
     */
    public static Map<String, Claim> VerifyToken(String token) {
        DecodedJWT jwt = null;
        try {
            // JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build();
            // jwt = verifier.verify(token);
            jwt = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).build().verify(token);
            //decodedJWT.getClaim("属性").asString()  获取负载中的属性值
        } catch (Exception e) {
            //解码异常则抛出异常
            return null;
        }
        return jwt.getClaims();
    }
}
