package validate;

import java.util.List;

import pensionDAO.Pensioner_DAO;
import readXML.Pensioner_Bean;

public class Validate_List 
{

	

	public static boolean check_List(List<Pensioner_Bean> list) {
		int count=0;
		for(Pensioner_Bean pnr:list)
		{
			if(check_Scheme(pnr.getScheme(), pnr.getDob(), pnr.getGender()))
			{
				if(Pensioner_DAO.insert_Pensioner(pnr))
				{
					count++;
					System.out.println("Inserted Successfully...");
				}
				else
				{
					System.out.println("Error in Insertion...");
				}
				
			}
			else
			{
				System.out.println("Scheme and Age or Gender does not match accordingly..");
			}
		}
		if(count>0)
			return true;
		else
		    return false;
		
	}
	private static boolean check_Scheme(String scheme, String dob, String gender)
	{
		if(scheme.equalsIgnoreCase("old"))
		{
			if(check_Age(dob)>=60)
			{
				return true;
			}
			
		}else if(scheme.equalsIgnoreCase("widow") && gender.equalsIgnoreCase("female"))
		{
			if(check_Age(dob)>=30)
			{
				return true;
			}
			
		}else if(scheme.equalsIgnoreCase("disability"))
		{
			if(check_Age(dob)>=20)
			{
				return true;
			}
		}
		return false;
	}
	private static int check_Age(String dob)
	{
		return Age_Calculator.getAge(dob);
		
	}
}
