package com.foodcourt.foodcourtmicro.configuration.bean.feign.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import java.security.Key;
import java.util.Date;
import java.util.function.Function;


@Service
public class JwtService {

    private String SECRET_KEY = "20F0AA9AADA0FB96C93EEB251E715BDAB305098774217B4DA8FA9DD4F65B8518";

    private Key getKey() {

        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes); //esto es para que se pueda encriptar
    }




    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){

        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts //extraer las claims del token
                .parser()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }



    private boolean isTokenExpired(String token) {

        return getExperation(token).before(new Date());
    }

    private Date getExperation(String token) {

        return getClaim(token, Claims::getExpiration);

    }

    public String extractRoleFromToken(String token) {

        Claims claims = getAllClaimsFromToken(token);
        return (String) claims.get("role");
    }

    public Integer extractIdFromToken(String token) {

        Claims claims = getAllClaimsFromToken(token);
        return (Integer) claims.get("id");

    }
}
