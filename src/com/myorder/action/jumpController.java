package com.myorder.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jumpAction")
public class jumpController {
	
	
	@RequestMapping("toMain")
	   public String toMain(){
		   System.out.println("登入成功跳转");
		   return "master/mainbody";
	   }
	
	   @RequestMapping("top")
	   public String top(){
		   return "master/top";
	   }
	   
	   @RequestMapping("left")
	   public String left(HttpServletRequest request, HttpServletResponse response){
		 /*  Users u= (Users) request.getSession().getAttribute("users");
		   List<UserRigthRote> list= userrightMapper.findUrl(u);
		   List<Right> listr= rightmapper.findRoteList();
		   for (Right right : listr) {
			  List<Right> listr2=   rightmapper.findRoteListByfatherId(right.getId());
			  right.setListRight(listr2);
	       	}
		   System.out.println("数据长度是"+listr.size());
		   request.getSession().setAttribute("listRote", listr);*/
		   return "master/left";
	   }
	   
	   @RequestMapping("right")
	   public String right(){
		   return "master/right";
	   }

}
