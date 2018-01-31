package chapter10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(PageConfig.class);
		Role role =(Role)ctx.getBean(Role.class);
		RoleService roleservice =(RoleService)ctx.getBean(RoleService.class);
		roleservice.printRoleInfo(role);
		 
		 
		 ((AbstractApplicationContext) ctx).close();
		
	}

}
