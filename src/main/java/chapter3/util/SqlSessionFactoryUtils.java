package chapter3.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtils {

	private static SqlSessionFactory  sqlsessionfactory = null  ;

	private static final String mbAdd = "mybaits-config.xml" ; 
	public static synchronized SqlSessionFactory getSqlsessionfactory() {
		if (sqlsessionfactory == null ) {
			InputStream inputstream;
			try {
				inputstream = Resources.getResourceAsStream(mbAdd);
				sqlsessionfactory = new SqlSessionFactoryBuilder().build(inputstream) ; 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}  
		return sqlsessionfactory;
	}

	public static void setSqlsessionfactory(SqlSessionFactory sqlsessionfactory) {
		SqlSessionFactoryUtils.sqlsessionfactory = sqlsessionfactory;
	} 
}
