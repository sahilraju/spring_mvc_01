package com.org.controller;

import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.EmployeeDao;
import com.org.dto.Employee;

@Controller 
public class EmployeeController {
	
	@RequestMapping("/save")
	public ModelAndView saveEmployee(@ModelAttribute Employee e) {
		
		ModelAndView mav = new ModelAndView("emp.jsp");
		boolean res = EmployeeDao.saveEmp(e);
		if(res) {
			mav.addObject("msg","data saved sucessfully");
		}else {
			mav.addObject("msg", "something went wrong");
		}
		return mav;
		
	}
	
	@RequestMapping("/get")
	public String getEmployees(HttpSession hs) {
		
		List<Employee> emps = EmployeeDao.getAllEmployees();
		hs.setAttribute("emps", emps);
		
		return "display.jsp";
		
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteEmployee(@RequestParam int id) {
		
		ModelAndView mav = new ModelAndView("get");
		boolean res = EmployeeDao.deleteEmployee(id);
		if(res) {
			mav.addObject("msg", "data deleted successfully");
		}
		return mav;
		
	}
	
	@RequestMapping("/edit")
	public ModelAndView editEmployee(@RequestParam int id) {
		
		Employee e = EmployeeDao.findById(id);
		ModelAndView mav = new ModelAndView("update.jsp");
		mav.addObject("emp" , e);
		return mav;
		
	}
	 
	@RequestMapping("/update")
	public ModelAndView updateEmp(@ModelAttribute Employee e) {
		EmployeeDao.updateEmployee(e);
		ModelAndView mav = new ModelAndView("get");
		mav.addObject("msg", "data updated successfully");
		return mav;
		
	}
	
}
