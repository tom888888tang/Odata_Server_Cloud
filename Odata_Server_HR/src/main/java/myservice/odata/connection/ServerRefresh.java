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

public class ServerRefresh extends HttpServlet{

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

		String jwt_from = req.getHeader("JWT");
		String ip = req.getRemoteAddr();
		String jwt = JWTFactory.getJWT(ip, jwt_from);
		if(jwt.equals("error")){
        	resp.setStatus(200);
        	PrintWriter out = resp.getWriter();
            out.write("error");
		}else{        	
        	resp.setStatus(200);
        	PrintWriter out = resp.getWriter();
            out.write(jwt); 

		};
		
//		HttpSession dd = ((HttpServletRequest) servletRequest).getSession();
//		    String user_id = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("user_id");
//		    String password = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("password");
//		    EntityTransaction newTx = em.getTransaction();
//		    newTx.begin();
//		    String query = "select * from user where user_id = '" + user_id + "' and password = '" + password + "'";
//            List result = em.createNativeQuery(query).getResultList();
//            newTx.commit();
//            if(result.size() != 1){
//            	String contextPath=((HttpServletRequest)servletRequest).getContextPath();  
//                ((HttpServletResponse)servletResponse).sendRedirect("/loginerror.html");
//            }else{
//        		filterChain.doFilter(servletRequest, servletResponse);            	
//            };
/*		httpResponse.addHeader("Access-Control-Allow-Origin", "*");
		httpResponse.addHeader("Access-Control-Allow-Headers","X-Requested-With, Cache-Control, Pragma, Origin, Authorization, Content-Type, X-Requested-With, Accept, accept, content-type, maxdataserviceversion");
		httpResponse.addHeader("Access-Control-Allow-Methods","GET, OPTIONS, POST");
		httpResponse.addHeader("Access-Control-Allow-Credentials","true");
		httpResponse.addHeader("Access-Control-Max-Age","1000");*/
	
		//To change body of implemented methods use File | Settings | File Templates.
	
	
	}
	
}	
	


