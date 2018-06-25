package chapter11;

public class GmeMain {

	public static void main(String[] args) throws Exception {

		RoleService roleservice = new RoleServiceImpl();
		Interceptor interceptor = new RoleInterceptor();
		RoleService proxy = ProxyBeanFactory.getBean(roleservice, interceptor);
		Role role = new Role();
		  role.setId(1);
		  role.setNote("总经理note");
		  role.setRolename("总经理");
		proxy.printRole(role, 1);
		System.out.println("############测试 afterthorowing#######方法");
		
		
	}

}
