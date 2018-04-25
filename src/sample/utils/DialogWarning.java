package sample.utils;

import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.StageStyle;

public class DialogWarning {
    public static void createNewDialog(String message){
        //cảnh báo người dùng khi ko nhập dữ liệu
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initStyle(StageStyle.UTILITY);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.showAndWait();
    }

    public static Alert createNewDialogCancel(String message){
        //cảnh báo người dùng khi ko nhập dữ liệu
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initStyle(StageStyle.UTILITY);
        alert.initModality(Modality.APPLICATION_MODAL);
        //alert.showAndWait();

        return alert;

    }
}
