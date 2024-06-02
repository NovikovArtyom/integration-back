package test.project.integration.backend.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.*;

import java.util.Date;

@Component
@Slf4j
public class JwtCore {
    @Value("${backend.app.secret}")
    private String secret;
    @Value("${backend.app.lifetime}")
    private int lifetime;

    public String generateToken(Authentication authentication) {
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return Jwts.builder().setSubject((userDetails.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + lifetime))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public String getNameFromJwt(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
            return claims.getSubject();
        } catch (ExpiredJwtException ex) {
            // Обработка ситуации, когда токен истек
            log.error("JWT-токен истек", ex);
            return null; // или бросить исключение или выполнить другую обработку
        } catch (Exception e) {
            // Обработка других возможных исключений
            log.error("Ошибка разбора JWT-токена", e);
            return null; // или бросить исключение или выполнить другую обработку
        }
    }
}
