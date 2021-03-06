/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package autofolderconfig;

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
public class MainPage extends Application {

    @Override
    public void start(Stage stage) throws Exception
    {    
        Parent root = FXMLLoader.load(getClass().getResource("/autofolderconfig/MainPage.fxml"));
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("Auto Folder");
        stage.getIcons().add(new Image("/icon/logo.png"));
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }
    
}
