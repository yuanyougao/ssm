package chapter10;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value="roledatasourceserviceimpl")
public class RoleDataSourceServiceImpl implements RoleDataSourceService{

	@Autowired
	@Qualifier(value="dataSource")
	private DataSource datasource;
	public RoleDataSourceServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public Role getRoleById(int id) throws SQLException{
			PreparedStatement ps = null;
			ResultSet rs = null;
			Connection conn = null;
		try {
		    conn = datasource.getConnection();
			ps = conn.prepareStatement("select * from role where id = ? ");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setRolename(rs.getString("username"));
				role.setId(rs.getInt("id"));
				System.out.println(role.toString());
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
			if (rs != null) {
				rs.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		
		return null;
	}
	
	public DataSource getDatasource() {
		return datasource;
	}
	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}
}
