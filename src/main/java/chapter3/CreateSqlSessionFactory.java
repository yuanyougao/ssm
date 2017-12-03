package chapter3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import chapter3.pojo.Role;

public class CreateSqlSessionFactory {

	
	
	public static void main(String[] args) {
		SqlSessionFactory sqlsessionfactory = null ; 
		String resource ="mybaits-config.xml" ;
		InputStream inputStream ; 
		try {
			inputStream = Resources.getResourceAsStream(resource) ;
			sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		} 
		SqlSession  sqlsession  =sqlsessionfactory.openSession();
		sqlsession.close(); 
		Role role  =new Role ();
		role.setId(2);
		role.setUsername("yuanyougao");
		sqlsession.insert("chapter3.pojo.Role",role);
		
		
		
	}

}
