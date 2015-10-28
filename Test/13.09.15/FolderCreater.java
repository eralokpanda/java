/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import static java.lang.System.exit;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author alok
 */
public class FolderCreater {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File f = new File("c:/Folder creater/Path.dat");
                if(f.exists() == false)
                {
                    System.out.println("Folder Creater is not Configured");
                    exit(0);
                }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
            
            Path path = (Path)ois.readObject();
        
        
        	SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yy");
		Calendar cal = Calendar.getInstance();
		String date = sdf.format(cal.getTime());
		File myfile = new File(path.path);
		                if(myfile.exists() == false)
                {
                    System.out.println("Path you provided does not exist!!\nPlease configure again!");
                    exit(0);
                }
		 myfile = new File(path.path+"/"+date);
		if(myfile.exists()==false)
		{
		if(myfile.mkdir())
			System.out.println("Directory successfully created");
		}
		else
			System.out.println("Directory already exists!!");
        
    }
    
}
