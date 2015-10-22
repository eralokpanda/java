/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofoldercreater;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 *
 * @author alok
 */
public class MainPageController implements Initializable {
    
    config.X x;
    boolean err = false;
    
    
    
    @FXML
    private Label label;
    @FXML
    private Button okBtn;

    
    @FXML
    private void CloseWindow(ActionEvent event) {
       System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        File f = new File("C:/AutoFolder/config.dat");
        if(f.exists()==false)
        {
            this.label.setText("Auto Folder is not Configured !!");
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
                this.label.setText("Something went wrong!! err-IO");
                err = true;
            }
            catch(Exception e)
            {
                err = true;
                this.label.setText("Something went wrong!! err-OT");
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
                        this.label.setText("Directory successfully created");
                    else
                        this.label.setText("Something went wrong !! err-PE");
                }
            else if(file.exists()==true)
		this.label.setText("Directory already exists!!");
            else
                this.label.setText("Something went wrong !! err-MD");
            }
        
        } 
    }    
    
}
