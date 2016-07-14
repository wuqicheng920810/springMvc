/*package com.test.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.test.dao.Studentmapper;
import com.test.dao.StudentDaoImpl;
import com.test.model.Student;
import com.test.model.Users;

@Controller
@RequestMapping("/firstController")
public class FirstController {
//	@Resource
//	private StudentDaoImpl studengDao;
	@Resource
	private Studentmapper testMapper;
	
	@RequestMapping("/list")
	public String main(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("aaaa");
		return "first";
	}
	
	@RequestMapping("test")
	public String test(HttpServletRequest request, HttpServletResponse response,@RequestParam("name") String name){
		System.out.println(name);
		request.setAttribute("msg", name);
		return "first";
	}

	
	@RequestMapping("to_test")
	public String toTest(HttpServletRequest request, HttpServletResponse response){
		System.out.println("进入了新的一个路径");
		return "index/index";
	}
	
	@RequestMapping("to_login")
	public String to_login(){
		System.out.println("进入跳转方法");
		return "/to_login";
	}
	
	@RequestMapping("loginAction")
	@ResponseBody
	public void loginAction(HttpServletRequest request, HttpServletResponse response,Users u) throws Exception{
//		System.out.println("用户名"+u.getUserName()+"-----------------密码"+u.getPassWord());
		//传统dao方法调用
//		Student st= studengDao.test1();
		//Mapper方式调用
//		Student st=testMapper.fundByID(1);
		HashMap<String, Object> map=new HashMap<String,Object>(); 
		if(st!=null){
			map.put("success", true);
		}
		else{
			map.put("success", false);
		}
		map.put("data", st);
		Gson g=new Gson();
	    String s=	g.toJson(map);
	    System.out.println(s);
        response.getWriter().print(s);
	}
	
	*//** 
	 * ajax测试 
	* http://localhost:8080/FreeMarkerTest/firstController/ajax.do
	 *//*  
	  
	@RequestMapping("/ajax")  
	@ResponseBody  
	public Object ajax(HttpServletRequest request){  
	    List<String> list=new ArrayList<String>();  
	    list.add("电视");  
        list.add("洗衣机");  
	    list.add("冰箱");  
	    list.add("电脑");  
	    list.add("汽车");  
	    list.add("空调");  
	    list.add("自行车");  
	    list.add("饮水机");  
	    list.add("热水器");  
	    return list;  
	}
	
	  @RequestMapping(value = "/upload.do")  
	    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model) {  
	        String s= request.getParameter("userId").toString();
	        System.out.println(s+"..........");
	        System.out.println("开始");  
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();  
//	        String fileName = new Date().getTime()+".jpg";  
	        System.out.println(path);  
	        File targetFile = new File(path, fileName);  
	        if(!targetFile.exists()){  
	            targetFile.mkdirs();  
	        }  
	        //保存  
	        try {  
	            file.transferTo(targetFile);  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }  
	        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
	  
	        return "index3";  
	    }  
	
}
*/