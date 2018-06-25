package thread2;

public class ReadWriteLockDome {

	int number  = 0 ;
	
	public void getnumber () {
		System.out.println(Thread.currentThread().getName()+" number:"+number);
	}
	
	public void setnumber (int number) {
		System.out.println(Thread.currentThread().getName());
		this.number = number;
	}
	public static void main(String[] args) {
		final ReadWriteLockDome read1 = new ReadWriteLockDome();
		for (int i = 1; i <= 100; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					read1.getnumber();
				}
			},"ready"+i).start();
		}
		
		for (int i = 0; i < 1; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					read1.setnumber(101);
				}
			},"write"+i).start();
		}
		
	}
}
