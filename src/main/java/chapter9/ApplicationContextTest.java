package chapter9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// id 和 name 都可以通过getbean查询到  就算name和id不一样也都是可以找到
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("chapter9/applicationContext.xml");
		
		JuiceMaker2 juicemaker2 = (JuiceMaker2) ctx.getBean("juicemaker2");
		System.err.println(juicemaker2.makeJuice());
		
		/*JuiceMaker2 juicemakerclass =  ctx.getBean(JuiceMaker2.class);
		System.err.println(juicemakerclass.makeJuice());*/
		
		
		
		((AbstractApplicationContext) ctx).close();
		
	}

}
