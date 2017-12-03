package chapter2;

import java.lang.reflect.Method;


public class ReflectServiceImpl {
	//修改
	private String name ; 
	public ReflectServiceImpl (String name) {
		this.name = name ;
	}
	public static ReflectServiceImpl getInstance () {
		ReflectServiceImpl object  = null ;
		try {
			object = (ReflectServiceImpl) Class.forName("ssm.chapter2.reflect.ReflectServiceImpl")
					.newInstance() ; 
		} catch (Exception ex ) {
			ex.printStackTrace();
		}
		
		return object ;
	}
	
	public static ReflectServiceImpl getInstance1 () {
		ReflectServiceImpl object  = null ;
		try {
			object = (ReflectServiceImpl) Class.forName("ssm.chapter2.reflect.ReflectServiceImpl")
					.getConstructor(String.class).newInstance("liuju") ; 
		} catch (Exception ex ) {
			ex.printStackTrace();
		}
		
		return object ;
	}
	public void sayHello (String name) {
		System.err.println("Hello" + name );
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReflectServiceImpl object = ReflectServiceImpl.getInstance1();
		
		try {
			Method method =  ReflectServiceImpl.class.getMethod("sayHello",String.class) ;
			method.invoke(object, "liuliu");
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//   cSystem.out.println(object.name) ; 
		/*ReflectServiceImpl  impl =new ReflectServiceImpl () ;
		impl.sayHello("impl");
		object.sayHello("hello");*/
		
		
	}

}
