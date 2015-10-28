
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author alok
 */


class X implements Serializable
{
	String s = "hello";
	int i = 55;
	void m()
	{
		System.out.println(s+" : "+i);
	}
}

public class FileCreate {
	public static void main(String[] args) throws Exception
	{
		X x1 = new X();
		FileOutputStream fis = new FileOutputStream("file.ob");
		ObjectOutputStream oos = new ObjectOutputStream(fis);
		oos.writeObject(x1);
                System.out.println("\u2029");
	}
}


