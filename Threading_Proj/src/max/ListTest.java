package max;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
	List<String> l=new ArrayList<String>();
	int f=0;
	public synchronized void getData(String s)
	{
		do
		{
			l.add(s);
			f++;
		}while(f<90000);
		
		System.out.println(f);
		
		
		
		
	}
	
		
	

}
