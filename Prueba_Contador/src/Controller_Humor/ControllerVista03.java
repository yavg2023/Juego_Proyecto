/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Humor;


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


 
public class ControllerVista03 {
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
        " ¿Porque vomito la luna?",
        "  Vas en un avion, adelante tuyo esta un caballo y detras un camion;\n" + "donde estas?",
        " ¿Cuál es la única letra que se puede comer?",
        " ¿Qué entierras cuando está vivo y desentierras cuando está muerto?"
            
    };

    private String[] respuestas = {
        "Porque estaba llena",
        "En un carrusel",
        "La G latina",
        "Una planta"
    };
    
    private String[][] opcionesPregunta = {{
        "Porque estaba llena",
        "Porque vio el sol",
        "Porque se fue de rumba",
        "Porque no durmio"
    },
        {
        "En el aeropuerto",
        "En un museo",
        "Durmiendo",
        "En un carrusel"
        },
     {
        "La que sea rica",
        "La G latina",
        "La salsamentaria",
        "Las papas"
        },
     {
        "El tiempo",
        "Una planta",
        "A dracula",
        "Un tesoro"
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista_Humor/Vista05.fxml"));
            Parent root = loader.load();

            ControllerVista05 vista2Controller = loader.getController();
            vista2Controller.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Vista 5");
    }
        
        
        private void perderVidas() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista_Humor/Vista04.fxml"));
            Parent root = loader.load();

            ControllerVista04 vista2Controller = loader.getController();
            vista2Controller.setPrimaryStage(primaryStage);

            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Vista 4");
    }
    

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    } 
    
}


