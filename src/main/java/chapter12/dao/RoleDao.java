package chapter12.dao;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chapter12.entity.Role;
@Repository
public interface RoleDao {

	/**
	 * 查询角色
	 * @return
	 */
	public Role getRoleById(@Param("id") String id);
	
	public int delRoleById(Role role);
}
