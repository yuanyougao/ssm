package thread2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class A implements Runnable {

	private int ticket = 5;
	ReadWriteLock lock = null;
	
	public A (ReadWriteLock lock) {
		this.lock = lock ;
	}
	@Override
	public void run() {

		while (true) {
				if (read() < 0) {
					System.out.println("没有可用的票了" + ticket);
					break;
				} 
				wri();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	public int read () {
		try {
			this.lock.readLock().lock();
			return this.ticket;
		} finally {
			this.lock.readLock().unlock();
		}
	}
	
	public void  wri () {
		try {
			this.lock.writeLock().lock();
			System.out.println(Thread.currentThread().getName()
					+ "成功卖出的票的序列为:" + ticket);
			this.ticket -- ;
			Thread.sleep(10 * 1000);
		} catch (Exception ex) {
			ex.printStackTrace();
		}finally {
			System.out.println(Thread.currentThread().getName()+"的锁已经释放");
			this.lock.writeLock().unlock();
		}
	}
		
	
	public static void main(String[] args) {

		ReadWriteLock lock = new ReentrantReadWriteLock(false);
		A  a = new A(lock);
		Thread a1 = new Thread(a,"a1");
		Thread a2 = new Thread(a,"a2");
		Thread a3 = new Thread(a,"a3");
		Thread a4 = new Thread(a,"a4");
		a1.start();
		a2.start();
		a3.start();
		a4.start();
		ReadWriteLock lock1 = new ReentrantReadWriteLock();
		
	}

}
