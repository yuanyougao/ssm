package chapter14.dao;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import chapter14.pojo.Role;
@Repository
public interface RoleDao {

	public List<Role> getAllRole () ;
	
	public Role getRoleByRole (Role role) ;
	
	public Role getRoleById (int id ,String username) ;
}
