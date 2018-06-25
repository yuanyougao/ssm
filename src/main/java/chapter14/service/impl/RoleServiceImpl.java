package chapter14.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chapter14.dao.RoleDao;
import chapter14.pojo.Role;
import chapter14.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleDao roledao ;

	public List<Role> getAllRole () {
		return roledao.getAllRole();
	}
	
	public Role getRoleByRole (Role role) {
		return roledao.getRoleByRole(role);
	}
	
	public Role getRoleById (int id ,String username) {
		return roledao.getRoleById(id ,username);
	}
	
	public RoleDao getRoledao() {
		return roledao;
	}

	public void setRoledao(RoleDao roledao) {
		this.roledao = roledao;
	}
}
