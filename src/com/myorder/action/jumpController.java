package com.myorder.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.muorder.util.Dictionaries;
import com.myorder.dao.TBPaytypeMapper;
import com.myorder.dao.TBPersmissionMapper;
import com.myorder.model.TBBill;
import com.myorder.model.TBPaytype;
import com.myorder.model.TBPersmission;

@Controller
@RequestMapping("/jumpAction")
public class jumpController {
		
	@Resource
	private TBPaytypeMapper payTypeMapper ;
	
	@Resource
	private TBPersmissionMapper persmissionMapper;
	
	
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
		   List<TBPersmission> listfather=getPersmissionList();
		   request.getSession().setAttribute("listRote", listfather);
		   return "master/left";
	   }
	   @RequestMapping("right")
	   
	   public String right(){
		   return "master/right";
	   }
	   
	   public List<TBPersmission> getPersmissionList(){
		   List<TBPersmission> listfather= persmissionMapper.selectFatherPermission( );
		   for (TBPersmission tbPersmission : listfather) {
			   List<TBPersmission> listson= persmissionMapper.selectSonPermission(tbPersmission.getId());
			   tbPersmission.setPersmissionList(listson);
		}
		   return listfather;
	   }
	   
	   @RequestMapping("changPersminssion")
	   public String changPersminssion(HttpServletRequest request, HttpServletResponse response){
		   List<TBPersmission> listfather=getPersmissionList();
		   request.getSession().setAttribute("listRote", listfather);
		   return "master/Persmission/updatePersmission";
	   }

	   //跳转到添加页面
	   @RequestMapping("toAddBill")
	   public ModelAndView  toAddBill( HttpServletRequest request, HttpServletResponse response){
		   ModelAndView mav = new ModelAndView("master/Bill/addBill"); 
		   List<TBPaytype> goodsList=  payTypeMapper.selectSomeType(Dictionaries.goodsType);
		   List<TBPaytype>payList=payTypeMapper.selectSomeType(Dictionaries.payType);
		   mav.addObject("goodsList", goodsList);
		   mav.addObject("payList", payList);
		   TBBill b=   new TBBill();
		   b.setGoodstpye(1);
		   mav.addObject("bill",b );
		   return mav;
	   }
	   
	   //跳转查询页面
	   @RequestMapping("toQuertBill")
	   public ModelAndView toQuery(){
		   ModelAndView mav = new ModelAndView("master/Bill/showBill"); 
		   List<TBPaytype> goodsList=  payTypeMapper.selectSomeType(Dictionaries.goodsType);
		   List<TBPaytype>payList=payTypeMapper.selectSomeType(Dictionaries.payType);
		   mav.addObject("goodsList", goodsList);
		   mav.addObject("payList", payList);
		   TBBill b=   new TBBill();
		   b.setGoodstpye(1);
		   mav.addObject("bill",b );
		   return mav;
	   }
}
