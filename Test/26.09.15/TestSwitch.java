class TestSwitch 
{
	public static void main(String[] args) 
	{
		String s = "btn2";

		switch(s)
		{
			case "btn1":
			{
				System.out.println("stat1");
				break;
			}
			case "btn2":
			{
				System.out.println("stat2");
				break;
			}
			case "btn3":
			{
				System.out.println("stat3");
				break;
			}
			default:
			{
				System.out.println("default");
				break;
			}
		}
	}
}
