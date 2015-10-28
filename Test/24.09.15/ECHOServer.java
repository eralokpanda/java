import java.io.*;
import java.net.*;

class ECHOServer 
{
	public static void main(String[] args) throws Exception
	{
		ServerSocket ss = new ServerSocket(5555);
		BufferedReader br = null;
		String str = null;
		PrintWriter out = null;
	
		int c=0;	
	
		Socket s1 = ss.accept();
		
		 
	
		while(c<5)
		{
			br = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			out = new PrintWriter(s1.getOutputStream(),true);
		
			while((str = br.readLine())!= null)
			{
				out.write(str);
				out.flush();
			}
			
			c++;
		}
		br.close();
		out.close();
		
		s1.close();
		ss.close();


	}
}
