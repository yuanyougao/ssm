package chapter10;

public class Student {

	private String user_id;
	private String user_name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student (String user_id, String user_name) {
		this.user_id = user_id;
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void init(){
		System.out.println("我要初始化");
	}
	public void myDestroy(){
		System.out.println("我要销毁");
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		

		System.out.println("用户id:"+this.getUser_id() +"用户名称:"+this.getUser_name());
		return null;
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student student = new Student("1", "username");
		System.out.println(student.toString());
	}

}
