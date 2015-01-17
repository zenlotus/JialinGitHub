
public class ConcurrentProgrammingPlayground {


	public static void SimpleTest1() throws InterruptedException{
		Thread myThread = new Thread(){
			public void run(){
				System.out.println("hello from new thread");
			}
		};
		myThread.start();
		//Thread.yield();
		Thread.sleep(1);
		
		System.out.println("hello from main thread");
		myThread.join();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		SimpleTest1();
	}

}
