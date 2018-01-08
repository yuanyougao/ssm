package chapter5.serivce;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import chapter3.util.SqlSessionFactoryUtils;
import chapter5.dao.StudentsDao;
import chapter5.pojo.Students;

public class StudentService {

	public List<Students> getAll (Students students,String type,String s_no )  { 
		SqlSessionFactory sqlsessionfactory= 
				SqlSessionFactoryUtils.getSqlsessionfactory();
		
		SqlSession session  =  sqlsessionfactory.openSession();
		
		StudentsDao studentsdao  = session.getMapper(StudentsDao.class);
		List<Students> list = null ;
		if ("1".equals(type) || "0".equals(type)) {
			list  = studentsdao.getAll1(students);
		} else if ("2".equals(type)) {
			list = studentsdao.getAll2(s_no);
		} else if ("3".equals(type)){
			java.util.Map map =new java.util.HashMap<String , String > () ;
			map.put("s_no", s_no);
			list = studentsdao.getAll3(map);
		} else if ("4".equals(type)) {
			int countstudent = studentsdao.countStudents();
			System.out.println("所有学生为:" + countstudent);
		}
		if (session != null) {
			session.close();
		}
		if (!"4".equals(type)) {
			toPrintln(list);
		}
		return list ; 
	}
	public void toPrintln (List<Students> list ) {
		if ( list!=null && list.size() > 0 ) {
			for (Students students : list) {
				System.err.println("学员姓名:"+students.getS_name() +
						" 学号:"+students.getS_no() +" 班级编号:"+students.getC_no());
			}
		} else {
			System.out.println("++++无查询到任何学员信息++++");
		}
	}
	
}
