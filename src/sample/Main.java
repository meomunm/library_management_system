package sample;

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
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/sample.fxml"));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setTitle("Hello World");

        //set scene
        primaryStage.setScene(new Scene(root, 1106, 589));
        primaryStage.show();
        System.out.println(TAG +": start()");
    }

    //chay main truoc, chay cac controller roi den start
    //muon su dung fragment trong javafx thi su dung boder pane -> setCenter
    public static void main(String[] args) {
        System.out.println("in main()");
        launch(args);
    }
}
