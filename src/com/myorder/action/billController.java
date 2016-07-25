package com.myorder.action;

import java.io.File;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.muorder.util.Dictionaries;
import com.myorder.dao.TBBillMapper;
import com.myorder.model.PackBill;
import com.myorder.model.TBBill;
import com.myorder.model.TbUser;

@Controller
@RequestMapping("billAction")
public class billController {
	
	@Resource
	private TBBillMapper billMapper;
	
	/**
	 * 添加单据方法，含图片上传
	 * @param file
	 * @param request
	 * @param model
	 * @param bill
	 * @return
	 */
	@RequestMapping("addBill")
	public String addBill(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, ModelMap model,TBBill bill) {  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        TbUser user= (TbUser) request.getSession().getAttribute(Dictionaries.userSession);
        bill.setUserid(user.getId());
        if(file!=null){
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
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
        bill.setImageurl(request.getContextPath()+"/upload/"+fileName);
        }
        bill.setCreatedate(new Date());
      System.out.println(bill.toString());
      int codeId= billMapper.insert(bill);
      System.out.println("............"+codeId);
		return "redirect:/jumpAction/toQuertBill.do";
	}
	
	@RequestMapping("queryBill")
	public String queryBySome(PackBill pbill){
		System.out.println("..............");
		billMapper
		return "";
	}
	

}
