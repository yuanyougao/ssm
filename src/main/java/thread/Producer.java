package thread;

public class Producer implements Runnable{
	Person person = null;
	Object lock = null;
	public Producer(Person person,Object lock) {
		this.person = person;
		this.lock = lock;
	}
	@Override
	public void run() {
		for (int i = 0 ;true ; i++) {
			if (i % 2 == 0) {
				try {
					Thread.sleep(0);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				person.setPerson("张三", "男",lock);
			} else {
				try {
					Thread.sleep(00);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				person.setPerson("李四", "女",lock);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Object lock = new Object();
		Person person = new Person();
		Producer p = new Producer(person,lock);
		Thread pt= new Thread(p);
		Consumer c = new Consumer(person,lock);
		Thread ct= new Thread(c);
		pt.start();
		ct.start();
	}
}
