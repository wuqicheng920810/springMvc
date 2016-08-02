/**

 * 
 */
package com.test.filter;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.muorder.util.Dictionaries;
import com.myorder.model.TbUser;



/**
 * 应用系统资源占用监控
 * @author XiaoPeng
 * @date 2015-10-30
 */
public class ApplicationMonitor implements HttpSessionListener,ServletRequestListener {
	
   private HttpServletRequest request;
	
	
	public static final String APP_Hold_Sessions = "Hold_Sessions";
	private static final String Remote_Request_IP = "Remote_Request_IP";
	
	public void requestInitialized(ServletRequestEvent event) {
		  request = (HttpServletRequest)event.getServletRequest();
		  
		 }
	/**
	 * Session会话创建监控
	 * 通过应用上下文持有会话Session，籍此使用sessions.size()获取当前活动的session数，即为“在线人数”
	 * @author XiaoPeng
	 * @date 2015-10-30
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	public void sessionCreated(HttpSessionEvent evt) {
		HttpSession session = evt.getSession();
		System.out.println(session.getId()+"..............................");
		ServletContext context=evt.getSession().getServletContext();
		String ip= getIp();
	    TbUser user=	 (TbUser) session.getAttribute(Dictionaries.userSession);
		if(user != null) {
			System.out.println(">>>>>>>Http Session Created--uid:"+user.getLoginname() + "(" + user.getUsername() + ")" + "/"+ip );
		} else {
			System.out.println(">>>>>>>Http Session Created--id:"+session.getId() + "/"+ip );
		}
		Integer loginNum=(Integer)context.getAttribute("count");
		if(loginNum==null){ 
			loginNum=new Integer(1); 
        }else{ 
            int co = loginNum.intValue( ); 
            loginNum= new Integer(co+1); 
        } 
		 System.out.println("**************【系统当前在线人数："+ loginNum +"人】**************"); 
        context.setAttribute("count", loginNum);//保存人数 
           
}

	/**
	 * Session会话销毁监控
	 * @author XiaoPeng
	 * @date 2015-10-30
	 * @param evt
	 */
	@SuppressWarnings("unchecked")
	public void sessionDestroyed(HttpSessionEvent evt) {/*
		HttpSession session = evt.getSession();
		ServletContext application = session.getServletContext();
		// 请求用户IP
		String remoteIP = (String) session.getAttribute(Remote_Request_IP);
		//用户注销帐号信息审核
		IUser user = (IUser) session.getAttribute(AuthorityConstants.Login_User_Info);
		if(user != null) {
			System.out.println(">>>>>>>Http Session Destroyed--uid:"+user.getNick_name() + "(" + user.getUser_name() + ")" + "/" + remoteIP
					+ "[用户登录时间："+session.getAttribute(AuthorityConstants.USER_LOGIN_TIME_Audit)+"||失效时间："+new Date()+"]");
		} else {
			System.out.println(">>>>>>>Http Session Destroyed--(未登录用户)" + "/" + remoteIP 
					+ "[登入系统时间："+session.getAttribute(AuthorityConstants.USER_LOGIN_TIME_Audit)+"||失效时间："+new Date()+"]");
		}
		// 销毁的session均从HashSet集中移除
		HashSet<HttpSession> sessions = (HashSet<HttpSession>) application.getAttribute(APP_Hold_Sessions);
        sessions.remove(session);
        System.out.println("**************【系统当前在线人数："+ sessions.size() +"人】**************");
	*/}
	@Override
	public void requestDestroyed(ServletRequestEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public String getIp(){
		  String ip = request.getHeader("x-forwarded-for");   
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	           ip = request.getHeader("Proxy-Client-IP");   
	       }   
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	           ip = request.getHeader("WL-Proxy-Client-IP");   
	       }   
	       if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {   
	           ip = request.getRemoteAddr();   
	           if(ip.equals("127.0.0.1")){     
	               //根据网卡取本机配置的IP     
	               InetAddress inet=null;     
	               try {     
	                   inet = InetAddress.getLocalHost();     
	               } catch (UnknownHostException e) {     
	                   e.printStackTrace();     
	               }     
	               ip= inet.getHostAddress();     
	           }  
	       }   
	       // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
	       if(ip != null && ip.length() > 15){    
	           if(ip.indexOf(",")>0){     
	               ip = ip.substring(0,ip.indexOf(","));     
	           }     
	       }     
		 System.out.println("___________________________________"+ip);
		 return ip;
	}
	
}
