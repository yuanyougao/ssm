package chapter11;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

	public static void main(String[] args) {
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(PageConfig.class);
		Role role = ctx.getBean(Role.class);
		role.setId(1);
		role.setNote("总监理note");
		role.setRolename("总监理");
		RoleService roleservice = ctx.getBean(RoleService.class);
		try {
			roleservice.printRole(role, 10);
		} catch (Exception e) {
		}
		
 		((AbstractApplicationContext) ctx).close();
		
	}

}
