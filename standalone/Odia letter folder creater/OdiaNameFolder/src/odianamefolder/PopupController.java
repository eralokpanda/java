/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package odianamefolder;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import static odianamefolder.MainPageController.msg;

/**
 * FXML Controller class
 *
 * @author alok
 */
public class PopupController implements Initializable {

    /**
     * Initializes the controller class.
     */
    Stage stage;
    @FXML
    private Label label;
    @FXML
    private void CloseWindow(ActionEvent e)
    {
        ((Node)(e.getSource())).getScene().getWindow().hide();
    }
    
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        label.setText(MainPageController.msg);
        if(MainPageController.msg.equalsIgnoreCase("Successfully created") == false)
        {
            label.setTextFill(Color.RED);
            
        }
    }    
    
}
