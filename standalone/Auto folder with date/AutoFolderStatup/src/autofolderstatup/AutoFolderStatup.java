/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofolderstatup;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author alok
 */
public class AutoFolderStatup extends Application {
    
    static String msg;
    config.X x;
    boolean err = false;
    @Override
    public void start(Stage stage) throws Exception {
     
        File f = new File("C:/AutoFolder/config.dat");
        if(f.exists()==false)
        {
            err = true;
            msg= "Auto Folder is not Configured !!";
            
        }
        else
        {
     
            try{
        	FileInputStream fis = new FileInputStream("C:/AutoFolder/config.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);		 
		x = (config.X)ois.readObject();		
            }
            catch(IOException e)
            {
                err = true;
                msg = "Something went wrong!! err-IO";
            }

            catch(Exception e)
            {
                err = true;
                msg = "Something went wrong!! err-OT";
            }
            SimpleDateFormat sdf = new SimpleDateFormat(x.type);
            Calendar cal = Calendar.getInstance();
            String date = sdf.format(cal.getTime());
            if(err == false)
            {
                File file = new File(x.path+"/"+date);
                if(file.exists()==false)
                {
                    if(file.mkdir())
                        msg = "Directory successfully created";
                    else
                        msg = "Something went wrong !! err-PE";
                }
                else if(file.exists()==true)
                    msg = "Directory already exists!!";
                else
                    msg = "Something went wrong !! err-MD";
            }
            
        }
        if(err)
        {
    Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Auto Folder");
        stage.getIcons().add(new Image("/icon/logo.png"));
        stage.setResizable(false);
        stage.sizeToScene();
        stage.setScene(scene);
        stage.show();  
        }
        else
            System.exit(0);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
