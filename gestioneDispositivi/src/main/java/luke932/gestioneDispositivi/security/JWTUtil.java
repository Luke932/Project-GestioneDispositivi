package luke932.gestioneDispositivi.security;

import java.security.Key;
import java.util.Date;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	private final Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private final long expirationTime = 864000000; // Scadenza dopo 10 giorni

	public String generateToken(UserDetails userDetails) {
		Date now = new Date();
		Date expiration = new Date(now.getTime() + expirationTime);

		Claims claims = Jwts.claims().setSubject(userDetails.getUsername());
		claims.put("authorities", userDetails.getAuthorities());

		return Jwts.builder().setClaims(claims).setIssuedAt(now).setExpiration(expiration).signWith(secretKey)
				.compact();
	}
}
