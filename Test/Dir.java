import java.io.*;
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;
class Dir
{
	public static void main(String[] args) 
	{
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
		Calendar cal = Calendar.getInstance();
		String date = sdf.format(cal.getTime());
		
       
        

		
		File myfile = new File("c:/java/"+date);
		if(myfile.exists()==false)
		{
		if(myfile.mkdir())
			System.out.println("Directory successfully created");
		}
		else
			System.out.println("Directory already exists!!");
		

	}
}
