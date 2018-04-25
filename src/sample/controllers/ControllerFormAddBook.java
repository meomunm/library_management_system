package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.adatper_database.SQLiteConnector;
import sample.utils.DialogWarning;
import sample.utils.Util;

import java.util.ArrayList;
import java.util.List;

public class ControllerFormAddBook {
    private final String TAG = ControllerFormAddBook.class.toString();

    @FXML
    private ImageView iv_icon_form;

    @FXML
    private JFXTextField tf_idbook;

    @FXML
    private JFXTextField tf_name;

    @FXML
    private JFXButton bt_cancel_add_book;

    @FXML
    private JFXButton bt_submit;

    @FXML
    private JFXComboBox<String> cb_category;

    @FXML
    private JFXTextField tf_author;

    @FXML
    private JFXTextField tf_cost;

    @FXML
    private JFXTextField tf_total;

    public void initialize() {
        iv_icon_form.setImage(Util.getImage("add_new_book.png"));
        cb_category.setItems(getItemsType());
    }

    private ObservableList<String> getItemsType() {
        List<String> types = new ArrayList<>();
        types.add("Comics & Mangas");
        types.add("Development");
        types.add("History");
        types.add("Personal Finance");
        return FXCollections.observableArrayList(types);
    }

    @FXML
    void setOnClickCancel(ActionEvent event) {
        closeCurrentWindow();
    }

    @FXML
    void setOnClickSubmit(ActionEvent event) {
        //invalidate data input
        if (tf_author.getText() != null            //kiểm tra dữ liệu đầu vào có để trống hay không
                && tf_cost.getText() != null
                && tf_idbook.getText() != null
                && tf_name.getText() != null
                && tf_total.getText() != null
                && cb_category.getValue() != null) {
            try {
                try {
                    SQLiteConnector.getInstanceSQLiteConnector().insertIntoTableBook(
                            tf_idbook.getText(),
                            tf_name.getText(),
                            cb_category.getValue(),
                            Integer.parseInt(tf_cost.getText()),
                            tf_author.getText(),
                            Integer.parseInt(tf_total.getText()),
                            Util.getDateNow()
                    );
                    System.out.println("hop le");  //TODO: khi input điền vào hợp lệ
                    Util.loadUI("fragment_books_database.fxml", Controller.border_clone);  //refresh table database

                    closeCurrentWindow();       //đóng cửa sổ hiện tại
                } catch (Exception e) {
                    DialogWarning.createNewDialog("write text again.");
                    //TODO: lỗi trong quá trình nhập liệu thì xử lý ở đây?
                    System.out.println(TAG + "BUG -> " + e.getMessage());
                }
            } catch (Exception e) {
                DialogWarning.createNewDialog("Textfield Cost and Textfield Total must be number.");
                //TODO: xử lý khi người dùng cố tình nhập text, cost và total phải là số
                System.out.println(TAG + ": Cost and Total is not number -> " + e.getMessage());
            }
        } else {
            //TODO: dữ liệu bị bỏ trống
            DialogWarning.createNewDialog("Does not input data.");
            System.out.println(TAG + ": empty data");
        }
    }

    private void closeCurrentWindow() {
        Stage stage = (Stage) bt_submit.getScene().getWindow();
        stage.close();
    }
}
