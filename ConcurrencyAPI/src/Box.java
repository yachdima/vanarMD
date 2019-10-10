import java.util.Random;

public class Box {
	public static Integer value = 0;
	
	public static void main(String[] args) {

		new Incrementer().start();
		new Decrementer().start();
		new Printer().start();

	}

}

class Incrementer extends Thread{
    public void increment(){
    	
    	while(true) {
    		while (Box.value < 3) { 
    	         Box.value++;
    	         try {
    		 			Thread.sleep(2000);
    		 		} catch (InterruptedException e) {
    		 			e.printStackTrace();
    		 		}
    		}
    		
    		
    	} 
    }
    
    @Override
	public void run() {
    	increment();
    	
    }
}

class Decrementer extends Thread{
    public void decrement(){
    	while(true) {
    		while (Box.value > -3) {
    			Box.value--;
        		try {
          			Thread.sleep(3000);
          		} catch (InterruptedException e) {
          			e.printStackTrace();
          		}
    		}
    		Box.value = 3;	
    		
    		
        }
    }
    
    @Override
	public void run() {
    	decrement();
    }
}

class Printer extends Thread{
    public void print(){
    	while(true) {
          if(Box.value >= 0)
        	  System.out.println("Полжительные: " + Box.value );
          		
          else
        	  System.err.println("Отрицательные: " + Box.value);
          
          try {
  				Thread.sleep(1000);
  			} catch (InterruptedException e) {
  			
  				e.printStackTrace();
  			}
    	} 
    }
    
    @Override
	public void run() {
    	print();
    	
    }
}
