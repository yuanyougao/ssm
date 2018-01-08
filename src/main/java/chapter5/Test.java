package chapter5;

import java.util.List;
import java.util.Scanner;

import chapter5.pojo.Students;
import chapter5.serivce.StudentService;

public class Test {

	
	public static void main(String[] args) {

		StudentService studentservice =new StudentService () ;
		while ( true ) {
			System.err.println("+++++++++++++请输入您选择的操作+++++++++++++++");
			Scanner input = new Scanner(System.in);
			String inputnext = input.next();
			if ("0".equals(inputnext)) {
				studentservice.getAll(null,"0",null);  //没有传入参数  0
				 
			} else if ( "1".equals(inputnext) ){
				Scanner getnameinput = new Scanner(System.in);
				String getnameinext = getnameinput.next();
				Students students =new  Students() ; 
				students.setS_name(getnameinext) ; 
				studentservice.getAll(students,"1",null);//根据entity来传入数据 1
			} else if ( "2".equals(inputnext) ){
				Scanner getsnoinput = new Scanner(System.in);
				String getnameinext = getsnoinput.next();
				Students students =new  Students() ; 
				students.setS_no(getnameinext) ; 
				studentservice.getAll(null,"2",getnameinext);//参数@PARAM
			} else if ( "3".equals(inputnext) ){
				Scanner getsnoinput = new Scanner(System.in);
				String getnameinext = getsnoinput.next();
				studentservice.getAll(null,"3",getnameinext);//参数@Map
			} else if ( "4".equals(inputnext) ){
				studentservice.getAll(null,"4",null);//参数@Map
			}
		}
		
		
	}

}
