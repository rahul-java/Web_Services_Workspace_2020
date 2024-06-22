package max;

public class T {
	
	public  void table(String n) throws InterruptedException
	{
		for(int i=1; i<=10;i++)
		{
			System.out.print(n);
			Thread.sleep(1000);
		}
	}

}
