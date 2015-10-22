/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofolderstatup;

import java.net.URL;
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
       label.setText(AutoFolderStatup.msg);
    }    
    
}
