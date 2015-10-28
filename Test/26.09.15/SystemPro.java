
class SystemPro
{
	public static void main(String args[]) throws Exception
	{
		
		System.out.println(System.getProperty("os.name"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getenv("USERNAME"));
		String a = System.getenv().toString();
		String ss[] = a.split(";");
		
		for(String prop:ss)
		{
		 String aa[]= prop.split(",");
		for(String bb:aa)
		System.out.println(bb);
		}
		
		if(System.getProperty("os.name").toUpperCase().contains("WINDOWS"))
			System.out.println("Windows os Found");

	}
}