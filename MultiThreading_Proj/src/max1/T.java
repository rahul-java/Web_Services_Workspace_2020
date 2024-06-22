package max1;

public class T {
	
	public  void table(String n) throws InterruptedException
	{
		
		System.out.println("show "+n);
		
		synchronized (this) {
			
		
		for(int i=1; i<=10;i++)
		{
			System.out.println(n);
			Thread.sleep(2000);
		}
		}
	}

}
