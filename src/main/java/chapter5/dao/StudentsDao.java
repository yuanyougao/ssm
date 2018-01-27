package chapter5.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import chapter5.pojo.Students;
public interface StudentsDao {

	public int addStu (Students students) ; 
	
	public int delStu (@Param("s_no") String s_no) ;
	
	public int updateStu (Students students) ;
	
	public List <Students> getAll1 (Students students) ;
	
	public List <Students> getAll2 (@Param("s_no") String s_no ) ;
	
	public List <Students> getAll3 (Map map ) ;
	
	public int countStudents ();

}
