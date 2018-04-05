package sample.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.utils.Util;

public class ControllerFormAddLibraryCard {
    private final String TAG = ControllerFormAddLibraryCard.class.toString();

    @FXML
    private ImageView iv_icon_form;

    @FXML
    private JFXButton bt_cancel_add_library_card;

    @FXML
    void setOnClickCancel(ActionEvent event) {
        //close form
        Stage stage = (Stage) bt_cancel_add_library_card.getScene().getWindow();
        stage.close();
    }

    public void initialize() {
        iv_icon_form.setImage(Util.getImage("user_library_card.png"));
        System.out.println(TAG + ": initialize()");
    }
}

