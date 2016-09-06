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
	/*	String url= request.getRequestURI();
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
			
		}*/
     return true;
	}

}
