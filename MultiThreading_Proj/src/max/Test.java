package max;
class A implements Runnable
{
	T t;
	
	public A(T t) {
		this.t=t;
	}

	public void run() {
		
		try {
			t.table("A");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class B implements Runnable
{
	T t;
	
	public B(T t) {
		this.t=t;
	}

	public void run() {
		
		try {
			t.table("B");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
class C implements Runnable
{
	T t;

	
	public C(T t) {
		this.t=t;
	}

	public void run() {
		
		try {
			t.table("C");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
public class Test {
public static void main(String[] args) throws InterruptedException {
   T t=	new T();
     A a = new A(t);
     B b = new B(t);
     C c = new C(t);
   Thread t1 = new Thread(a);
  
 
   Thread t2 = new Thread(b);
   Thread t3 = new Thread(c);
   t1.start();
   t1.join();
   t2.start();
   t2.join();
   t3.start();

}
}
