package com.zm.util;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 *  token 处理
 * @author liyangbin
 * @date  2020-6-1
 */
public class JwtUtil {
    /**过期时间*/
    private static final long EXPIRE_TIME = 60 * 60 * 24 * 1000;
    /**私钥*/
    private static final String TOKEN_SECRET = "LIXIA_TOKEN_KEY";

    /**
     * 生成token，60分钟过期
     * @param **username**
     * @param **password**
     * @return
     */
    public static String createToken(String jsonUser,Integer userId) throws Exception{
        try {
            // 设置过期时间
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            // 私钥和加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            // 返回token字符串
            return JWT.create()
                    .withHeader(header)
                    .withClaim("user", jsonUser)
                    .withClaim("userId", userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new Exception(e.getMessage());
        }
    }

    /**
     * 检验token是否正确
     * @param **token**
     * @return
     */
    public static Integer verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            Integer userId = jwt.getClaim("userId").asInt();
            return userId;
        } catch (Exception e){
            return 0;
        }
    }
    /**
     * 解析token 获取用户信息
     * @param **token**
     * @return
     */
    public static String parseToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return jwt.getClaim("user").asString();
        } catch (Exception e){
            return null;
        }
    }
}
