package sample.utils;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import sample.Main;

public class Util {
    public static Image getImage(String path) {
        return new Image("file:res/" + path);
    }

    public static void loadUI(String fileName, BorderPane layout) {
        Parent root = null;
        try {
            root = FXMLLoader.load(Main.class.getResource("views/" + fileName));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (layout != null){
            System.out.printf("has setup view (%s)-> in Util methods\n", fileName);
            layout.setCenter(root);}
    }
}
