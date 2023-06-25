/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller_Geografia;

import Controller_Humor.ControllerVista04;
import Controller_Humor.ControllerVista07;
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
public class Controller_Vista_03 {

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
        " Soy un país en Gran Bretaña donde puedes beber una buena taza \n" + " de té. Mi capital se llama Londres. Ese es el hogar de la familia real.",
        " Hay uno de estos llamado Pascua con estatuas de caras hechas de \n" + " piedra si estuvieras en un desierto probablemente estés naufragado \n" + " y solo.",
        "Estoy hecho de miles de islas. Y mi punto más alto es el Monte Fuji. \n" + " Soy muy conocido por mi tren bala rápido Haikus, sumo y Hello Kitty.",
        " Gira a 1,000 millas por hora. Aunque no es un paseo en el parque \n" + " de atracciones. En su centro hay un núcleo fundido y tiene una \n" + " costra en su exterior."
            
    };

    private String[] respuestas = {
        "Inglaterra",
        "Islandia",
        "Japon",
        "Planeta Tierra"
    };
    
    private String[][] opcionesPregunta = {{
        "Inglaterra",
        "Noruega",
        "Escocia",
        "Gales"
    },
        {
        "Islandia",
        "Egipto",
        "EEUU",
        "Colombia"
        },
     {
        "España",
        "Japon",
        "Korea del norte",
        "Chile"
        },
     {
        "Marte",
        "Planeta Tierra",
        "El sol",
        "La luna"
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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista_Humor/Vista07.fxml"));
            Parent root = loader.load();

            ControllerVista07 vista2Controller = loader.getController();
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
