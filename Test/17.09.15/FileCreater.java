import java.io.*;
class FileCreater 
{
	public static void main(String[] args) throws Exception
	{
	
			String string = "alok";

		FileOutputStream bos = new FileOutputStream("D:/ap.txt");
		
		bos.write(string.getBytes());
	}
}
