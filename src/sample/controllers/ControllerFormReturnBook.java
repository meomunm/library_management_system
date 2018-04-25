package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.adatper_database.SQLiteConnector;
import sample.models.RentBookModel;
import sample.utils.Algorithms;
import sample.utils.DialogWarning;
import sample.utils.Util;

import java.util.Optional;

public class ControllerFormReturnBook {

    @FXML
    private ImageView iv_icon_form;

    @FXML
    private JFXButton bt_cancel;

    @FXML
    private JFXButton bt_submit;

    @FXML
    private Label id_libraryCard;

    @FXML
    private Label name_librcard;

    @FXML
    private Label name_book;

    @FXML
    private Label rent_date;

    @FXML
    private JFXTextField tf_idRentBook;

    public void initialize() {
        iv_icon_form.setImage(Util.getImage("return_book.png"));
        showLabel(false);
    }

    @FXML
    void click_cancel(ActionEvent event) {
        closeForm();
    }

    @FXML
    void click_submit(ActionEvent event) {
        showLabel(false);
        if (tf_idRentBook.getText() != null) {
            RentBookModel model = Algorithms.searchRentBook(
                    SQLiteConnector.getInstanceSQLiteConnector().getAllRenterBook(),
                    tf_idRentBook.getText());
            if (model != null) {
                //print data
                name_book.setText("Name of Book: " + model.getNameOfBook());
                rent_date.setText("Rent of Book: " + model.getDateOfRentBook());
                id_libraryCard.setText("ID Library Card: " + model.getIdCustomer());
                name_librcard.setText("Name of Library Card: " + model.getNameOfCustomer());

                showLabel(true);        //todo: show labe

                Alert alert = DialogWarning.createNewDialogCancel("Are you sure?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    //todo: when user click ok, sure return book
                    SQLiteConnector.getInstanceSQLiteConnector().deleteRentBookID(tf_idRentBook.getText());
                    closeForm();
                    Util.loadUI("fragment_rent_books_database.fxml", Controller.border_clone);
                }

            } else {
                //todo: id not match
                DialogWarning.createNewDialog(" Do not match ID Rent Book in database. No such result!");
            }
        } else {
            //todo: textfield is empty
            DialogWarning.createNewDialog("Do not empty of text field!");
        }
    }

    private void closeForm() {
        Stage stage = (Stage) bt_cancel.getScene().getWindow();
        stage.close();
    }

    private void showLabel(boolean s) {
        id_libraryCard.setVisible(s);
        rent_date.setVisible(s);
        name_book.setVisible(s);
        name_librcard.setVisible(s);
    }
}
