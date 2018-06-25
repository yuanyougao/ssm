package thread;

public class Person {

	String name ="李四" ;
	String sex ="女";
	
	public void setPerson (String name, String sex,Object lock) {
		synchronized (lock) {
			this.name = name;
			this.sex = sex;
		}
	}
	public void getPerson(Object lock) {
		synchronized (lock) {
			System.out.println("名称为:"+this.name+" 性别为:"+this.sex);
		}
		
	}
}
