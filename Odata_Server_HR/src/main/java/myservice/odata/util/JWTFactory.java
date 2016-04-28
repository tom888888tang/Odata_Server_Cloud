package myservice.odata.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import myservice.table.entity.User;

public class JWTFactory {
	public static final String sign_key = "money_money";

	public static String getJWT(String request_ip, User user) {
		Calendar cl = Calendar.getInstance();
		cl.setTime(new Date());
		cl.add(Calendar.MINUTE, 5);
		Date exd = cl.getTime();
		Map claim = new HashMap();
		user.setPassword("");
		claim.put("user", user);
		byte[] key = sign_key.getBytes();
		return Jwts.builder().setClaims(claim).setExpiration(exd).setSubject(request_ip)
				.signWith(SignatureAlgorithm.HS512, key).compact();

	}
	
	public static String getJWT(String request_ip,String Jwt){
		if(Jwt == null){
			return "error";
		};
		
		byte[] key = sign_key.getBytes();
		try {
			if(request_ip.equals(Jwts.parser().setSigningKey(key).parseClaimsJws(Jwt).getBody().getSubject())){
				Jws<Claims> claims = Jwts.parser().setSigningKey(key).parseClaimsJws(Jwt);
				Calendar cl = Calendar.getInstance();
				cl.setTime(new Date());
				cl.add(Calendar.MINUTE, 5);
				Date exd = cl.getTime();
				Map claim = new HashMap();
				return Jwts.builder().setClaims(claims.getBody()).setExpiration(exd).setSubject(request_ip)
				.signWith(SignatureAlgorithm.HS512, key).compact();

			}else{
				return "error";
			}
		    //OK, we can trust this JWT

		} catch (SignatureException e) {
			return "error";
		    //don't trust the JWT!
		}

	}
}
