import java.net.*;
import java.io.*;
class TCPClient 
{
	public static void main(String[] args) throws Exception
	{
		Socket s = null;
		BufferedReader br= null;
		String userinput = null;
		try{
			s = new Socket(InetAddress.getLocalHost(),9999);
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		}
		catch(Exception e)
		{
		}
		while((userinput = br.readLine())!=null)
		{
			System.out.println(userinput);
		}
		br.close();
		s.close();

	}
}
