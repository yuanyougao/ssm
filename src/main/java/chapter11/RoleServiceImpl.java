package chapter11;

public class RoleServiceImpl implements RoleService {

	@Override
	public void printRole(Role role) {
		System.out.println("name:"+role.getRolename());
		System.out.println("note:"+role.getNote());
		System.out.println("id:"+role.getId());
	}
}
