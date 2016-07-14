package com.test.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.test.dao.Rightmapper;
import com.test.dao.UserRigthRotemapper;
import com.test.dao.Usermapper;
import com.test.model.Right;
import com.test.model.UserRigthRote;
import com.test.model.Users;

@Controller
@RequestMapping("/usersController")
public class userController {
	@Resource
   private Usermapper userMapper;
	@Resource
	private Rightmapper rightmapper;
	@Resource
	private UserRigthRotemapper userrightMapper;
   
	/**
	 * 添加用户
	 * 注册方法提交
	 * @param u
	 * @return
	 */
   @RequestMapping("inserUser")
   public  String insertUser(Users u){
	   userMapper.insertUser(u);
	   return "master/login";
   }
   
   /**
    * 跳转登入方法
    * @return
    */
   @RequestMapping("login")
   public String to_login(){
	   return "master/login";
   }
   /**
    * 跳转注册方法
    * @return
    */
   @RequestMapping("to_register")
   public String to_register(){
	   return "master/register";
   }
   
   /**
    * 判断注册时候用户名是否存在
    * @param request
    * @param response
    * @param u
    * @throws Exception
    */
   @RequestMapping("test_name")
   @ResponseBody
   public void QueryByname(HttpServletRequest request, HttpServletResponse response,Users u) throws Exception{
	   int i= userMapper.fundByName(u.getLoginName());
	   HashMap<String, Object> map=new HashMap<>();
	   Gson gson=new Gson();
	   map.put("num", i);
	   String s=gson.toJson(map);
	   System.out.println(s);
	   response.getWriter().print(s);
   }
 
   /**
    * 登入方法
    * @param request
    * @param response
    * @param u
    * @return
 * @throws IOException 
    */
   @RequestMapping("userLogin")
   @ResponseBody
   public void userLogin(HttpServletRequest request, HttpServletResponse response,Users u) throws IOException{
	   Users user= userMapper.userLogin(u);
	   HashMap<String,Object> map=new HashMap<String,Object>();
	   if(user!=null){
		  HttpSession session= request.getSession();
		  session.setAttribute("users", user);
		  System.out.println("session已经注入");
		  map.put("success", 1);
		 	   }
	   else{
		   map.put("success", 0);
	   }
	   Gson g=new Gson();
	   g.toJson(map);
	   response.getWriter().println(g.toJson(map));
//	   return "master/login";
   }
   
   @RequestMapping("toMain")
   public String toMain(){
	   System.out.println("登入成功跳转");
	   return "master/mainbody";
   }
   
	 @RequestMapping("addOrder")
	 public String addOrder(){
		 System.out.println("进入添加");
		 return "master/login";
	 }
   
   
   /**
    * 主页面构造，头部
    * @return
    */
   @RequestMapping("top")
   public String top(){
	   return "master/top";
   }
   
   /**
    * 主页面构造左边菜单栏
    * @param request
    * @param response
    * @return
    */
   @RequestMapping("left")
   public String left(HttpServletRequest request, HttpServletResponse response){
	   Users u= (Users) request.getSession().getAttribute("users");
	   List<UserRigthRote> list= userrightMapper.findUrl(u);
	   List<Right> listr= rightmapper.findRoteList();
	   for (Right right : listr) {
		  List<Right> listr2=   rightmapper.findRoteListByfatherId(right.getId());
		  right.setListRight(listr2);
       	}
	   System.out.println("数据长度是"+listr.size());
	   request.getSession().setAttribute("listRote", listr);
	   return "master/left";
   }
   
   /**
    * 主页面构成
    * 右边主要显示，操作栏
    * @return
    */
   @RequestMapping("right")
   public String right(){
	   return "master/right";
   }
}
