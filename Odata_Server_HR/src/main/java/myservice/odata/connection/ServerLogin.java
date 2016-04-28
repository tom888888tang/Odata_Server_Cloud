package myservice.odata.connection;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Key;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Response;

import org.apache.cxf.helpers.IOUtils;
import org.json.JSONObject;

import com.google.gson.Gson;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import myservice.odata.util.JWTFactory;
import myservice.table.entity.User;

public class ServerLogin extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		// We need a signing key, so we'll create one just for this example. Usually
		// the key would be read from your application configuration instead.
		String json = IOUtils.toString(req.getInputStream()); 
		JSONObject jsonObject = new JSONObject(json);
		String user_id = jsonObject.getString("User_id");
		//String user_id = getParameter("12");
		String password = jsonObject.getString("Password");
		String customer_id = jsonObject.getString("Customer_id");
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Odata_Server_V1");
		EntityManager em = factory.createEntityManager();		
		EntityTransaction newTx = em.getTransaction();
	    newTx.begin();
	    String query = "select u from User u where u.user_id = '" + user_id + "' and u.password = '" 
	    + password + "' and " + "u.customer_id = '" + customer_id + "'"; 
        List<User> result = em.createQuery(query).getResultList();
        newTx.commit();
        if(result.size() == 1){
        	User user = result.get(0);
        	String ip = ip = req.getRemoteAddr();
//            if (req.getHeader("x-forwarded-for") == null) {  
            	//ip = req.getRemoteAddr();  
//            }else{  
//                ip = req.getHeader("x-forwarded-for");  
//            } 
            String jwt = JWTFactory.getJWT(ip, user);
        	Gson gson = new Gson();
        	resp.setStatus(200);
        	PrintWriter out = resp.getWriter();
        	//String user_json = gson.toJson(result);
            out.write(jwt);  
        }else{        	
        	resp.setStatus(200);
        	PrintWriter out = resp.getWriter();
            out.write("Login Failed");         	
        }
	
	
	}
	
}	
	


