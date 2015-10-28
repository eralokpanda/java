import java.io.*;
class jsonC 
{
	public static void main(String[] args) 
	{
		  
  
  JSONObject obj=new JSONObject();
  obj.put("path","c:/java/ap");
  obj.put("type","DD:MM:YY");

  System.out.print(obj);
	try {

		FileWriter file = new FileWriter("c:\\test.json");
		file.write(obj.toJSONString());
		file.flush();
		file.close();

	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}
