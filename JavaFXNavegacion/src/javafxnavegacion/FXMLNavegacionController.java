/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnavegacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author vsanz
 */
public class FXMLNavegacionController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane anch;
    @FXML
    private Label titulo;
    @FXML
    private Button iniciosesion;
    @FXML
    private Button registrarse;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         registrarse.scaleXProperty().bind(anch.widthProperty().divide(800));
     registrarse.scaleYProperty().bind(anch.heightProperty().divide(600));

     iniciosesion.scaleXProperty().bind(anch.widthProperty().divide(800));
    iniciosesion.scaleYProperty().bind(anch.heightProperty().divide(600));

      titulo.scaleXProperty().bind(anch.widthProperty().divide(800));
    titulo.scaleYProperty().bind(anch.heightProperty().divide(600));

       
    }    

    @FXML
    private void iniciarsesion(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLIniciarSesion.fxml"));
        Parent root = loader.load();
        FXMLIniciarSesionController iniciarSesion = loader.getController();       
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setMaxWidth(1000);
        stage.setMaxHeight(1200);
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Inicio Sesión");
        stage.setScene(scene);
        stage.show();
        
        

        Stage mystage = (Stage) iniciosesion.getScene().getWindow();
        mystage.close();
    }

    @FXML
    private void metodoregistro(ActionEvent event) throws IOException {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistro.fxml"));
        Parent root = loader.load();
        FXMLRegistroController registro = loader.getController();       
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setMaxWidth(1000);
        stage.setMaxHeight(1200);
        
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Registro");
        stage.setScene(scene);
        stage.show();
        
        

        Stage mystage = (Stage) iniciosesion.getScene().getWindow();
        mystage.close();
    }
        
    }

   