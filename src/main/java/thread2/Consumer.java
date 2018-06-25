package thread2;

class Consumer implements Runnable{
	Person person = null;
	Object lock = null;
	public Consumer(Person person,Object lock) {
		this.person = person;
		this.lock = lock;
	}
	@Override
	public void run() {
		for (int i = 0; true; i++) {
			person.getPerson(lock);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
