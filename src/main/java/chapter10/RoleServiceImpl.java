package chapter10;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService {

	@Override
	public void printRoleInfo(Role role) {
		// TODO Auto-generated method stub
		 System.out.println(role.getId());
		 System.out.println(role.getRolename());
		 System.out.println(role.getNote());
	}
}
