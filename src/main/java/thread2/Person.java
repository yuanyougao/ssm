package thread2;

public class Person {

	String name = "李四";
	String sex = "女";

	public synchronized void setPerson(String name, String sex) {
		this.name = name;
		this.sex = sex;
		try {
			Thread.sleep(1000 * 20);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void getPerson(Object lock) {
		System.out.println("名称为:" + this.name + " 性别为:" + this.sex);

	}
}
