package chapter10;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary //如果有多个子类，加入primary会优先选择
//public class RoleServiceImpl1 implements RoleService {
public class RoleServiceImpl1 {
	public Role getRoleById() {
		// TODO Auto-generated method stub
		return null;
	}
	@Autowired
	private Role role;
	
	public void printRoleInfo(Role role) {
		// TODO Auto-generated method stub
		
	}
	public void printRoleInfo1() {
		System.out.println("RoleServiceImpl1会优先选择我吗");
		 System.out.println(role.getId());
		 System.out.println(role.getRolename());
		 System.out.println(role.getNote());
		
	};
	
}
