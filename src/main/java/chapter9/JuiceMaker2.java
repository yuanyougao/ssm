package chapter9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.sun.swing.internal.plaf.basic.resources.basic;

public class JuiceMaker2 implements 
BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, BeanPostProcessor{

	private String beverageShop = null;
	private Source source = null;
	
	public void init() {
		System.out.println("["+this.getClass().getSimpleName()+"]执行自定义初始化方法");
	}
	void myDestroy() {
		System.out.println("[" + this.getClass().getSimpleName()+ "]自定义销毁方法");
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void setBeanName(String name) {
		System.out.println("【"+this.getClass().getSimpleName()+ "】调用BeanNameAware接口的setBeanName方法");
		
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("【"+this.getClass().getSimpleName()+ "】调用BeanFactoryAware接口的setBeanFactory方法");
		
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("【"+this.getClass().getSimpleName()+ "】调用ApplicationContextAware接口的ApplicationContext方法");
		
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【"+this.getClass().getSimpleName()+ "】调用initializingbean接口的afterpropertiesset方法");
	}
	String makeJuice() {
		String juice  = "这是一杯由"+beverageShop+"饮品店, 提供的"+source.getSize()+source.getSugar()+source.getFruit();
		return juice;
	}
	
	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public String getBeverageShop() {
		return beverageShop;
	}

	public void setBeverageShop(String beverageShop) {
		this.beverageShop = beverageShop;
	}

}
