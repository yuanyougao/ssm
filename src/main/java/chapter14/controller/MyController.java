package chapter14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import chapter14.service.RoleService;

@Controller("myController")
@RequestMapping("my")
public class MyController {

	@Autowired
	private RoleService roleservice;

	@RequestMapping("/index")
	public ModelAndView index (@RequestParam(value="id",required=false) int id ,@RequestParam("username") String username) {
		System.out.println(id);
		
		System.out.println(username);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/rolelist")
	public ModelAndView rolelist (@RequestParam(value="id",required=false) int id ,@RequestParam("username") String username) {
		System.out.println(id);
		System.out.println(username);
		List list = roleservice.getAllRole();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rolelist");
		return mv;
	}
	
	
	public RoleService getRoleservice() {
		return roleservice;
	}

	public void setRoleservice(RoleService roleservice) {
		this.roleservice = roleservice;
	}
}
