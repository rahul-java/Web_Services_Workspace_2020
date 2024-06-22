package max;
class P extends Thread
{  ListTest listTest;
	public P(ListTest listTest) {
		this.listTest=listTest;
	}

	public void run()
	{
		listTest.getData("P");
	}
	
}
class PP extends Thread
{  ListTest listTest;
	public PP(ListTest listTest) {
		this.listTest=listTest;
	}

	public void run()
	{
		listTest.getData("PP");
	}
	
}
class PPP extends Thread
{  ListTest listTest;
	public PPP(ListTest listTest) {
		this.listTest=listTest;
	}

	public void run()
	{
		listTest.getData("PPP");
	}
	
}
public class Z {
public static void main(String[] args) {
	ListTest listTest=new ListTest();
	P p = new P(listTest);
	PP pp = new PP(listTest);
	PPP ppp = new PPP(listTest);
	p.start();
	pp.start();
	ppp.start();
}
}
