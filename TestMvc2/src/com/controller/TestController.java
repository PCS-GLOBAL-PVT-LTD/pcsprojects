package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.model.Model;


@Controller

public class TestController {

	@RequestMapping (value="/toshow")
	public ModelAndView show(){
		ModelAndView mv=new ModelAndView();
		String print="this is for mvc test";
		mv.addObject("showmv",print);
		mv.addObject("userobj",new Model("Asoke", 25, 1000));
		mv.setViewName("view");
		return mv;
		
		
		
	}
	
	
}
