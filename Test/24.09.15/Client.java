import java.net.*;
class Client 
{
	public static DatagramSocket ds;
	public static int cport = 8888,sport = 9999;
	public static void main(String[] args) throws Exception 
	{
		ds = new DatagramSocket(cport);
		byte buf[] = new byte[2500];
		DatagramPacket dp = new DatagramPacket(buf,buf.length);
		while(true)
		{
			ds.receive(dp);
			String str = new String(dp.getData(),0,dp.getLength());
			System.out.println(str);
		}
	}
}
