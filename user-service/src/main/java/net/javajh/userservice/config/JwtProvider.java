package net.javajh.userservice.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import net.javajh.userservice.common.exception.user.UserAlreadyUseException;
import net.javajh.userservice.presentation.dto.response.UserResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Objects;

@Component
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
                .claim("userData", userResponseDto)
                .signWith(keys())
                .compact();
    }

    public String generateRefreshToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setIssuer("apiUserRefresh")
                .setExpiration(new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 7 * 2)))
                .signWith(keys())
                .compact();
    }

    public String getUsernameAccessToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(keys())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

    public Object getUserDataAccessToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(keys())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .get("userData");
    }

    public boolean validToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(keys())
                    .build()
                    .parseClaimsJwt(token);

            return true;
        } catch (Exception e) {
            throw new UserAlreadyUseException();
        }
    }
}
