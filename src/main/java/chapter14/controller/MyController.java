package chapter14.controller;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import chapter14.pojo.Role;
import chapter14.pojo.Users;
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
	@RequestMapping("/roleredirect")
	public String roleredirect () {
		return "redirect:/my/roleParamPojo.action";
	}
	
	@RequestMapping("/login")
	public String login () {
		return "login";
	}
	
	@RequestMapping(value = "userlogin",method ={RequestMethod.POST,RequestMethod.GET} ,produces = {"application/json;charset=UTF-8"}
	,consumes = {"application/json;charset=UTF-8"}) 
	public String userlogin (@RequestParam(value="username",required=false) String username ,@RequestParam(value="userpwd",required=false) String userpwd ,HttpServletResponse res) {
		System.out.println("username"+username);
		System.out.println("userpwd"+userpwd);
		try {
			PrintWriter print =res.getWriter();
			print.write("{'hello':'hello'}");
			print.flush();
			print.close();
			print = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping(value = "userloginrequest",method ={RequestMethod.POST} ,produces = {"application/json;charset=UTF-8"}) 
	@ResponseBody
	public String userloginrequest (@RequestBody Users users,HttpServletResponse res) {
		System.out.println("username"+users.getUsername());
		System.out.println("userpwd"+users.getUserpwd());
		try {
			PrintWriter print =res.getWriter();
			print.write("{'hello':'hello'}");
			print.flush();
			print.close();
			print = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@RequestMapping(value = "userlogintwo",method ={RequestMethod.POST} ,produces = {"application/json;charset=UTF-8"}) 
	@ResponseBody
	public String userlogintwo (@RequestBody Map<String,Object> map,HttpServletResponse res) {
		System.out.println("username"+map.get("username").toString());
		try {
			PrintWriter print =res.getWriter();
			print.write("{'hello':'hello'}");
			print.flush();
			print.close();
			print = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	@RequestMapping("/roleredirectview")
	public ModelAndView roleredirectview () {
		List list = roleservice.getAllRole();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("rolelist");
		mv.addObject("rolelist", list);
		mv.setViewName("redirect:/my/roleParamPojo.action");
		return mv;
	}
	
	
	
	
	public RoleService getRoleservice() {
		return roleservice;
	}

	public void setRoleservice(RoleService roleservice) {
		this.roleservice = roleservice;
	}
}
