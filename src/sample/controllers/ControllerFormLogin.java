package sample.controllers;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jdk.jshell.Diag;
import sample.Main;
import sample.models.FakeAccount;
import sample.utils.DialogWarning;
import sample.utils.Util;

import java.io.IOException;

public class ControllerFormLogin {

    @FXML
    private JFXTextField tf_username;

    @FXML
    private JFXPasswordField tf_password;

    @FXML
    private Pane pane_forgotPassword;

    @FXML
    private ImageView iv_background;

    @FXML
    private ImageView iv_close;

    @FXML
    void click_signUp(ActionEvent event) {
        DialogWarning.createNewDialog("Cooming soon!");
    }

    @FXML
    void click_signin(ActionEvent event) {
       if (tf_password.getText().equals(FakeAccount.password) && tf_username.getText().equals(FakeAccount.username)){


           try{
               FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/sample.fxml"));
               Parent root = fxmlLoader.load();
               Stage stage = new Stage();
               stage.setResizable(false);
               stage.initModality(Modality.APPLICATION_MODAL);
               stage.initStyle(StageStyle.UNDECORATED);
               stage.setScene(new Scene(root));
               stage.show();

               close_form();
           }catch (Exception e){
               System.out.println(e.getMessage());
           }
       }else DialogWarning.createNewDialog("Wrong account or password");
    }

    private void close_form() {
        Stage stage = (Stage) tf_password.getScene().getWindow();
        stage.close();
    }

    public void initialize() {
        iv_background.setImage(Util.getImage("12.jpg"));
        iv_close.setImage(Util.getImage("window-close _white.png"));
        tf_username.setStyle("-fx-text-inner-color:  #263238;");
        tf_password.setStyle("-fx-text-inner-color:  #263238;");

        iv_close.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                close_form();
            }
        });
        
        //used pane handle event click
        pane_forgotPassword.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                DialogWarning.createNewDialog("Cooming soon!");
            }
        });

    }
}
