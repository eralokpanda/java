class SubStr 
{
	public static void main(String[] args) 
	{
		String s = "alokkkaal";
		s = s.substring(0,s.length()-1);
		
		System.out.println(s);

		StringBuffer buf = new StringBuffer(5000);
		System.out.println(buf);
		buf.append("hello");
		System.out.println(buf.length()==0);
		System.out.println(buf.capacity());
		System.out.println(buf);
		buf.append("a");
		System.out.println(buf);
		buf = buf.deleteCharAt(buf.length()-1);
		System.out.println(buf);
		String t = "knkjdnkjnknkxnkjxnxkjnxkjfnkjfxnjknjxkfnjknxjgdyftyefytf yetftyftyfyd fiuhuhuimdihguihugurgtuihrijtreojyoijeoijiyf7wt7tw8h9jm9q3e98renywry87wyrm90cwu9eurm9vwut9uwm9tu9uwm9r8qnyr8qy-r8vuq-9,uc9qur9t8n9yt89y8ey8r9whyfwty0wyt89a";
		System.out.println(t.length());

	}
}
