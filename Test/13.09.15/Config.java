
import java.util.Scanner;
import java.io.*;
class Path implements Serializable
{
	String path;
	
}


class Config 
{
	public static void main(String[] args) throws Exception
	{
	Scanner sc = new Scanner(System.in);
	System.out.println("Please enter the PATH :");
	String path = sc.next();
	Path p = new Path();
	p.path = path;
		File fs = new File("c:/Folder creater");
	if(fs.exists() == false)
		{
		if(fs.mkdir())
		System.out.println("folder successfully created");
		else
		System.out.println("Write permission require in c drive!!");
		}
	FileOutputStream fos = new FileOutputStream("c:/Folder creater/Path.dat");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(p);

	}
}
