package max;

public class A extends Thread{

	@Override
	public void run() {
		System.out.println("hiii");
	}
	public static void main(String[] args) {
		A a=new A();
	 // Thread t = new	Thread(a);
		a.start();
		
		a.start();
		
		a.stop();
	}

}
