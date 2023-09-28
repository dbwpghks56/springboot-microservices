package net.javaguides.apigateway.config.security.provider;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@Slf4j
public class JwtTokenProvider {
    @Value("${jwt.secret}")
    private String jwtSecret;

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String generateAccessToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + (1000L * 60 * 60 * 24 * 7));

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setIssuer("gatewayUser")
                .setExpiration(expireDate)
                .signWith(key())
                .compact();

        return token;
    }

    public String generateRefreshToken(Authentication authentication) {
        String username = authentication.getName();

        Date currentDate = new Date();
        Date expireDate = new Date(currentDate.getTime() + (1000L * 60 * 60 * 24 * 7));

        String refreshToken = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(currentDate)
                .setIssuer("gatewayRefresh")
                .setExpiration(expireDate)
                .signWith(key())
                .compact();

        return refreshToken;
    }

    public String getUsernameForToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key())
                .build()
                .parseClaimsJwt(token)
                .getBody()
                .getSubject();
    }

    public boolean validToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJwt(token);
            return true;
        } catch (ExpiredJwtException e) {
            throw new ExpiredJwtException(null, null, "만료된 토큰 " + token);
        }
    }

}
