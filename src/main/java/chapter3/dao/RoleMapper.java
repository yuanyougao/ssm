package chapter3.dao;

import chapter3.pojo.Role;

public interface RoleMapper {

	public Role getRole (long id ) ; 
	
	public int addRole (Role role ) ;
	
	public int delRole (long id ) ;
	
	public int updateRole (Role role ) ; 
	
}
