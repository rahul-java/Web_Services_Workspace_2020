package max;
class B extends Thread
{     T t;
	public B(T t) {
		this.t=t;
	}

	public void run()
	{
		t.table(100);
	}
}
class C extends Thread
{    T t;
	public C(T t) {
		this.t=t;
	}

	public void run()
	{
		t.table(10);
	}
}
class D extends Thread
{  T t;
	public D(T t) {
		this.t=t;
	}

	public void run()
	{
		t.table(1);
	}
}
public class AB {
   public static void main(String[] args) {
	    T t = new T();
	    B b=new B(t);
	    C c=new C(t);
	   D d= new D(t);
	   b.start();
	   c.start();
	   d.start();
}
}
