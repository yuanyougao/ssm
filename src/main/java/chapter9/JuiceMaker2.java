package chapter9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class JuiceMaker2 implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean{

	private String beverageShop = null;
	private Source source = null;
	
	public void init() {
		System.out.println("["+this.getClass().getSimpleName()+"]执行自定义初始化方法");
	}
	void myDestroy() {
		System.out.println("[" + this.getClass().getSimpleName()+ "]自定义销毁方法");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("【"+this.getClass().getSimpleName()+ "】调用initializingbean接口的afterpropertiesset方法");
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		
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
