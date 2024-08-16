package com.org;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyContoller {
                    
	@RequestMapping("/msg")//URL
	@ResponseBody
	public String getMsg() {
		
		return "<html><body><h1> HII </h1></body></html>";
	}
	
	@RequestMapping("/print")//URL
	public String PrintMsg() {
		
		return "print.jsp";
	}
	
	@RequestMapping("/add")//URL
	@ResponseBody
	public String addNums(@RequestParam int n1, @RequestParam int n2) {
		
		return "<html><body><h1> Sum is: "+(n1+n2)+"</h1></body></html>";
	}
	
	
	
}
