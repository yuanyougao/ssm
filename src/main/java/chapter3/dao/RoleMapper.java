package chapter3.dao;

import chapter3.pojo.Role;

public interface RoleMapper {

	public Role getRole (long id ) ; 
	
	public void addRole (Role role ) ;
	
	public void delRole (long id ) ;
	
	public void updateRole (Role role ) ; 
	
}
