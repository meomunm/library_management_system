package sample.utils;

import com.jfoenix.controls.JFXDatePicker;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        if (layout != null) {
            System.out.printf("has setup view (%s)-> in Util methods\n", fileName);
            layout.setCenter(root);
        }
    }

    public static boolean isValidateEmail(String emailStr) {
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
        return matcher.find();
    }

    public static String getDate(JFXDatePicker datePicker) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = datePicker.getValue();
        return dateTimeFormatter.format(localDate);
    }

    public static String getDateNow() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dateTimeFormatter.format(LocalDate.now());
    }

    public static void createForm(String layoutNameFXML) {
        try {
            //getClass khac Main.getClass -> ly do bi null
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/" + layoutNameFXML));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); //Khoa window truoc do, ko the tuong tac den khi close window hien tai
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setResizable(false);
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
