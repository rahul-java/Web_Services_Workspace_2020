package max1;

public class TT extends Thread{
	int totl=0;
	public void run() 
	{
		for(int i=1; i<=20;i++)
		{
			totl+=i;
			System.out.println(totl);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) throws InterruptedException {
		TT tt = new  TT();
		tt.start();
		
		System.out.println("total =  " +tt.totl);
	}

}
