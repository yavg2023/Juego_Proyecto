/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Matematicas;

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
public class ControllerVista01 {
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
        " Hay 2 padres y 2 hijos, pero solo hay 3 personas ¿Cómo es?.",
        " Tengo mas de 3 lados y menos de 5 lados. Tengo todos mis lados \n" + " iguales. ¿Quien soy?.",
        " Corren más que los minutos pero... nunca llegan los primeros! \n" + " ¿Qué son?.",
        " El reloj de la Puerta del Sol da una campanada cada segundo.\n" +" ¿Cuanto tarda en dar 12 campanadas?."
            
    };

    private String[] respuestas = {
        "3 Hermanos",
        "Cuadrado",
        "Los segundos",
        "11 Segundos"
    };
    
    private String[][] opcionesPregunta = {{
        "4 tios",
        "El abuelo, el padre y el hijo",
        "Mi papa mi tio y mi primo",
        "3 Hermanos"
    },
        {
        "Rectangulo",
        "Circulo",
        "Cuadrado",
        "Octagono"
        },
     {
        "Liebre",
        "Atleta",
        "Los segundos",
        "Un niño haciendo travesuras"
        },
     {
        "3 Noches",
        "27 Dias",
        "Toda la vida",
        "11 Segundos"
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas_Matematicas/Vista_02.fxml"));
            Parent root = loader.load();

            ControllerVista02 vista2Controller = loader.getController();
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
