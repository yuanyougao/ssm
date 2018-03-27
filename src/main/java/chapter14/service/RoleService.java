package chapter14.service;

import java.util.List;

import org.springframework.stereotype.Component;

import chapter14.pojo.Role;


public interface RoleService {

	public List<Role> getAllRole () ;
	
	public Role getRoleByRole (Role role) ;
	
	public Role getRoleById (int id ,String username) ;
}
