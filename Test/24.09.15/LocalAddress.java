import java.net.*;
class  LocalAddress
{
	public static void main(String[] args) throws UnknownHostException
	{
		InetAddress it = InetAddress.getLocalHost();
		InetAddress is[] = InetAddress.getAllByName("www.facebook.com");
		for(int i=0;i<is.length;i++)
		{
			System.out.println(is[i].getHostAddress());
			System.out.println(is[i].getHostName());
		}
		System.out.println("local machine : "+it);
	}
}
