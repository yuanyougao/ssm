package chapter10;

import java.sql.SQLException;

public interface RoleDataSourceService {

	public Role getRoleById(int id) throws SQLException;
}
