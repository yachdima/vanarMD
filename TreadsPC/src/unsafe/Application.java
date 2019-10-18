package unsafe;

public class Application {

	public static void main(String[] args) {
		BreadProvider provider = new BreadProvider();
		BreadConsumer consumerA = new BreadConsumer("John",provider);
		BreadConsumer consumerB = new BreadConsumer("Marry",provider);
		BreadConsumer consumerC = new BreadConsumer("Peter",provider);
		
		provider.start();
		consumerA.start();
		consumerB.start();
		consumerC.start();
	}

}
