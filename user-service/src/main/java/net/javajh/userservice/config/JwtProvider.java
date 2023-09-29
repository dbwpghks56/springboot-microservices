package net.javajh.userservice.config;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import net.javajh.userservice.common.exception.user.UserAlreadyUseException;
import net.javajh.userservice.presentation.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Objects;

@Component
@Slf4j
public class JwtProvider {
    @Value("${jwt.secret}")
    private String secretKey;

    private Key keys() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    public String generateAccessToken(String username, UserResponseDto userResponseDto) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setIssuer("apiUserAccess")
                .setExpiration(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7)))
                .signWith(keys(), SignatureAlgorithm.HS512)
                .claim("userData", userResponseDto)
                .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setIssuer("apiUserRefresh")
                .setExpiration(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7 * 2)))
                .signWith(keys(), SignatureAlgorithm.HS512)
                .compact();
    }

    public String getUsernameAccessToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(keys())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public LinkedHashMap<String, Object> getUserDataAccessToken(String token) {
        return (LinkedHashMap<String, Object>) Jwts.parserBuilder()
                .setSigningKey(keys())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("userData");
    }

    public boolean validToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(keys())
                    .build()
                    .parseClaimsJws(token);

            return true;
        } catch (ExpiredJwtException e) {
            throw new ExpiredJwtException(null, null, "만료된 토큰입니다. msg=" + e.getMessage());
        } catch (UnsupportedJwtException e) {
            throw new UnsupportedJwtException("지원하지 않는 토큰 형식입니다. msg=" + e.getMessage());
        } catch (MalformedJwtException e) {
            throw new MalformedJwtException("유효하지 않는 토큰입니다. Refresh Token 을 활용한 재갱신이 필요합니다. msg=" + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("유효하지 않은 인자입니다. msg=" + e.getMessage());
        }
    }
}
