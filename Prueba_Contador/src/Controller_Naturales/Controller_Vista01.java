/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Naturales;

import Controller_Humor.ControllerVista04;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;



/**
 *
 * @author Yuly Villamil
 */
public class Controller_Vista01 {
       @FXML
    private ToggleGroup opciones;

    @FXML
    private Label vidasLabel;

    @FXML
    private Label puntosLabel;
    
    @FXML
    private Label preguntasLabel;
              
    @FXML
    private RadioButton respuestasLabel; 
    
    @FXML
    private RadioButton opcion1; 
    @FXML
    private RadioButton opcion2; 
    @FXML
    private RadioButton opcion3; 
    @FXML
    private RadioButton opcion4; 

    private int vidas = 3;
    private int puntos = 0;
    private int preguntaActual = 0;

    private String[] preguntas = {
        " Nunca me quito la ropa, pero me pongo un disfraz sobre mi vestido \n" + "verde al llegar la Navidad.",
        " Tiene patas y bigotes, para cazar se da mañas, araña y no es araña; \n" + "¿Quien es?.",
        " ¿Soy un animal que camina con las patas en la cabeza?.",
        " No es cama ni es leon, y desaparece en cualquien rincon, ¿Quien \n" + " soy?"
            
    };

    private String[] respuestas = {
        "Arbol de Navidad",
        "Gato",
        "Piojo",
        "Camaleon"
    };
    
    private String[][] opcionesPregunta = {{
        "Arbol de Navidad",
        "Tetera",
        "Licuadora",
        "Papa noel"
    },
        {
        "Canario",
        "Raton",
        "Tigre",
        "Gato"
        },
     {
        "Cien pies",
        "Piojo",
        "Hormiga",
        "Mico"
        },
     {
        "Ballena",
        "Murcielago",
        "Loro",
        "Camaleon"
        }};
    
    
    
    private Stage primaryStage;

    @FXML
    private void initialize() {
        vidasLabel.setText(String.valueOf(vidas));
        puntosLabel.setText(String.valueOf(puntos));
        setPregunta();
    }
    
    

    @FXML
    private void verificarRespuesta(ActionEvent event) throws IOException {
        RadioButton respuestaSeleccionada = (RadioButton) opciones.getSelectedToggle();
        String respuestaCorrecta = respuestas[preguntaActual];
        String respuestaIngresada = respuestaSeleccionada.getText();

        if (respuestaIngresada.equals(respuestaCorrecta)) {
            puntos++;
            puntosLabel.setText(String.valueOf(puntos));
            
            
            if (preguntaActual < respuestas.length - 1) {
            preguntaActual++;
            } else {
              
             ganarJuego();
                
            
            }
            
        } else {
            vidas--;
            vidasLabel.setText(String.valueOf(vidas));
            if (vidas <= 0) {
                perderVidas();
                //terminarJuego();
            }
        }

      

        setPregunta();
        
        // Deseleccionar la respuesta
        respuestaSeleccionada.setSelected(false);
    }
    
    private void setPregunta() {
        preguntasLabel.setText(preguntas[preguntaActual]);
        opcion1.setText(opcionesPregunta[preguntaActual][0]);
        opcion2.setText(opcionesPregunta[preguntaActual][1]);
        opcion3.setText(opcionesPregunta[preguntaActual][2]);
        opcion4.setText(opcionesPregunta[preguntaActual][3]);
        
    }
    

    
        private void ganarJuego() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas_Naturales/Vista_03.fxml"));
            Parent root = loader.load();

            Controller_Vista03 vista2Controller = loader.getController();
            vista2Controller.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("HAPPY GAME");
    }
        
        
        private void perderVidas() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista_Humor/Vista04.fxml"));
            Parent root = loader.load();

            ControllerVista04 vista2Controller = loader.getController();
            vista2Controller.setPrimaryStage(primaryStage);

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
