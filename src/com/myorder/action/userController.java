package com.myorder.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.muorder.util.Dictionaries;
import com.myorder.dao.TbUserMapper;
import com.myorder.model.TbUser;

@Controller
@RequestMapping("/userAction")
public class userController {
    @Resource
	private TbUserMapper userMapper;
	
	@RequestMapping("userLogin")
	  @ResponseBody
	public void userLogin(HttpServletRequest request, HttpServletResponse response,TbUser u) throws Exception{
		 HashMap<String,Object> map=new HashMap<String,Object>();
		TbUser user=userMapper.selectByLogin(u);
		if(user!=null){
			HttpSession session=request.getSession();
			session.setAttribute(Dictionaries.userSession, user);
			 map.put("success", 1);
		}
		else{
			map.put("success", 0);
		}
		
		Gson g=new Gson();
		   g.toJson(map);
		   response.getWriter().println(g.toJson(map));
	}
	
	 @RequestMapping("login")
	   public String to_login(){
		   return "master/login";
	   }
}
