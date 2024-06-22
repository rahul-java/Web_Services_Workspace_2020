package max;
class Y extends Thread
{
	B b;
	public Y(B b) {
		this.b=b;
	}

	public void run()
	{
		for(int i=0; i<20;i++)
		{
			if(i%2==0)
			{
			b.show(i);
			}
			try {
				Thread.sleep(502);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

class X extends Thread
{    B b;
	public X(B b) {
		this.b=b;
	}

	public void run()
	{
		for(int i=0; i<20;i++)
		{  
			if(i%2!=0)
			{
			b.show(i);
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
public class T {
	public static void main(String[] args) {
		B b=new B();
	X x = new X(b);
	
	x.start();
	x.setPriority(10);
	
	Y y=new Y(b);
	y.start();
	}

}
