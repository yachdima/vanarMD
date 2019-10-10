import java.util.Random;

public class ThreadedApp {
	
	// main runs -> single thread
	// 1. new Thread()
	// 2. main() -> inside
	// 3. run()
	public static void main(String[] args) {
		
		new RandomThread().start();
		printRandom("Second");

	}
	
	public static void printRandom(String prefix) {
		Random rand = new Random();
		while(true) {
			System.out.println(prefix + " : " + rand.nextInt(100));
		}
	}

}


class RandomThread extends Thread{

	@Override
	public void run() {
		ThreadedApp.printRandom("First");
	}
	
	
	
}