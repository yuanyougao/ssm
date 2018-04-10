package chapter14.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import chapter14.pojo.Role;
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
	public ModelAndView rolelist (@RequestParam(value="id",required=false,defaultValue = "1") int id ,@RequestParam("username") String username) {
		System.out.println(id);
		System.out.println(username);
		List list = roleservice.getAllRole();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rolelist");
		mv.addObject("rolelist", list);
		return mv;
	} 
	
	@RequestMapping("/roleSessionAttribute")
	public ModelAndView roleSessionAttribute (@SessionAttribute(value ="username",required=false) String username) {
		System.out.println(username);
		List list = roleservice.getAllRole();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rolelist");
		mv.addObject("rolelist", list);
		return mv;
	} 
	//无需任何注解
	@RequestMapping("/roleParam")
	public ModelAndView roleParam (String username) {
		System.out.println(username);
		List list = roleservice.getAllRole();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rolelist");
		mv.addObject("rolelist", list);
		return mv;
	}
	
	//无需任何注解
		@RequestMapping("/roleParamPojo")
		public ModelAndView roleParamPojo (Role role) {
			System.out.println("id:"+role.getId());
			System.out.println("username:"+role.getUsername());
			List list = roleservice.getAllRole();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("rolelist");
			mv.addObject("rolelist", list);
			return mv;
		}
	
	@RequestMapping("/getRole/{id},{username}")
	public ModelAndView getRoleById (@PathVariable("id") int id ,@PathVariable("username") String username) {
		System.out.println("id:"+id);
		System.out.println("username:"+username);
		List list = roleservice.getAllRole();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rolelist");
		mv.addObject("rolelist", list);
		return mv;
	}
	
	
	
	
	public RoleService getRoleservice() {
		return roleservice;
	}

	public void setRoleservice(RoleService roleservice) {
		this.roleservice = roleservice;
	}
}
