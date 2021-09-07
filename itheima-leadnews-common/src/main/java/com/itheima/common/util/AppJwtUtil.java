package com.itheima.common.util;

import com.itheima.common.constants.SystemConstants;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.*;

public class AppJwtUtil {

    // TOKEN有效期 1个小时
    private static final int TOKEN_TIME_OUT = 3600;
    // 加密KEY
    private static final String TOKEN_ENCRY_KEY = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY";

    //生成令牌

    /**
     *
     * @param id 用户的ID （adUser表中的主键，也可以是别的用户的ID）
     * @return
     */
    public static String createToken(Long id) {
        Map<String, Object> claimMaps = new HashMap<>();
        claimMaps.put("id", id);//自己的令牌信息的中的ID 值
        long currentTime = System.currentTimeMillis();
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())//令牌的唯一标识
                .setIssuedAt(new Date(currentTime))  //颁发令牌的时间
                .setSubject("system")  //说明
                .setIssuer("heima") //签发者信息
                .setAudience("app")  //接收用户
                .compressWith(CompressionCodecs.GZIP)  //数据压缩方式
                .signWith(SignatureAlgorithm.HS512, generalKey()) //秘钥设置
                //设置过期时间
                .setExpiration(new Date(currentTime + TOKEN_TIME_OUT * 1000))  //过期时间戳
                .addClaims(claimMaps) //payload信息
                .compact();//生成令牌
    }

    /**
     * 获取token中的claims信息
     *
     * @param token
     * @return
     */
    private static Jws<Claims> getJws(String token) {
        return Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(token);
    }

    /**
     * 获取令牌的信息（载荷payload的信息）
     *
     * @param token
     * @return
     */
    public static Claims getClaimsBody(String token) {
        try {
            return getJws(token).getBody();
        } catch (ExpiredJwtException e) {
            return null;
        }
    }

    /**
     * 获取hearder body信息
     *
     * @param token
     * @return
     */
    public static JwsHeader getHeaderBody(String token) {
        return getJws(token).getHeader();
    }

    /**
     * 校验令牌
     *
     * @param token
     * @return 1 有效  0 无效  2 已过期
     */
    public static Integer verifyToken(String token) {

        try {
            Claims claims = AppJwtUtil.getClaimsBody(token);
            if (claims == null) {
                return SystemConstants.JWT_FAIL;
            }
            return SystemConstants.JWT_OK;
        } catch (ExpiredJwtException ex) {
            return SystemConstants.JWT_EXPIRE;
        } catch (Exception e) {
            return SystemConstants.JWT_FAIL;
        }
    }

    /**
     * 由字符串生成加密key
     *
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getEncoder().encode(TOKEN_ENCRY_KEY.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    public static void main(String[] args) {
       /* Map map = new HashMap();
        map.put("id","11");*/

        //生成令牌
        String token = AppJwtUtil.createToken(1102L);
        System.out.println(token);


        //解析令牌
        Claims claims = AppJwtUtil.getClaimsBody(token);
        Integer integer = AppJwtUtil.verifyToken("afdsaf");
        System.out.println(integer);
        System.out.println(claims);

    }
}