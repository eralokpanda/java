import java.io.*;
class Cpy 
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream("D:/Application/ChromeStandaloneSetup.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);
		FileOutputStream fos = new FileOutputStream("ChromeStandaloneSetup.exe");
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		int ch;
		while((ch = bis.read())!=-1)
		{
			bos.write((char)ch);
		}
		fos.close();
		fis.close();
	}
}
