/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofolderconfig;


import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author alok
 */
public class MainPageController implements Initializable {
    
    
    
    static String parameter;
    ToggleGroup group;
    static String id = "one";

    @FXML
    private Button browseBtb;
    @FXML
    private TextField txtBox;
    @FXML
    private Button okBtn;
    @FXML
    private RadioButton one;
    @FXML
    private RadioButton two;
    @FXML
    private RadioButton three;
    @FXML
    private Hyperlink website;
    
    @FXML
    private void Submit(ActionEvent e) throws Exception
    {
        if(!txtBox.getText().trim().isEmpty()) 
        {
            parameter = txtBox.getText();
            ((Node)e.getSource()).getScene().getWindow().hide();
            Parent mainp = FXMLLoader.load(getClass().getResource("/autofolderconfig/Popup.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(mainp);
            stage.setScene(scene);
            stage.setTitle("Success"); 
            stage.getIcons().add(new Image("/icon/logo.png"));
            stage.setResizable(false);
            stage.sizeToScene();
            
            stage.show();
        }
        
    }
    
    @FXML
    private void OpenComputer(ActionEvent event)
    {
       Stage stage = new Stage();
       
        DirectoryChooser dc = new DirectoryChooser();
        dc.setTitle("Select directory");        
        File path = dc.showDialog(stage);
        txtBox.setText(path.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        group = new ToggleGroup();
       
        one.setToggleGroup(group);
        one.setSelected(true);
      
        two.setToggleGroup(group);
       
        three.setToggleGroup(group);
       
        
    }    
    @FXML
    private void RadioSelect(ActionEvent event)
    {
        id = ((RadioButton)event.getSource()).getId();

        
    }


    
}
