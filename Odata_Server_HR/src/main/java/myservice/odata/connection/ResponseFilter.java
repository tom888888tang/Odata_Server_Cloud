package myservice.odata.connection;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myservice.odata.util.JWTFactory;

import javax.servlet.http.HttpServletRequest;  

public class ResponseFilter implements Filter{
	private static EntityManagerFactory factory = null; //Persistence.createEntityManagerFactory("eclipselink");  
	private static EntityManager em = null; //factory.createEntityManager();  
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest hreq = (HttpServletRequest)servletRequest;
		String jwt_from = hreq.getHeader("JWT");
		String ip = servletRequest.getRemoteAddr();
		String jwt = JWTFactory.getJWT(ip, jwt_from);
		if(jwt.equals("error")){
			//((HttpServletResponse)servletRequest).setStatus(500);
        	PrintWriter out = servletResponse.getWriter();
        	//String user_json = gson.toJson(result);
            out.write(jwt); 
		}else{        	
			
			//PrintWriter out = servletResponse.getWriter();
        	//String user_json = gson.toJson(result);
            //out.write(jwt);
			((HttpServletResponse)servletResponse).setHeader("JWC", jwt);//.//addHeader("JWTC", jwt);
			filterChain.doFilter(servletRequest, servletResponse);

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

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		if(factory == null){
		   factory = Persistence.createEntityManagerFactory("Odata_Server_V1");
		};
		if(em == null){
	        em = factory.createEntityManager();
		};		
	}

}
