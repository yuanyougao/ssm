package chapter11;

import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role, int sort) throws Exception   {
		if (role != null && role.getId() > 0 ) {
			System.out.println("name:"+role.getRolename());
			System.out.println("note:"+role.getNote());
			System.out.println("id:"+role.getId());
		} else {
			throw new Exception("报错") ;
		}
		
	}
}
