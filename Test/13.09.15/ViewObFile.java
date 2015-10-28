import java.io.*;
class ViewObFile 
{
	public static void main(String[] args) throws IOException,ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream("file.ob");
		ObjectInputStream ois = new ObjectInputStream(fis);
		 
		X x = (X)ois.readObject();
		System.out.println(x.s);
	}
}
