package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.adatper_database.SQLiteConnector;
import sample.models.CustomerModel;
import sample.utils.Algorithms;
import sample.utils.DialogWarning;
import sample.utils.Util;

public class ControllerFormCreateFinesTicket {

    @FXML
    private ImageView iv_icon_form;

    @FXML
    private JFXTextField tf_libraryCard;

    @FXML
    private JFXButton bt_cancel;

    @FXML
    private JFXButton bt_submit;

    public void initialize(){

    }

    @FXML
    void click_cancel(ActionEvent event) {
        closeForm();
    }

    @FXML
    void click_submit(ActionEvent event) {
        String id = tf_libraryCard.getText();
        CustomerModel model = Algorithms.searchCusomerID(SQLiteConnector.getInstanceSQLiteConnector().getAllCustomer(), id);
        if (id != null){
            if (model != null){
                SQLiteConnector.getInstanceSQLiteConnector().insertToBannedList(model.getId_cus(), model.getName_cus(), Util.getDateNow());
                DialogWarning.createNewDialog("Successful");
                closeForm();

                Util.loadUI("fragment_banned_list.fxml", Controller.border_clone);
            }else {
                DialogWarning.createNewDialog("ID do not match in database!");
            }

        }else {
            DialogWarning.createNewDialog("ID Library Card is empty value! ");
        }
    }

    private void closeForm() {
        Stage stage = (Stage) bt_cancel.getScene().getWindow();
        stage.close();
    }
}
