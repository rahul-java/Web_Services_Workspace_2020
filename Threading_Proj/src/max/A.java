package max;

public class A extends Thread{
    int totl=0;
	public void run()
	{
		synchronized (this) {
			
		
		for(int i=1; i<=20;i++)
		{
			totl+=i;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		notify();
		}
	}
	public static void main(String[] args) throws InterruptedException {
		A ob=new A();
		ob.start();
		synchronized (ob) {
			ob.wait();
		}
		
		
		System.out.println( "Send mail "+  ob.totl);
	}
	
}
