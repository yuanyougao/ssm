package chapter2;

import java.lang.reflect.Method;


public class CopyOfReflectServiceImpl1 {
	
	 public CopyOfReflectServiceImpl1 () {
		 
	 }
	 
	 public CopyOfReflectServiceImpl1 getInit () {
		 CopyOfReflectServiceImpl1 copyof = null ; 
		 try {
			 copyof =(CopyOfReflectServiceImpl1)Class.forName("ssm.chapter2.reflect.CopyOfReflectServiceImpl1")
					 .newInstance() ; 
		 } catch ( Exception ex ) {
			 ex.printStackTrace(); 
		 }
		 
		 return  copyof ;
	 }
	 public void sayHi (String name ,Integer age ) {
		 System.out.println(" sayHi " + name +" ��ͣ�" + age  );
	 }
	 public static void main(String[] args) {
		 
		 System.out.println("hello");
		 CopyOfReflectServiceImpl1 copyof = null ; 
		 
		 try {
			 copyof =(CopyOfReflectServiceImpl1)Class.forName("ssm.chapter2.CopyOfReflectServiceImpl1")
					 .newInstance() ; 
		 } catch ( Exception ex ) {
			 ex.printStackTrace(); 
		 }
		 try {
			Method  method =copyof.getClass().getMethod("sayHi", String.class,Integer.class) ;
			//method.invoke(copyof, "liuliu" , new Integer("25") );
			
			method.invoke(copyof, "liuliu" ,   Integer.valueOf("25")  );
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		 
		 
	}
}
