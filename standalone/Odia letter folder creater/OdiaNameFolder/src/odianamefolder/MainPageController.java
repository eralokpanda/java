/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odianamefolder;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 *
 * @author alok
 */
public class MainPageController implements Initializable {
    
    static StringBuilder name = new StringBuilder(255);
    static String msg;
    
    
    //Section 2 Button
    @FXML
    private Button backspace;
    @FXML
    private Button spaceBtn;
    
    
    //Section 3 Button
    @FXML
    private Button btn66;
    @FXML
    private Button btn67;
    @FXML
    private Button btn68;
    @FXML
    private Button btn69;
    @FXML
    private Button btn70;
    @FXML
    private Button btn71;
    @FXML
    private Button btn72;
    @FXML
    private Button btn73;
    @FXML
    private Button btn74;
    @FXML
    private Button btn75;
    @FXML
    private Button btn76;
    @FXML
    private Button btn77;
    @FXML
    private Button btn78;
    @FXML
    private Button btn79;
    
    
    
    //Section 4 button
    @FXML
    private Label label;
    @FXML
    private Button browse;
    @FXML
    private Button create;
    @FXML
    private TextField pathfield;
    @FXML
    private TextField namefield;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button btn10;
    @FXML
    private Button btn11;
    @FXML
    private Button btn12;
    @FXML
    private Button btn13;
    @FXML
    private Button btn14;
    @FXML
    private Button btn15;
    @FXML
    private Button btn16;
    @FXML
    private Button btn17;
    @FXML
    private Button btn18;
    @FXML
    private Button btn19;
    @FXML
    private Button btn20;
    @FXML
    private Button btn21;
    @FXML
    private Button btn22;
    @FXML
    private Button btn23;
    @FXML
    private Button btn24;
    @FXML
    private Button btn25;
    @FXML
    private Button btn26;
    @FXML
    private Button btn27;
    @FXML
    private Button btn28;
    @FXML
    private Button btn29;
    @FXML
    private Button btn30;
    @FXML
    private Button btn31;
    @FXML
    private Button btn32;
    @FXML
    private Button btn33;
    @FXML
    private Button btn34;
    @FXML
    private Button btn35;
    @FXML
    private Button btn36;
    
    
    
    
    
    //section 5 button
    @FXML
    private Button btn37;
    @FXML
    private Button btn38;
    @FXML
    private Button btn39;
    @FXML
    private Button btn40;
    @FXML
    private Button btn41;
    @FXML
    private Button btn42;
    @FXML
    private Button btn43;
    @FXML
    private Button btn44;
    @FXML
    private Button btn45;
    @FXML
    private Button btn46;
    @FXML
    private Button btn47;
    @FXML
    private Button btn48;
    @FXML
    private Button btn49;
    @FXML
    private Button btn50;
    @FXML
    private Button btn51;
    @FXML
    private Button btn52;
    @FXML
    private Button btn53;
    @FXML
    private Button btn54;
    
    
    
    
    
