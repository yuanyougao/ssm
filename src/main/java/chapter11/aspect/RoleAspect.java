package chapter11.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import chapter11.Role;

@Aspect
public class RoleAspect {

	@Pointcut("execution(* chapter11.RoleServiceImpl.printRole(..)) ")
	public void pointcut(){}
	
	@Before("pointcut() && args(role, sort)")
	public void before(Role role , int sort) {
		System.out.println("before" + role.getRolename() + sort );
		System.out.println("before准备打印角色信息");
	}
	
	@After("pointcut()")
	public void after() {
		System.out.println("after已经完成打印角色信息");
	}
	@AfterReturning("pointcut() && args(role, sort)")
	public void afterReturning(Role role , int sort) {
		System.out.println("afterReturning" + role.getRolename() + sort );
		System.out.println("afterReturning刚刚打印角色一切正常");
	}
	@AfterThrowing("pointcut()")
	public void afterThrowing() {

		System.out.println("afterThrowing刚刚打印角色不正常bug");
	}
}
