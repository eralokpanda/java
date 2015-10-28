public class C implements Cloneable 
{
	int a;
	C clo() throws Exception
	{
		return (C)super.clone();
	}
}