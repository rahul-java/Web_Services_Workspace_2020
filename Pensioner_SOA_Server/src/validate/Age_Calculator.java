package validate;

import java.time.LocalDate;
import java.time.Period;

public class Age_Calculator {

	public static int getAge(String dob)
	{
		int yy=0,mm=0,dd=0;
		
		yy=getYear(dob);
		mm=getMonth(dob);
		dd=getDay(dob);
		LocalDate today=LocalDate.now();
		LocalDate DOB=LocalDate.of(yy, mm, dd);
		int year=Period.between(DOB, today).getYears();
		int month=Period.between(DOB, today).getMonths() ;
		int day=Period.between(DOB, today).getDays() ;
		
		return year;
	}
	private static int getYear(String dob)
	{
		int year=Integer.parseInt(dob.substring(6, 10));
		//System.out.println(year);
		return year;
		
	}
	private static int getMonth(String dob)
	{
		int month=Integer.parseInt(dob.substring(3, 5));
		//System.out.println(month);
		return month;
		
	}
	private static int getDay(String dob)
	{
		int day=Integer.parseInt(dob.substring(0, 2));
		//System.out.println(day);
		return day;
		
	}
}
