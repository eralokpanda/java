import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.FileOutputStream;
import java.io.FileReader;
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
	static ArrayList<String> pkgNameArray;

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
			System.out.println ("Success");
		}
	}	
	
	static void Compile (String fName) throws Exception {
		
		boolean pkgFlag = false;
		String path = "classes/";
				
		proc = Runtime.getRuntime ().exec ("javac src/"+fName);
		int i = proc.waitFor ();
		br = new BufferedReader (new InputStreamReader (proc.getErrorStream ()));
		line = "";
		while ((line = br.readLine ()) != null) {
			System.err.println (line);
		}
		
		br = new BufferedReader( new FileReader("src/"+fName));
		line = br.readLine();  //java file read to know the package
		
		if (line != null) { //check file contain data or not
			pkgFlag =  line.contains ("package"); 
			if (pkgFlag) {				//check whether the file contain package or not
				i = line.indexOf (';');
				if (i != (int)-1) {		//To check whether the package statement completed in first line or not	
					line = line.substring (8,i).trim ();
					pkgNameArray.add(line+"."+fName.replace(".java", ""));	
					String arr[] = line.split ("\\."); // divide the entire package name into array
			
						
					for (String b:arr) {			
						File f = new File (path+b);
						f.mkdir ();               //create directory according to package name
						path = path+b+"/";	
					}
				}
			
				String cfile = fName.replace(".java", ".class");
				if(new File("src/"+cfile).exists()) {
					move("src/"+cfile, path+cfile); //move the class file "src" directory to "classes" directory
				}		
			}	
		}
	}

	public void createWebXmlFile () {
		
		Object[] ar = pkgNameArray.toArray();
		for(Object o: ar)
		System.out.println(o.toString());
		
		
	}
	
	public static void main (String[] args) throws Exception {	
		
		String[] list;		
		
		f = new File ("classes");		
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
		
		f = new File ("src");		
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
		
		FilenameFilter javaFilter = new FilenameFilter () {
			public boolean accept (File dir, String name) {				
				if (name.endsWith (".java")) {
					return true;
				} else {
					return false;
				}
			}
		};
		pkgNameArray = new ArrayList<String>();
		list = f.list (javaFilter);	   	
		for (String s : list) {
			Compile (s);		//calling compiler to compile java file one by one	
		}	

		f = new File ("web.xml");		
		if ((!f.exists ()) | (!f.isFile ())) {
			System.err.println("web.xml file does not exist !!");
			createWebXmlFile();
		}		
	}	
}