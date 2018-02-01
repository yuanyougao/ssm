package chapter10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(PageConfig.class);
		/*Role role =(Role)ctx.getBean(Role.class);
		RoleService roleservice =(RoleService)ctx.getBean(RoleService.class);
		roleservice.printRoleInfo(role);*/
		//@Primary //如果有多个子类，加入primary会优先选择
		/**
		 * 如果只加入autowired的话，默认使用类型注入  
		 * required默认false true:如果没有bean注入的话就会报错
		 * 如果加入qualifier的话采用bean的name注入
	    RoleService roleservice = ctx.getBean(RoleService.class);
		roleservice.printRoleInfo1();
		 */
		
		//使用@bean 生产实体类，并且使用了init 和 destroyMethod
		Student student = ctx.getBean(Student.class);
		student.toString();
		
		 
		
		
		
		
		((AbstractApplicationContext) ctx).close();
		
	}

}
