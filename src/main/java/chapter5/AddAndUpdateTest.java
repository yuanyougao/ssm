package chapter5;

import chapter5.pojo.Students;
import chapter5.serivce.StudentService;

public class AddAndUpdateTest {

	public static void main(String[] args) {
		StudentService studentservice =new StudentService ();
		//增加
		/*Students students = new Students ();
		students.setS_name("liuju");
		students.setS_no(studentservice.getUUID());
		students.setC_no("531e9941b0224d9b8b7be2b73c615ee3");
		studentservice.addStu(students);*/
		
		//删除
		studentservice.delStu("1a13700383e04df59825c849945ed1ef");
	}
}
