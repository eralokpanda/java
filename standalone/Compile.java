
/*
This is a simple java program. which is use to simplify the compilation process and 
file move from source directory to classes directory in web based application.  
*/


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

import java.util.ArrayList;

class Compile {	
	
	static boolean flag;
	static BufferedInputStream bis;
	static BufferedReader br;
	static BufferedOutputStream bos;
	static String line;	
	static File f;
	static Process proc;
	static ArrayList<String> pkgClassArray;

	static void move (String source, String target) throws Exception {
		int i;
		bis = new BufferedInputStream ( new FileInputStream (source));
		bos = new BufferedOutputStream (new FileOutputStream (target));
		
		while((i = bis.read ()) != -1) {
			bos.write((byte)i);	
		}
		f = new File (source);
		flag = f.delete (); //delete class file from src directory
		if (flag) {
			System.out.println (target+": Success");
		}
	}	
	
	static void Compile (String fName) throws Exception {
		
		boolean pkgFlag = false;
		String path = "WEB-INF/classes/";
				
		proc = Runtime.getRuntime ().exec ("javac WEB-INF/src/"+fName);
		int i = proc.waitFor ();
		br = new BufferedReader (new InputStreamReader (proc.getErrorStream ()));
		line = "";
		while ((line = br.readLine ()) != null) {
			System.err.println (line);
		}
		
		br = new BufferedReader( new FileReader("WEB-INF/src/"+fName));
		line = br.readLine();  //java file read to know the package
		
		if (line != null) { //check file contain data or not
			pkgFlag =  line.contains ("package"); 
			if (pkgFlag) {				//check whether the file contain package or not
				i = line.indexOf (';');
				if (i != (int)-1) {		//To check whether the package statement completed in first line or not	
					line = line.substring (8,i).trim ();
					pkgClassArray.add(line+"."+fName.replace(".java", ""));	
					String arr[] = line.split ("\\."); // divide the entire package name into array
			
						
					for (String b:arr) {			
						File f = new File (path+b);
						f.mkdir ();               //create directory according to package name
						path = path+b+"/";	
					}
				}
			}
			if (!pkgFlag) {
				pkgClassArray.add(fName.replace(".java", ""));//if	
			}
			String cfile = fName.replace(".java", ".class");
			if(new File("WEB-INF/src/"+cfile).exists()) {
				move("WEB-INF/src/"+cfile, path+cfile); //move the class file "src" directory to "classes" directory
			}				
		}
	}

	static void createWebXmlFile () throws Exception {
		
		String className;
		
		BufferedWriter webXmlFile = new BufferedWriter (new FileWriter ("WEB-INF/web.xml")); 
		webXmlFile.write ("<?xml version=\"1.0\" encoding=\"UTF-8\" ?> \n\n\n");	
		webXmlFile.append("<web-app>\n\n");
		
		for(Object o : pkgClassArray.toArray()) {
			className = o.toString().substring ((o.toString().lastIndexOf("."))+1); //get class name to use in servlet name
			webXmlFile.append("\t<servlet>\n");
			webXmlFile.append("\t\t<servlet-name>"+className+"</servlet-name>\n");
			webXmlFile.append("\t\t<servlet-class>"+o.toString()+"</servlet-class>\n");
			webXmlFile.append("\t</servlet>\n\n");		
			webXmlFile.append("\t<servlet-mapping>\n");
			webXmlFile.append("\t\t<servlet-name>"+className+"</servlet-name>\n");
			webXmlFile.append("\t\t<url-pattern>"+""+"</url-pattern>\n");
			webXmlFile.append("\t</servlet-mapping>\n\n");
		}
		webXmlFile.append("\t<welcome-file-list>\n");
		webXmlFile.append("\t\t<welcome-file>index.html</welcome-file>\n");
		webXmlFile.append("\t\t<welcome-file>index.jsp</welcome-file>\n");
		webXmlFile.append("\t\t<welcome-file></welcome-file>\n");
		webXmlFile.append("\t</welcome-file-list>\n\n");
		
		webXmlFile.append("</web-app>\n");
		webXmlFile.close();
		System.out.println("web.xml successfully created");
	}
	
	public static void main (String[] args) throws Exception {	
		
		String[] list;		
			f = new File ("WEB-INF");		
		if ((!f.exists ()) | (!f.isDirectory ())) {
			System.err.println("WEB-INF Directory does not exist !!");
			boolean flag =f.mkdir ();
			if(flag) {
				System.out.println("WEB-INF Directory successfully created.");
			}			
		}	
		if (!f.canWrite ()) {
			System.err.println("\"WEB-INF\" Directory write permission denied !!");
		}
		
		f = new File ("WEB-INF/classes");		
		if ((!f.exists ()) | (!f.isDirectory ())) {
			System.err.println("classes Directory does not exist !!");
			boolean flag =f.mkdir ();
			if(flag) {
				System.out.println("classes Directory successfully created.");
			}			
		}	
		if (!f.canWrite ()) {
			System.err.println("\"classes\" Directory write permission denied !!");
		}
		
		f = new File ("WEB-INF/src");		
		if ((!f.exists ()) | (!f.isDirectory ())) {
			System.err.println("src Directory does not exist !!");
			flag =f.mkdir ();
			if(flag) {
				System.out.println("src Directory successfully created.");
				System.exit(0);
			}				
		}
		if (!f.canRead ()) {
			System.err.println("\"src\" Directory permission denied !!");
		}
		
		/*FilenameFilter javaFilter = new FilenameFilter () {
			public boolean accept (File dir, String name) {				
				if (name.endsWith (".java")) {
					return true;
				} else {
					return false;
				}
			}
		};*/
		
		pkgClassArray = new ArrayList<String>();
		//list = f.list (javaFilter);	
		list = f.list ();
		for (String s : list) {
			if (s.endsWith (".java")) {
				System.out.println(s);
				Compile (s);		//calling compiler to compile java file one by one	
			}
		}	

		f = new File ("WEB-INF/web.xml");		
		if ((!f.exists ()) | (!f.isFile ())) {
			System.err.println("web.xml file does not exist !!");
			createWebXmlFile();
		}		
	}	
}