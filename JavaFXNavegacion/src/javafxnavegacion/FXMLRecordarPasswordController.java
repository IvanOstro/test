/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnavegacion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vsanz
 */
public class FXMLRecordarPasswordController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Text textcontraseña;
    @FXML
    private Label labeluser;
    @FXML
    private Label labelcorreo;
    @FXML
    private TextField fielduser;
    @FXML
    private TextField fieldcorreo;
    @FXML
    private Button botonconfirmar;
    @FXML
    private Button botoncancelar;
    @FXML
    private Text mensajeusuario;
    @FXML
    private GridPane grid;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        botonconfirmar.disableProperty().bind(Bindings.or(
                Bindings.equal(fielduser.textProperty(), ""),
                Bindings.equal(fieldcorreo.textProperty(), "")));
        
        fielduser.textProperty().addListener((a,b,c) -> {mensajeusuario.setText("");});
        fieldcorreo.textProperty().addListener((a,b,c) -> {mensajeusuario.setText("");});
        
              botoncancelar.scaleXProperty().bind(grid.widthProperty().divide(800));
    botoncancelar.scaleYProperty().bind(grid.heightProperty().divide(600));

     botonconfirmar.scaleXProperty().bind(grid.widthProperty().divide(800));
    botonconfirmar.scaleYProperty().bind(grid.heightProperty().divide(600));

      fielduser.scaleXProperty().bind(grid.widthProperty().divide(800));
    fielduser.scaleYProperty().bind(grid.heightProperty().divide(600));

    fieldcorreo.scaleXProperty().bind(grid.widthProperty().divide(800));
    fieldcorreo.scaleYProperty().bind(grid.heightProperty().divide(600));


     textcontraseña.scaleXProperty().bind(grid.widthProperty().divide(800));
    textcontraseña.scaleYProperty().bind(grid.heightProperty().divide(600));

     labelcorreo.scaleXProperty().bind(grid.widthProperty().divide(800));
    labelcorreo.scaleYProperty().bind(grid.heightProperty().divide(600));

    labeluser.scaleXProperty().bind(grid.widthProperty().divide(800));
    labeluser.scaleYProperty().bind(grid.heightProperty().divide(600)); 
    }    

    @FXML
    private void metodoconfirmar(ActionEvent event) throws IOException {
            String usuario = fielduser.getText();
        String email = fieldcorreo.getText();
        
            
         
          
                
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLGenerarCodigoContraseña.fxml"));
                Parent root = loader.load();
               FXMLGenerarCodigoContraseñaController generarCodigo = loader.getController();
               
               
        
                Scene scene = new Scene(root);
                Stage stage = new Stage();        
                 stage.setMinHeight(600);
                 stage.setMinWidth(900);
                  stage.setMaxWidth(1000);
                stage.setMaxHeight(1200) ;       

                stage.setTitle("Codigo seguridad");
                stage.setScene(scene);
                stage.show();
        
                Stage mystage = (Stage) botoncancelar.getScene().getWindow();
                mystage.close();
                
         
        
    }

    @FXML
    private void metodocancelar(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLIniciarSesion.fxml"));
            Parent root = loader.load();
            FXMLIniciarSesionController iniciarSesion = loader.getController();
       
            Scene scene = new Scene(root);
            Stage stage = new Stage();        
             stage.setMinHeight(600);
            stage.setMinWidth(800);
        stage.setMaxWidth(1000);
        stage.setMaxHeight(1200);
            stage.setTitle("Inicio Sesión");
            stage.setScene(scene);
            stage.show();
        
            Stage mystage = (Stage) botoncancelar.getScene().getWindow();
            mystage.close();
    }
    
}
