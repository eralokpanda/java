import java.io.*;
import java.net.*;

class TCPServer 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss=null;
		try{
			ss = new ServerSocket(9999);
		}
		catch(IOException e)
		{
		}
		Socket s1 =null;
		try{
			s1 = ss.accept();
		}
		catch(Exception e)
		{
		}
		PrintWriter out = new PrintWriter(s1.getOutputStream(),true);
		
		File f= new File("f.txt");
		if(f.exists())
		{
			BufferedReader d = new BufferedReader(new FileReader("f.txt"));
			String line;
			while((line = d.readLine())!=null)
			{
				out.write(line);
				out.flush();
			}
			d.close();
		}
		out.close();
		s1.close();
		ss.close();


	}
}
