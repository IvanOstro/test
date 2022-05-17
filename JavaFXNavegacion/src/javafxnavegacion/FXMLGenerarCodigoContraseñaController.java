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
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vsanz
 */
public class FXMLGenerarCodigoContraseñaController implements Initializable {
    private String codigo;

    @FXML
    private AnchorPane anchor;
    @FXML
    private Text titulo;
    @FXML
    private Label labelintroducircode;
    @FXML
    private TextField fieldcode;
    @FXML
    private Button botongenerarcodigo;
    @FXML
    private Button botonconfirmar;
    @FXML
    private Button botoniniciarsesion;
    @FXML
    private Text mensaje_usuario;
    @FXML
    private Text contraseña_usuario;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botoniniciarsesion.setDisable(true);
                 mensaje_usuario.textProperty().addListener((a,b,c) -> {if(contraseña_usuario.getText().equals("Introduzca un codigo correcto")){
             
                                                                contraseña_usuario.setText("");}});
          botonconfirmar.scaleXProperty().bind(anchor.widthProperty().divide(800));
    botonconfirmar.scaleYProperty().bind(anchor.heightProperty().divide(600));

     botongenerarcodigo.scaleXProperty().bind(anchor.widthProperty().divide(800));
    botongenerarcodigo.scaleYProperty().bind(anchor.heightProperty().divide(600));

      botoniniciarsesion.scaleXProperty().bind(anchor.widthProperty().divide(800));
    botoniniciarsesion.scaleYProperty().bind(anchor.heightProperty().divide(600));

    titulo.scaleXProperty().bind(anchor.widthProperty().divide(800));
    titulo.scaleYProperty().bind(anchor.heightProperty().divide(600));


     labelintroducircode.scaleXProperty().bind(anchor.widthProperty().divide(800));
    labelintroducircode.scaleYProperty().bind(anchor.heightProperty().divide(600));

     contraseña_usuario.scaleXProperty().bind(anchor.widthProperty().divide(800));
    contraseña_usuario.scaleYProperty().bind(anchor.heightProperty().divide(600));

    mensaje_usuario.scaleXProperty().bind(anchor.widthProperty().divide(800));
    mensaje_usuario.scaleYProperty().bind(anchor.heightProperty().divide(600)); 
    }    
    
      public  void aleatorio(){
      
     int aleatorio=(int)(999 + Math.random()*8000);
     codigo =Integer.toString(aleatorio);
        
    }
    

    @FXML
    private void metodogenerarcodigo(ActionEvent event) {
        aleatorio();
        mensaje_usuario.setText("Su codigo de confirmación es: "+ codigo);
    }

    @FXML
    private void metodoconfirmar(ActionEvent event) {
         if(mensaje_usuario.getText().equals(codigo)){
            botoniniciarsesion.setDisable(false);
         
           
            contraseña_usuario.setFill(Color.GREEN);
          contraseña_usuario.setText("Su contraseña es: " );
          //+ p.getPassword());
          
        }else{
            
            contraseña_usuario.setFill(Color.DARKRED);
            contraseña_usuario.setText("Introduzca un codigo correcto");
        
        }
    }

    @FXML
    private void metodoiniciarsesion(ActionEvent event) throws IOException {
          
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLInicioSesion.fxml"));
            Parent root = loader.load();
            FXMLIniciarSesionController iniciarSesion = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setMinHeight(600);
            stage.setMinWidth(800);
             stage.setMaxWidth(1000);
                stage.setMaxHeight(1200) ;   
            stage.setTitle("Inicio Sesión");
            stage.setScene(scene);
            stage.show();

            Stage mystage = (Stage) contraseña_usuario.getScene().getWindow();
            mystage.close();
        
    }
    
}
