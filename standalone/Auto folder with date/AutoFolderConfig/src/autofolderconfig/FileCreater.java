/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofolderconfig;

/**
 *
 * @author alok
 */
import java.io.*;




class FileCreater {
    File Dir;
    String msg;
   
     
    FileCreater(String path,String type)
    {
        Dir = new File("C:/AutoFolder");
         
        if(Dir.exists()==false) 
        {
            if(Dir.mkdir()==false)
            {
                msg = "Something went wrong !!";                
            }
        }
        
        config.X x1 = new config.X();
        x1.path = path;
        if(type.equals("three"))
        x1.type = "MM.dd.yy";
        else if(type.equals("two"))
        x1.type = "dd.MM.yyyy";
        else
        x1.type = "dd.MM.yy";  
        
            try{
            FileOutputStream file = new FileOutputStream("C:/AutoFolder/config.dat");
            ObjectOutputStream oos = new ObjectOutputStream(file);
            oos.writeObject(x1);
            file.close();
            
           msg = "Successfully Configured.";
            }
            catch(Exception e)
            {
              msg = "Something went wrong !!";  
            }
                  
        
    }
}
