import java.io.*;
class FileRead
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("a.txt");
		int a;
		while((a =fis.read())!= -1)
		{
			System.out.println((char)a);
		}
		 char str='\u2029';
		System.out.println("Hindi : "+str);
		System.err.println("helloooooo");
		 System.out.print("\u0B05");
		
	}
}
