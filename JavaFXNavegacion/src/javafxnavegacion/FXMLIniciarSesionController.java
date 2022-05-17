/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnavegacion;

import DBAccess.NavegacionDAOException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.binding.Bindings;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Navegacion;
import model.User;

/**
 * FXML Controller class
 *
 * @author vsanz
 */
public class FXMLIniciarSesionController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Text tituloiniciarsesion;
    @FXML
    private Label labeluser;
    @FXML
    private Label labelpassword;
    @FXML
    private TextField fielduser;
    @FXML
    private TextField fieldpassword;
    @FXML
    private Button botoniniciar;
    @FXML
    private Button botoncancelar;
    @FXML
    private Button botonrecordar;
    @FXML
    private Text textousuario;

    public Navegacion navegacion;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
          try {
            navegacion = Navegacion.getSingletonNavegacion();
        } catch (NavegacionDAOException ex) {
            Logger.getLogger(FXMLIniciarSesionController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       botoniniciar.disableProperty().bind(Bindings.or(
                Bindings.equal(fielduser.textProperty(), ""),
                Bindings.equal(fieldpassword.textProperty(), "")));

        fielduser.textProperty().addListener((a, b, c) -> {
            textousuario.setText("");
        });
        fieldpassword.textProperty().addListener((a, b, c) -> {
            textousuario.setText("");
        });

        botoniniciar.scaleXProperty().bind(anchor.widthProperty().divide(800));
        botoniniciar.scaleYProperty().bind(anchor.heightProperty().divide(600));

        botoncancelar.scaleXProperty().bind(anchor.widthProperty().divide(800));
        botoncancelar.scaleYProperty().bind(anchor.heightProperty().divide(600));

        botonrecordar.scaleXProperty().bind(anchor.widthProperty().divide(800));
        botonrecordar.scaleYProperty().bind(anchor.heightProperty().divide(600));

        labelpassword.scaleXProperty().bind(anchor.widthProperty().divide(800));
        labelpassword.scaleYProperty().bind(anchor.heightProperty().divide(600));

        labeluser.scaleXProperty().bind(anchor.widthProperty().divide(800));
        labeluser.scaleYProperty().bind(anchor.heightProperty().divide(600));

        tituloiniciarsesion.scaleXProperty().bind(anchor.widthProperty().divide(800));
        tituloiniciarsesion.scaleYProperty().bind(anchor.heightProperty().divide(600));

        fielduser.scaleXProperty().bind(anchor.widthProperty().divide(800));
        fielduser.scaleYProperty().bind(anchor.heightProperty().divide(600));

        fieldpassword.scaleXProperty().bind(anchor.widthProperty().divide(800));
        fieldpassword.scaleYProperty().bind(anchor.heightProperty().divide(600));

        textousuario.scaleXProperty().bind(anchor.widthProperty().divide(800));
        textousuario.scaleYProperty().bind(anchor.heightProperty().divide(600));
    }    

    @FXML
    private void metodoiniciar(ActionEvent event) throws IOException {
                
        String usuario = fielduser.getText();
        String pw = fieldpassword.getText();
        
        
        User u=navegacion.loginUser(usuario, pw);
       
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenuPrincipal.fxml"));
            Parent root = loader.load();
           // FXMLMenuPrincipalController opcionesJugador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();        
             stage.setMinHeight(600);
             stage.setMinWidth(800);
         stage.setMaxWidth(1000);
            stage.setMaxHeight(1200);
            stage.setTitle("Menu Principal");
            stage.setScene(scene);
            stage.show();
        
            Stage mystage = (Stage) botonrecordar.getScene().getWindow();
            mystage.close();
//      
       
    }

    @FXML
    private void metodocancelar(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNavegacion.fxml"));
        Parent root = loader.load();
       FXMLNavegacionController menuPrincipal = loader.getController();
       
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        
        stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setMaxWidth(1000);
        stage.setMaxHeight(1200);
        stage.setTitle("Menu Principal");

        stage.setScene(scene);
        stage.show();
        
        Stage mystage = (Stage) botoniniciar.getScene().getWindow();
        mystage.close();
    }

    @FXML
    private void metodorecordar(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRecordarPassword.fxml"));
        Parent root = loader.load();
        FXMLRecordarPasswordController recordarPW = loader.getController();
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();   
         stage.setMinHeight(600);
        stage.setMinWidth(800);
        stage.setMaxWidth(1000);
        stage.setMaxHeight(1200);
            
        stage.setTitle("Recordar contraseña");
        stage.setScene(scene);
        stage.show();
        
        Stage mystage = (Stage) fieldpassword.getScene().getWindow();
        mystage.close();
        
    }
    
}
