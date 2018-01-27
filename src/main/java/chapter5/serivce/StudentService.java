package chapter5.serivce;

import java.util.List;
import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import chapter3.util.SqlSessionFactoryUtils;
import chapter5.dao.StudentsDao;
import chapter5.pojo.Students;

public class StudentService {

	/**
	 * 事物只在写入，修改，删除 需要提交事物
	 * @param students
	 */
	public void addStu(Students students) {
		SqlSessionFactory sqlsessionfactory= 
				SqlSessionFactoryUtils.getSqlsessionfactory();
		SqlSession session  =  null;
		try {
			session  =  sqlsessionfactory.openSession();
			StudentsDao studentsdao= session.getMapper(StudentsDao.class);
			int resultnum = studentsdao.addStu(students);
			System.out.println("已经执行成功受影响的行数为:"+resultnum);
			session.commit();
		} catch(Exception ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		
	}
	
	public void delStu(String s_no) {
		SqlSessionFactory sqlsessionfactory= 
				SqlSessionFactoryUtils.getSqlsessionfactory();
		SqlSession session  =  null;
		try {
			session = sqlsessionfactory.openSession();
			StudentsDao studentsdao = session.getMapper(StudentsDao.class);
			int resultnum = studentsdao.delStu(s_no);
			System.out.println("已经执行受影响的行数为:"+resultnum);
			session.commit();
		} catch (Exception ex) {
			session.rollback();
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	public List<Students> getAll(Students students,String type,String s_no )  { 
		SqlSessionFactory sqlsessionfactory= 
				SqlSessionFactoryUtils.getSqlsessionfactory();
		SqlSession session  =  null;
		List<Students> list = null ;
		try {
			session  =  sqlsessionfactory.openSession();
			StudentsDao studentsdao  = session.getMapper(StudentsDao.class);
			if ("1".equals(type) || "0".equals(type)) {
				list  = studentsdao.getAll1(students);
			} else if ("2".equals(type)) {
				list = studentsdao.getAll2(s_no);
			} else if ("3".equals(type)){
				java.util.Map map =new java.util.HashMap<String , String> () ;
				map.put("s_no", s_no);
				list = studentsdao.getAll3(map);
			} else if ("4".equals(type)) {
				int countstudent = studentsdao.countStudents();
				System.out.println("所有学生为:" + countstudent);
			}
			if (!"4".equals(type)) {
				toPrintln(list);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
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
	
	public String getUUID() {
		   UUID uuid = UUID.randomUUID();
		   return uuid.toString().replace("-", "");
	}
	
	public static void main(String[] args) {
		StudentService service = new StudentService();
		System.out.println(service.getUUID());
	}
	
}
