package chapter5.dao;
import java.util.*;

import org.apache.ibatis.annotations.Param;

import chapter5.pojo.Students;
public interface StudentsDao {

	public void addStu (Students students) ; 
	
	public void delStu (int s_id) ;
	
	public void updateStu (Students students) ;
	
	public List <Students> getAll1 (Students students) ;
	
	public List <Students> getAll2 (@Param("s_no") String s_no ) ;
	
	public List <Students> getAll3 (Map map ) ;
	
	public int countStudents ();

}
