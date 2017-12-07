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
		try {
			//Role role =sqlsession.selectOne("chapter3.dao.RoleMapper.getRole", 1L);
			/*RoleMapper  rolemapper=sqlsession.getMapper(RoleMapper.class);
			Role role =rolemapper.getRole(1L);*/
			//System.out.println(role.getUsername()  + role.getId());
			
			/*  *增加 
			Role role =new Role() ; 
			role.setId(4L);
			role.setUsername("hello2l");
			
			RoleMapper  mapper=  sqlsession.getMapper(RoleMapper.class);
			mapper.addRole(role); */
			
			/* 删除 */
			RoleMapper  mapper=  sqlsession.getMapper(RoleMapper.class);
			mapper.delRole(1L);
			
			sqlsession.commit();
		} catch (Exception ex ) { 
			sqlsession.rollback(); 
			ex.printStackTrace();
		} finally {
			if (sqlsession != null ) {
				sqlsession.close(); 
			}
		}
		
		
		
		 
	}

}
