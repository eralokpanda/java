/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofolderconfig;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author alok
 */
public class PopupController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button okBtn;
  
    
    @FXML
    private void CloseWindow(ActionEvent e)
    {
        System.exit(0);
    }

  
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        FileCreater fc = new FileCreater(MainPageController.parameter,MainPageController.id);
        label.setText(fc.msg);
        
        
        
    }    
    
}