    //Section 6 Button
    @FXML
    private Button btn55;
    @FXML
    private Button btn56;
    @FXML
    private Button btn57;
    @FXML
    private Button btn58;
    @FXML
    private Button btn59;
    @FXML
    private Button btn60;
    @FXML
    private Button btn61;
    @FXML
    private Button btn62;
    @FXML
    private Button btn63;
    @FXML
    private Button btn64;
    @FXML
    private Button btn65;
    
    
    @FXML
    private void Browse(ActionEvent event) {
        Stage stage = new Stage();
       
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Select directory");        
        File path = dc.showDialog(stage);
        pathfield.setText(path.toString());
      
    }
    @FXML
    private void createFolder(ActionEvent e) throws IOException
    {
        if((!pathfield.getText().trim().isEmpty())&&(!namefield.getText().trim().isEmpty()))
        {
            String fname = name.toString().trim();
            File f = new File(pathfield.getText()+"\\"+fname);
            if(f.exists() == false)
            {
                if(fname.length()<100)
                {                
                    if(f.mkdir())
                    {
                        msg = "Successfully created";
                    }
                    else
                    {
                        msg = "Something went wrong!!";
                    }
                }
                else
                {
                    msg = "Maximum 99 character Support!!";
                }
            }
            Parent mainp = FXMLLoader.load(getClass().getResource("/odianamefolder/Popup.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(mainp);            
            stage.getIcons().add(new Image("/icon/logo.png"));
            stage.setResizable(false);
            stage.sizeToScene();
            stage.setScene(scene);
            stage.setTitle("Folder");
            stage.show();
        }
        
    }
    
    
    //Section 2 handler
    
    @FXML
    private void backSpace(ActionEvent e)
    {
        name = name.deleteCharAt(name.length()-1);
        namefield.setText(name.toString());
    }
    
    @FXML
    private void space(ActionEvent e)
    {
        name.append("\u0020"); 
        namefield.setText(name.toString());
    }
    
    //Section 3 handler
    @FXML
    private void writebtn66(ActionEvent e)
    {        
        name.append("\u0B05"); 
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn67(ActionEvent e)
    {        
        name.append("\u0B06");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn68(ActionEvent e)
    {
        name.append("\u0B07");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn69(ActionEvent e)
    {
        name.append("\u0B08");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn70(ActionEvent e)
    {
        name.append("\u0B09");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn71(ActionEvent e)
    {
        name.append("\u0B0A");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn72(ActionEvent e)
    {
        name.append("\u0B0B");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn73(ActionEvent e)
    {
        name.append("\u0B0C");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn74(ActionEvent e)
    {
        name.append("\u0B0F");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn75(ActionEvent e)
    {
        name.append("\u0B10");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn76(ActionEvent e)
    {
        name.append("\u0B13");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn77(ActionEvent e)
    {
        name.append("\u0B14");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn78(ActionEvent e)
    {
        name.append("\u0B60");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn79(ActionEvent e)
    {
        name.append("\u0B61");
        namefield.setText(name.toString());
    }
    
    
    
    
    
    
    //section 4 handler
    
    @FXML
    private void writebtn1(ActionEvent e)
    {
        name.append("\u0B15");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn2(ActionEvent e)
    {
        name.append("\u0B16");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn3(ActionEvent e)
    {
        name.append("\u0B17");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn4(ActionEvent e)
    {
        name.append("\u0B18");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn5(ActionEvent e)
    {
        name.append("\u0B19");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn6(ActionEvent e)
    {
        name.append("\u0B1A");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn7(ActionEvent e)
    {
        name.append("\u0B1B");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn8(ActionEvent e)
    {
        name.append("\u0B1C");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn9(ActionEvent e)
    {
        name.append("\u0B1D");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn10(ActionEvent e)
    {
        name.append("\u0B1E");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn11(ActionEvent e)
    {
        name.append("\u0B1F");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn12(ActionEvent e)
    {
        name.append("\u0B20");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn13(ActionEvent e)
    {
        name.append("\u0B21");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn14(ActionEvent e)
    {
        name.append("\u0B22");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn15(ActionEvent e)
    {
        name.append("\u0B23");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn16(ActionEvent e)
    {
        name.append("\u0B24");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn17(ActionEvent e)
    {
        name.append("\u0B25");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn18(ActionEvent e)
    {
        name.append("\u0B26");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn19(ActionEvent e)
    {
        name.append("\u0B27");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn20(ActionEvent e)
    {
        name.append("\u0B28");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn21(ActionEvent e)
    {
        name.append("\u0B2A");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn22(ActionEvent e)
    {
        name.append("\u0B2B");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn23(ActionEvent e)
    {
        name.append("\u0B2C");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn24(ActionEvent e)
    {
        name.append("\u0B2D");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn25(ActionEvent e)
    {
        name.append("\u0B2E");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn26(ActionEvent e)
    {
        name.append("\u0B2F");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn27(ActionEvent e)
    {
        name.append("\u0B30");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn28(ActionEvent e)
    {
        name.append("\u0B32");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn29(ActionEvent e)
    {
        name.append("\u0B33");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn30(ActionEvent e)
    {
        name.append("\u0B36");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn31(ActionEvent e)
    {
        name.append("\u0B37");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn32(ActionEvent e)
    {
        name.append("\u0B38");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn33(ActionEvent e)
    {
        name.append("\u0B39");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn34(ActionEvent e)
    {
        name.append("\u0B5C");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn35(ActionEvent e)
    {
        name.append("\u0B5D");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn36(ActionEvent e)
    {
        name.append("\u0B5F");
        namefield.setText(name.toString());
    }
    
    
    
    //section 5 handler
    
    @FXML
    private void writebtn37(ActionEvent e)
    {
        name.append("\u0B01");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn38(ActionEvent e)
    {
        name.append("\u0B02");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn39(ActionEvent e)
    {
        name.append("\u0B03");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn40(ActionEvent e)
    {
        name.append("\u0B3C");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn41(ActionEvent e)
    {
        name.append("\u0B3D");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn42(ActionEvent e)
    {
        name.append("\u0B3E");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn43(ActionEvent e)
    {
        name.append("\u0B3F");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn44(ActionEvent e)
    {
        name.append("\u0B40");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn45(ActionEvent e)
    {
        name.append("\u0B41");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn46(ActionEvent e)
    {
        name.append("\u0B42");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn47(ActionEvent e)
    {
        name.append("\u0B43");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn48(ActionEvent e)
    {
        name.append("\u0B47");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn49(ActionEvent e)
    {
        name.append("\u0B48");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn50(ActionEvent e)
    {
        name.append("\u0B4B");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn51(ActionEvent e)
    {
        name.append("\u0B4C");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn52(ActionEvent e)
    {
        name.append("\u0B4D");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn53(ActionEvent e)
    {
        name.append("\u0B56");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn54(ActionEvent e)
    {
        name.append("\u0B57");
        namefield.setText(name.toString());
    }
    
    
    
    
    
    //Section 6 handler
    @FXML
    private void writebtn55(ActionEvent e)
    {
        name.append("\u0B66");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn56(ActionEvent e)
    {
        name.append("\u0B67");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn57(ActionEvent e)
    {
        name.append("\u0B68");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn58(ActionEvent e)
    {
        name.append("\u0B69");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn59(ActionEvent e)
    {
        name.append("\u0B6A");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn60(ActionEvent e)
    {
        name.append("\u0B6B");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn61(ActionEvent e)
    {
        name.append("\u0B6C");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn62(ActionEvent e)
    {
        name.append("\u0B6D");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn63(ActionEvent e)
    {
        name.append("\u0B6E");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn64(ActionEvent e)
    {
        name.append("\u0B6F");
        namefield.setText(name.toString());
    }
    @FXML
    private void writebtn65(ActionEvent e)
    {
        name.append("\u0B70");
        namefield.setText(name.toString());
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //Section 3 Button
        btn66.setText("\u0B05");
        btn67.setText("\u0B06");
        btn68.setText("\u0B07");
        btn69.setText("\u0B08");
        btn70.setText("\u0B09");
        btn71.setText("\u0B0A");
        btn72.setText("\u0B0B");
        btn73.setText("\u0B0C");
        btn74.setText("\u0B0F");
        btn75.setText("\u0B10");
        btn76.setText("\u0B13");
        btn77.setText("\u0B14");
        btn78.setText("\u0B60");
        btn79.setText("\u0B61");
        
        //section 4 Button
        btn1.setText("\u0B15");
        btn2.setText("\u0B16");
        btn3.setText("\u0B17");
        btn4.setText("\u0B18");
        btn5.setText("\u0B19");
        btn6.setText("\u0B1A");
        btn7.setText("\u0B1B");
        btn8.setText("\u0B1C");
        btn9.setText("\u0B1D");
        btn10.setText("\u0B1E");
        btn11.setText("\u0B2F");
        btn12.setText("\u0B20");
        btn13.setText("\u0B21");
        btn14.setText("\u0B22");
        btn15.setText("\u0B23");
        btn16.setText("\u0B24");
        btn17.setText("\u0B25");
        btn18.setText("\u0B26");
        btn19.setText("\u0B27");
        btn20.setText("\u0B28");
        btn21.setText("\u0B2A");
        btn22.setText("\u0B2B");
        btn23.setText("\u0B2C");
        btn24.setText("\u0B2D");
        btn25.setText("\u0B2E");
        btn26.setText("\u0B2F");
        btn27.setText("\u0B30");
        btn28.setText("\u0B32");
        btn29.setText("\u0B33");
        btn30.setText("\u0B36");
        btn31.setText("\u0B37");
        btn32.setText("\u0B38");
        btn33.setText("\u0B39");
        btn34.setText("\u0B5C");
        btn35.setText("\u0B5D");
        btn36.setText("\u0B5F");
        
        
        
        
        //section 5 Button
        btn37.setText("\u0B01");
        btn38.setText("\u0B02");
        btn39.setText("\u0B03");
        btn40.setText("\u0B3C");
        btn41.setText("\u0B3D");
        btn42.setText("\u0B3E");
        btn43.setText("\u0B3F");
        btn44.setText("\u0B40");
        btn45.setText("\u0B41");
        btn46.setText("\u0B42");
        btn47.setText("\u0B43");
        btn48.setText("\u0B47");
        btn49.setText("\u0B48");
        btn50.setText("\u0B4B");
        btn51.setText("\u0B4C");
        btn52.setText("\u0B4D");
        btn53.setText("\u0B56");
        btn54.setText("\u0B57");
        
        
        
        
        //Section 6 Button
        btn55.setText("\u0B66");
        btn56.setText("\u0B67");
        btn57.setText("\u0B68");
        btn58.setText("\u0B69");
        btn59.setText("\u0B6A");
        btn60.setText("\u0B6B");
        btn61.setText("\u0B6C");
        btn62.setText("\u0B6D");
        btn63.setText("\u0B6E");
        btn64.setText("\u0B6F");
        btn65.setText("\u0B70");
        
        
        namefield.setDisable(true);
        
        
    }    
    
}
