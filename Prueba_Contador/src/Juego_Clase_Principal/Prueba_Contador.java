/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML.java to edit this template
 */
package Juego_Clase_Principal;

import Controller_Humor.ControllerVista01;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Yuly Villamil
 */
public class Prueba_Contador extends Application {

     public static void main(String[] args) {
        launch(args);
}
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista_Humor/Vista01.fxml"));
        Parent root = loader.load();

        ControllerVista01 vista1Controller = loader.getController();
        vista1Controller.setPrimaryStage(primaryStage);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HAPPY GAME");
        primaryStage.show();
    }
    

   
    
}
