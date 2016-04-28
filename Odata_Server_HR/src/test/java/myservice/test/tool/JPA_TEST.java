package myservice.test.tool;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import myservice.table.entity.User;

public class JPA_TEST {

	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		// TODO Auto-generated method stub
		// We need a signing key, so we'll create one just for this example. Usually
		// the key would be read from your application configuration instead.
		
		  String KEY_STR = "encrypt@cncounter.com";
		 // 常量
		  String UTF_8 = "UTF-8";
		  String DES = "DES";
          Key key;
		   // KEY 生成器
		   KeyGenerator generator = KeyGenerator.getInstance(DES);
		   // 初始化,安全随机算子
		   generator.init(new SecureRandom( KEY_STR.getBytes(UTF_8) ));
		   // 生成密钥
		 //  keyg = generator.generateKey();
		 //  KeyGenerator kg = KeyGenerator.getInstance(KEY_STR);
		   key = 
				   //kg.generateKey();
//		   javax.crypto.SecretKey key2 = 
		MacProvider.generateKey();
//		//key.
//		   key2.
		User u = new User();
		u.setUser_id("123");
        Calendar cl = Calendar.getInstance();  
        cl.setTime(new Date());  
        cl.add(Calendar.MINUTE, 10); 
        Date exd = cl.getTime();
		Map claim = new HashMap();
		claim.put("user", u);
		JwtBuilder jwtb = Jwts.builder();
		jwtb.setClaims(claim);
		jwtb.setExpiration(exd);
        String ss = "qwe";
        byte[] aa = ss.getBytes();
		String jwt = Jwts.builder().setClaims(claim).setSubject("txg").signWith(SignatureAlgorithm.HS512, aa).compact();
		Key key2 = MacProvider.generateKey();
		byte[] bb = ss.getBytes();
		//Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
		//Claims c = (Claims) Jwts.parser().setSigningKey(key).parseClaimsJws(jwt);
		Key   key3 = 		MacProvider.generateKey(SignatureAlgorithm.HS512);
		//kg.generateKey();
		//SignatureAlgorithm.HS512
		String jwt_p = Jwts.parser().setSigningKey(bb).parseClaimsJws(jwt).getBody().getSubject();
		Jws<Claims> sss = Jwts.parser().setSigningKey(bb).parseClaimsJws(jwt);
		Map claim22 = (Map) sss.getBody().get("user");
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("Odata_Server_V1");  
        EntityManager em = factory.createEntityManager();  
		String user_id = "12";
		String password = "12";
		String customer_id = "12";
	
		EntityTransaction newTx = em.getTransaction();
	    newTx.begin();
	    String query = "select u from User u where u.user_id = '" + user_id + "' and u.password = '" 
	    + password + "' and " + "u.customer_id = '" + customer_id + "'";          
        newTx.commit();
        List result = em.createQuery(query).getResultList();
        User ur = (User) result.get(0);
        int w = 1;

	}

}
