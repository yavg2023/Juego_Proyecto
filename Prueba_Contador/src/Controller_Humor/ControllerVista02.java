/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Humor;

import Controller_Matematicas.ControllerVista01;
import Controller_Naturales.Controller_Vista01;
import Controller_Geografia.Controller_Vista_01;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yuly Villamil
 */
public class ControllerVista02 {
    
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    private void handleVista3Button() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista_Humor/Vista03.fxml"));
            Parent root = loader.load();

            ControllerVista03 vista3Controller = loader.getController();
            vista3Controller.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("HAPPY GAME");
       
    }
    
     @FXML
    private void handleVista_01_Button() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas_Naturales/Vista_01.fxml"));
            Parent root = loader.load();

            Controller_Vista01 Controller_Vista01 = loader.getController();
            Controller_Vista01.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("HAPPY GAME");
       
    }
    
     @FXML
    private void handleVista_02_Button() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas_Matematicas/Vista_01.fxml"));
            Parent root = loader.load();

            ControllerVista01 Controller_Vista01 = loader.getController();
            Controller_Vista01.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("HAPPY GAME");
       
    }
    
    
     @FXML
    private void handleVista_03_Button() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas_Geografia/Vista_01.fxml"));
            Parent root = loader.load();

            Controller_Vista_01 Controller_Vista01 = loader.getController();
            Controller_Vista01.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("HAPPY GAME");
       
    }
    
    
    
}
