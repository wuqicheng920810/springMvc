package com.test.filter;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.muorder.util.Dictionaries;
import com.myorder.dao.TBBearPerMapper;
import com.myorder.dao.TBPersmissionMapper;
import com.myorder.model.TBBearPer;
import com.myorder.model.TBPersmission;
import com.myorder.model.TbUser;
import com.test.dao.Rightmapper;
import com.test.dao.UserRigthRotemapper;
import com.test.model.Right;
import com.test.model.UserRigthRote;
import com.test.model.Users;

public class LoginFilter implements HandlerInterceptor {
	
	@Resource
	private TBPersmissionMapper persmissionMapper;
	
	@Resource
	private TBBearPerMapper bearPerMapper;
	

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object arg2) throws Exception {
		String url= request.getRequestURI();
		String[] geturl=url.split("/");
		String goUrl=geturl[geturl.length-2]+"/"+geturl[geturl.length-1];
		//未登入
		if(request.getSession().getAttribute(Dictionaries.userSession)==null){
			//如果是登入方法则放行
			if(goUrl.equals("userAction/login.do")
			  ||goUrl.equals("userAction/userLogin.do")
					){
				return true;
			}
			//其他方法调用跳转到登入页面
			else{
				request.getRequestDispatcher("/userAction/login.do").forward(request, response);
			}
		}
		//已登入
		else{
		    TbUser user=	(TbUser) request.getSession().getAttribute(Dictionaries.userSession);
		    System.out.println("--------------------------------");
			List<TBPersmission> listp= persmissionMapper.selectAll();
			TBBearPer per=new TBBearPer();
			per.setRoleid(user.getRoleid());
			for (TBPersmission tbPersmission : listp) {
				//循环比较需要拦截的跳转地址
				if(tbPersmission.getPerurl().equals(goUrl)){
					per.setPermissinid(tbPersmission.getId());
					//查询权限关系表，有权限则跳转，没权限则打回
					int count= bearPerMapper.selectByPermissionAndRole(per);
					
					if(count!=0){return true;}
					else{return false;}
				}
			}
			return true;
			
		}
		// TODO Auto-generated method stub
		/*HttpSession session=arg0.getSession();
		Users u=(Users) session.getAttribute("users");
		System.out.println( arg0.getRequestURI());
		String url= arg0.getRequestURI();
		String[] geturl=url.split("/");
		String newUrl=geturl[geturl.length-1];
		System.out.println("进入拦截器");
		//如果已登入则权限判断
		if(u!=null){
		//获取所有的需要权限的拦截地址
		 List<Right> listright= rightMapper.findUrl();
		 for (Right right : listright) {
			 //如果访问的地址是需要权限的地址之一则判断权限
			if(newUrl.equals(right.getRight_url())){
				System.out.println(right.getRight_url());
				//获取当前用户的所有权限记录
					 List<UserRigthRote> list =userrightMapper.findUrl(u);
					 for (UserRigthRote userRigthRote : list) {
						List<Right> listrt=  rightMapper.findByRote(userRigthRote.getRight_id());
						//对比所有的跳转地址和目前地址有相同则跳转
						for (Right right2 : listrt) {
							if(right2.getRight_url().equals(newUrl)){
								return true;
							}
						}
					}
				return false;
			}
		   }
		}
		//未登入时候可进入免登入方法
		else{
			if(newUrl.equals("login.do")
					||newUrl.equals("to_register.do")
					||newUrl.equals("inserUser.do")
					||newUrl.equals("test_name.do")
					||newUrl.equals("userLogin.do")
					){
				   System.out.println("免登入方法");
				   return true;
			}
			//权限验证方法
			else{
			
			arg0.getRequestDispatcher("master/login").forward(arg0, arg1);
			}
		}*/
     return true;
	}

}
