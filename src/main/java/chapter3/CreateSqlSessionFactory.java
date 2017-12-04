package chapter3;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import chapter3.dao.RoleMapper;
import chapter3.pojo.Role;
import chapter3.util.SqlSessionFactoryUtils;

public class CreateSqlSessionFactory {

	
	
	public static void main(String[] args) {
		SqlSessionFactory sqlsessionfactory = SqlSessionFactoryUtils.getSqlsessionfactory() ; 
		SqlSession  sqlsession  =sqlsessionfactory.openSession();
		Role role =sqlsession.selectOne("chapter3.dao.RoleMapper.getRole", 1L);
		/*RoleMapper  rolemapper=sqlsession.getMapper(RoleMapper.class);
		Role role =rolemapper.getRole(1L);*/
		System.out.println(role.getUsername()  + role.getId());
		
		
	}

}
