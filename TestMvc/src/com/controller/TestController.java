package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dao.TestDao;
import com.model.TestModel;

@Controller
public class TestController {
	
	private TestDao dao;
	
	@Autowired
	public void setDao(TestDao dao) {
		this.dao = dao;
	}
	@RequestMapping (value="towelcome")
	public ModelAndView show(){
		ModelAndView mv=new ModelAndView();
		String print="this is for mvc test";
		mv.addObject("showmv",print);
		mv.addObject("userobj",new TestModel("asoke",22));
		
		mv.setViewName("view");
		
		
		return mv;
	}
	
	@RequestMapping(value="formreceiver")
	public ModelAndView receaiveForm(@ModelAttribute("userobj")@Valid TestModel obj,BindingResult result,ModelAndView mv) {
    System.out.println("name "+obj.getName());
    System.out.println("age "+obj.getAge());
   
   
    /*if(status==1){
		mv.setViewName("view");
		mv.addObject("msg","1 record inserted");
		mv.addObject("userobj",new TestModel());
    	return mv;
    }else{
	   mv.setViewName("view");
		mv.addObject("msg","operation failed");
		return mv;
		
	}*/
    
    if(result.hasErrors()){
		mv.setViewName("view");
    	return mv;
    }else{
    	 int status = dao.save(obj);
	   mv.setViewName("completeregistration");
	   System.out.println("status "+status);
		return mv;
		
	}
	}
	
	@RequestMapping(value="opendeleteform")
	public ModelAndView opendelete(){
		ModelAndView mv1=new ModelAndView();
		mv1.setViewName("deleteform");
	
		return mv1;
	}
	
	@RequestMapping(value="deleteaction")
	public ModelAndView deleteData(int id){
		System.out.println("id for delete"+id);
		int status=dao.delete(id);
		/*ModelAndView mv2=new ModelAndView();
		mv2.setViewName("afterdelete");
		mv2.setViewName("employeeDeatils");*/
		ModelAndView mv2=viewEmployee();
		return mv2;
		
	}
	
	@RequestMapping(value="openupdateform")
	public ModelAndView openUpdate(){
		ModelAndView mv1=new ModelAndView();
		mv1.setViewName("updateform");
	
		return mv1;
	}
	@RequestMapping(value="updateprocess")
	public ModelAndView updateform(int id){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("openupdatepage");
		TestModel obj=new TestModel();
		obj.setId(id);
		/*mv.addObject("userobj",obj);*/
		mv.addObject("userobj",dao.getemp(id));
		return mv;
		
	}
	
	@RequestMapping(value="updateaction")
	public ModelAndView updatedata(@ModelAttribute("userobj") TestModel obj2){
		System.out.println("id for delkete: "+obj2.getId());
		int status=dao.update(obj2);
		/*ModelAndView mv2=new ModelAndView();
		mv2.setViewName("afterupdate");*/
		ModelAndView mv2=viewEmployee();
		return mv2;
		
	}
	@RequestMapping(value="viewall")
	public ModelAndView viewEmployee(){
		List<TestModel> emplist=dao.showall();
		System.out.println("list size"+emplist.size());
		ModelAndView mv3=new ModelAndView();
		mv3.addObject("showemp", emplist);
		mv3.setViewName("employeeDeatils");
		return mv3;
		
		
		
		
	}
}
