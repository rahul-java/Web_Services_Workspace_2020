package max;

public class T {
	public synchronized void table(int n)
	{
		for(int i=1; i<=10; i++)
		{
			System.out.println(i*n);
		}
	}

}
