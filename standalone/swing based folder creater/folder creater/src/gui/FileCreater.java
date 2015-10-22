/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.io.*;


class FileCreater {
    File Dir;
    String msg;
     FileOutputStream file;
    FileCreater(String path)
    {
        Dir = new File("C:/AutoFolder");
         
        if(Dir.exists()==false) 
        {
            if(Dir.mkdir()==false)
            {
                msg = "Something went wrong !!";                
            }
        }
        
       
            try{
           file = new FileOutputStream("C:/AutoFolder/config.dat");
           file.write(path.getBytes());
           file.close();
           msg = "Successfully Configured.";
            }
            catch(Exception e)
            {
              msg = "Something went wrong !!";  
            }
                  
        
    }
}
