import java.util.*;
import java.net.*;
import java.io.*;
class ECHOClient 
{
	public static void main(String[] args) throws Exception
	{
		Socket s = null;
		BufferedReader br = null;
		String str = null;
		String in = null;
		s = new Socket(InetAddress.getLocalHost(),5555);
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		Scanner sc = new Scanner(System.in);
		in = sc.next();

		out.write(in);
		out.flush();
		out.close();

		br = new BufferedReader(new InputStreamReader(s.getInputStream()));
		while((str = br.readLine())!= null)
		{
			System.out.println(str);
		}
		br.close();
		s.close();

	}
}
