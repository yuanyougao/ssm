package thread;

public class A implements Runnable {

	private int ticket = 5;
	private Object lock = new Object();
	@Override
	public void run() {

		while (true) {
			synchronized (lock) {
				if (ticket < 0) {
					System.out.println("没有可用的票了" + ticket);
					break;
				} 
				System.out.println(Thread.currentThread().getName()
						+ "成功卖出的票的序列为:" + ticket);
				ticket--;
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
		
	
	public static void main(String[] args) {

		A  a = new A();
		Thread a1 = new Thread(a,"a1");
		Thread a2 = new Thread(a,"a2");
		Thread a3 = new Thread(a,"a3");
		Thread a4 = new Thread(a,"a4");
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		for (int i = 0 ;true ;i--) {
			//判断线程是否存活
			System.out.println("a1:"+a1.isAlive());
			
			System.out.println(Thread.currentThread().getName());
			System.out.println(Thread.activeCount());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
