package chapter11;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chapter11.aspect.RoleAspect;

@ComponentScan
@EnableAspectJAutoProxy
public class PageConfig {

	@Bean
	public RoleAspect getRoleAspect() {
		return new RoleAspect();
	}
}
