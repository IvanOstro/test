/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxnavegacion;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author vsanz
 */
public class FXMLRegistroController implements Initializable {

    @FXML
    private AnchorPane anchor;
    @FXML
    private Text tituloregistro;
    @FXML
    private Label labeluser;
    @FXML
    private Label labelcorreo;
    @FXML
    private Label labelcontraseña;
    @FXML
    private Label labelfecha;
    @FXML
    private Label labelavatar;
    @FXML
    private TextField fielduser;
    @FXML
    private TextField fieldcorreo;
    @FXML
    private TextField fieldcontraseña;
    @FXML
    private DatePicker fieldfecha;
    @FXML
    private ImageView imagenavatar;
    @FXML
    private Button botonavatar;
    @FXML
    private Button botonconfirmar;
    @FXML
    private Button botoncancelar;
    @FXML
    private Text estado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fieldfecha.setDayCellFactory((DatePicker picker) -> {
            return new DateCell() {
                public void updateItem(LocalDate date, boolean empty) {
                    super.updateItem(date, empty);
                    LocalDate today = LocalDate.now();
                    setDisable(empty || date.compareTo(today) > 0);
                }
            };

        });

        
         botonconfirmar.disableProperty().bind(Bindings.or(Bindings.or(Bindings.equal(fielduser.textProperty(), ""), Bindings.equal(fieldcorreo.textProperty(), "")), 
                                                   Bindings.or(Bindings.equal(fieldcontraseña.textProperty(), ""),Bindings.isNull(fieldfecha.valueProperty()))));
       
        fielduser.textProperty().addListener((a,b,c) -> {estado.setText("");});
        fieldcorreo.textProperty().addListener((a,b,c) -> {estado.setText("");});
        fieldcontraseña.textProperty().addListener((a,b,c) -> {estado.setText("");});
        fieldfecha.armedProperty().addListener((a,b,c) -> {estado.setText("");});
        
        
        botonconfirmar.scaleXProperty().bind(anchor.widthProperty().divide(800));
    botonconfirmar.scaleYProperty().bind(anchor.heightProperty().divide(600));

     botonavatar.scaleXProperty().bind(anchor.widthProperty().divide(800));
    botonavatar.scaleYProperty().bind(anchor.heightProperty().divide(600));

      botoncancelar.scaleXProperty().bind(anchor.widthProperty().divide(800));
    botoncancelar.scaleYProperty().bind(anchor.heightProperty().divide(600));

    fielduser.scaleXProperty().bind(anchor.widthProperty().divide(800));
    fielduser.scaleYProperty().bind(anchor.heightProperty().divide(600));

      fieldcorreo.scaleXProperty().bind(anchor.widthProperty().divide(800));
    fieldcorreo.scaleYProperty().bind(anchor.heightProperty().divide(600));

      fieldcontraseña.scaleXProperty().bind(anchor.widthProperty().divide(800));
    fieldcontraseña.scaleYProperty().bind(anchor.heightProperty().divide(600));

     imagenavatar.scaleXProperty().bind(anchor.widthProperty().divide(800));
    imagenavatar.scaleYProperty().bind(anchor.heightProperty().divide(600));

     fieldfecha.scaleXProperty().bind(anchor.widthProperty().divide(800));
    fieldfecha.scaleYProperty().bind(anchor.heightProperty().divide(600));

    tituloregistro.scaleXProperty().bind(anchor.widthProperty().divide(800));
    tituloregistro.scaleYProperty().bind(anchor.heightProperty().divide(600)); 
    
      labelavatar.scaleXProperty().bind(anchor.widthProperty().divide(800));
    labelavatar.scaleYProperty().bind(anchor.heightProperty().divide(600));

      labelcontraseña.scaleXProperty().bind(anchor.widthProperty().divide(800));
    labelcontraseña.scaleYProperty().bind(anchor.heightProperty().divide(600));

     labelcorreo.scaleXProperty().bind(anchor.widthProperty().divide(800));
    labelcorreo.scaleYProperty().bind(anchor.heightProperty().divide(600));

     labelfecha.scaleXProperty().bind(anchor.widthProperty().divide(800));
    labelfecha.scaleYProperty().bind(anchor.heightProperty().divide(600));

    labeluser.scaleXProperty().bind(anchor.widthProperty().divide(800));
    labeluser.scaleYProperty().bind(anchor.heightProperty().divide(600)); 
    
      estado.scaleXProperty().bind(anchor.widthProperty().divide(800));
    estado.scaleYProperty().bind(anchor.heightProperty().divide(600));
        
        
        
    }    

    @FXML
    private void seleccionaavatar(ActionEvent event) {
          FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Elegir avatar");
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg"));
        File imgFile = fileChooser.showOpenDialog(((Node)event.getSource()).getScene().getWindow());
        
        if (imgFile != null){
            Image imag = new Image("file:" + imgFile.getAbsolutePath());
            imagenavatar.setImage(imag);
        }
    }

    @FXML
    private void metodoconfirmar(ActionEvent event) throws IOException {
             
        String user = fielduser.getText();
        boolean checkUser = true;
        String correoEmail =fieldcorreo.getText();
        boolean checkCorreo = true;
        String contraseña = fieldcontraseña.getText();
        boolean checkContraseña = true;
        LocalDate nacimiento = fieldfecha.getValue();
        boolean checkNacimiento = true;
        
       

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMenuPrincipal.fxml"));
            Parent root = loader.load();
          //  FXMLMenuPrincipalController menuOpciones = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setMinHeight(600);
            stage.setMinWidth(800);
stage.setMaxWidth(1000);
            stage.setMaxHeight(1200);
            stage.setTitle("Menu Principal");
            stage.setScene(scene);
            stage.show();

            Stage mystage = (Stage) fielduser.getScene().getWindow();
            mystage.close();

        
    }

    @FXML
    private void metodocancelar(ActionEvent event) throws IOException {
             Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Diálogo de confirmación");
//alert.setHeaderText("Cabecera");
alert.setContentText("¿Seguro que quieres salir?");
Optional<ButtonType> result = alert.showAndWait();
if (result.isPresent() && result.get() == ButtonType.OK){
     FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLNavegacion.fxml"));
        Parent root = loader.load();
        FXMLNavegacionController menuInicial = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setMinHeight(600);
        stage.setMinWidth(800);
stage.setMaxWidth(1000);
            stage.setMaxHeight(1200);
        stage.setTitle("Connect4");
        stage.setScene(scene);
        stage.show();

        Stage mystage = (Stage) botonavatar.getScene().getWindow();
        mystage.close();
    
System.out.println("OK");
} else {
System.out.println("CANCEL");
}
        
       
        
    }
    
}
