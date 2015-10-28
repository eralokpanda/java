import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;

class Compile {	
	
	static boolean flag;
	static BufferedInputStream bis;
	static BufferedReader br;
	static BufferedOutputStream bos;
	static String line;	
	static File f;
	static Process p;
	static String[] listBefore;
	static String[] listAfter;
	static ArrayList<String> newFile;
	
	static void Compile (String fName) throws Exception {
		p = Runtime.getRuntime ().exec ("javac src/"+fName);
		int i = p.waitFor ();
		br = new BufferedReader (new InputStreamReader (p.getErrorStream ()));
		while ((line = br.readLine ()) != null) {
			System.err.println (line);
		}
		
	}
	
	static void getNewFile () {	
		
		int i = 0;
		listAfter = f.list();
		newFile = new ArrayList<String>();
		for (String s : listAfter) {
		
			for (String t : listBefore) {
			
				if ((t.equals(s))) {
				
					newFile.add((String)s);
				}
			}
		} 
		Object[] p = newFile.toArray();
		for(Object s : p) 
		System.out.println(s.toString());
	}
	
	static void move (String fName) throws Exception {
		int i;
		bis = new BufferedInputStream ( new FileInputStream ("src/"+fName));
		bos = new BufferedOutputStream (new FileOutputStream ("classes/"+fName));
		
		while((i = bis.read ()) != -1) {
			bos.write((byte)i);	
		}
		f = new File ("src/"+fName);
		flag = f.delete (); //delete class file from src directory
		if (flag) {
			System.out.println ("Success");
		}
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
		listBefore = f.list();
		list = f.list (javaFilter);	   	
		for (String s : list) {
			Compile (s);		//calling compiler to compile java file one by one	
		}
		getNewFile(); //To know all the new file generated after compilation
		
		FilenameFilter classFilter = new FilenameFilter () {
			public boolean accept (File dir, String name) {				
				if (name.endsWith (".class")) {
					return true;
				} else {
					return false;
				}
			}
		};
		
		list = f.list (classFilter);		
		for (String s : list) {
			move (s);			//calling for move class file "src" directory to "classes" directory
		}		
	}		
}