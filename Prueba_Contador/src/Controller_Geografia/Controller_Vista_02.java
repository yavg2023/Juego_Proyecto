/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Geografia;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 *
 * @author Yuly Villamil
 */
public class Controller_Vista_02 {
    
    private Stage primaryStage;
    
    @FXML
    private Button Continuar;

    
  
@FXML
    private void handleVista12_Button() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas_Geografia/Vista_03.fxml"));
            Parent root = loader.load();

            Controller_Vista_03 vista3Controller = loader.getController();
            vista3Controller.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("HAPPY GAME");
       
    }
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    public void setPrimaryStage(Stage primaryStage) {
       this.primaryStage = primaryStage;
    }
}
