package chapter11;

public class RoleInterceptor  implements Interceptor{

	@Override
	public void before(Object obj) {
		System.out.println("before准备打印角色信息");
	}
	
	@Override
	public void after(Object obj) {
		System.out.println("after已经完成打印角色信息");
	}
	
	@Override
	public void afterReturning(Object obj) {

		System.out.println("afterReturning刚刚打印角色一切正常");
	}
	@Override
	public void afterThrowing(Object obj) {

		System.out.println("afterThrowing刚刚打印角色不正常bug");
	}
}
