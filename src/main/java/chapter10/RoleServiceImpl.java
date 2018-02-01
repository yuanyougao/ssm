package chapter10;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

	@Bean(name="stduent" , initMethod="init", destroyMethod="myDestroy")
	public Student getStu(){
		Student student = new Student("1", "username");
		return student;
	}
	/**
	 * 如果只加入autowired的话，默认使用类型注入  
	 * required默认false true:如果没有bean注入的话就会报错
	 * 如果加入qualifier的话采用bean的name注入
	 */
	@Autowired(required = false) 
	@Qualifier("role") //
	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public void printRoleInfo(Role role) {
		// TODO Auto-generated method stub
		 System.out.println(role.getId());
		 System.out.println(role.getRolename());
		 System.out.println(role.getNote());
	}
	
	@Override
	public void printRoleInfo1() {
		// TODO Auto-generated method stub
		 System.out.println(role.getId());
		 System.out.println(role.getRolename());
		 System.out.println(role.getNote());
	}
}
