package sample;

/*
TODO:       __/\\\\\\\\\\\\\____/\\\________/\\\_____/\\\\\\\\\\\\__________________/\\\\\\\\\__/\\\_____________
TODO:        _\/\\\/////////\\\_\/\\\_______\/\\\___/\\\//////////________________/\\\////////__\/\\\_____________
TODO:         _\/\\\_______\/\\\_\/\\\_______\/\\\__/\\\_________________________/\\\/___________\/\\\_____________
TODO:          _\/\\\\\\\\\\\\\\__\/\\\_______\/\\\_\/\\\____/\\\\\\\____________/\\\_____________\/\\\_____________
TODO:           _\/\\\/////////\\\_\/\\\_______\/\\\_\/\\\___\/////\\\___________\/\\\_____________\/\\\_____________
TODO:            _\/\\\_______\/\\\_\/\\\_______\/\\\_\/\\\_______\/\\\___________\//\\\____________\/\\\_____________
TODO:             _\/\\\_______\/\\\_\//\\\______/\\\__\/\\\_______\/\\\____________\///\\\__________\/\\\_____________
TODO:              _\/\\\\\\\\\\\\\/___\///\\\\\\\\\/___\//\\\\\\\\\\\\/_______________\////\\\\\\\\\_\/\\\\\\\\\\\\\\\_
TODO:               _\/////////////_______\/////////______\////////////____________________\/////////__\///////////////__
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.controllers.Controller;

public class Main extends Application {
    private final String TAG = Main.class.toString();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("views/form_login.fxml"));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Hello World");

        //set scene
       // primaryStage.setScene(new Scene(root, 1106, 589)); //home
        primaryStage.setScene(new Scene(root, 979, 540)); //login
        primaryStage.show();
        System.out.println(TAG + ": start()");
    }

    //chay main truoc, chay cac controller roi den start
    //muon su dung fragment trong javafx thi su dung boder pane -> setCenter
    public static void main(String[] args) {
        System.out.println("in main()");
        launch(args);
    }
}
