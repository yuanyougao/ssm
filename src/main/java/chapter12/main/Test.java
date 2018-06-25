package chapter12.main;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import chapter12.dao.RoleDao;
import chapter12.entity.Role;

public class Test {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-cfg.xml");
		JdbcTemplate  jdbctemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
		String sql  = "select * from role where id = 4 ";
		/*List list  = jdbctemplate.queryForList(sql);
		for (int i = 0; i < list.size(); i++) {
			   Map map = (Map) list.get(i);
			  System.out.println(map.get("id")); 
			  System.out.println(map.get("username")); 
		}*/
		/*Role role = jdbctemplate.queryForObject(sql,(ResultSet rs, int rownum) ->
		{
			Role role = new Role();
			role.setId(rs.getInt("id"));
			role.setRolename(rs.getString("username"));
			System.out.println(rownum);
			return role;
		});*/
		
		/*Role role = jdbctemplate.queryForObject(sql, new RowMapper<Role>(){
			@Override
			public Role mapRow(ResultSet rs, int rownum) throws SQLException {
				Role role = new Role();
				role.setId(rs.getInt("id"));
				role.setRolename(rs.getString("username"));
				System.out.println(rownum);
				return role;
			}
		});
		System.out.println(role.getId() +" " +role.getRolename());*/
		
		RoleDao roledao=(RoleDao) ctx.getBean(RoleDao.class);
		Role role = roledao.getRoleById("3");
		System.out.println(role.getId());
		System.out.println(role.getUsername());
		
		
		//((AbstractApplicationContext) ctx).close();
	}
}
