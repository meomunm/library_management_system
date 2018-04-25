package sample.controllers;

import com.jfoenix.controls.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.adatper_database.SQLiteConnector;
import sample.utils.Util;

import java.util.ArrayList;
import java.util.List;

public class ControllerFormAddLibraryCard {
    private final String TAG = ControllerFormAddLibraryCard.class.toString();

    @FXML
    private ImageView iv_icon_form;

    @FXML
    private JFXTextField tf_libraryCard;

    @FXML
    private JFXTextField tf_fullName;

    @FXML
    private JFXTextField tf_email;

    @FXML
    private JFXButton bt_cancel_add_library_card;

    @FXML
    private JFXDatePicker dp_date;

    @FXML
    private JFXComboBox<String> cb_typeLibraryCard;

    @FXML
    private JFXTextField tf_address;

    @FXML
    private JFXButton bt_submit;

    @FXML
    void setOnClickCancel(ActionEvent event) {
        //close form
        Stage stage = (Stage) bt_cancel_add_library_card.getScene().getWindow();
        stage.close();
    }

    public void initialize() {
        iv_icon_form.setImage(Util.getImage("user_library_card.png"));
        cb_typeLibraryCard.setItems(getItemsType());
    }

    @FXML
    void setOnClickSubmit(ActionEvent event) {
        //invalidate data input
        if (tf_address.getText() != null            //kiểm tra dữ liệu đầu vào có để trống hay không
                && tf_email.getText() != null
                && tf_fullName.getText() != null
                && tf_libraryCard.getText() != null
                && dp_date.getValue() != null
                && cb_typeLibraryCard.getValue() != null) {
            try {
                int year = dp_date.getValue().getYear();            //tuổi từ 18 -> 55 mới đc phép đăng ký
                if (Util.isValidateEmail(tf_email.getText()) && year <= 2000 && year >= 1963) {
                    SQLiteConnector.getInstanceSQLiteConnector().insertIntoTableCustomer(
                            tf_libraryCard.getText(),
                            tf_fullName.getText(),
                            tf_email.getText(),
                            Util.getDate(dp_date),
                            Util.getDateNow(),
                            tf_address.getText(),
                            cb_typeLibraryCard.getValue()
                    );
                    System.out.println("hop le");  //TODO: khi input điền vào hợp lệ
                    Util.loadUI("fragment_customers_database.fxml", Controller.border_clone);  //refresh table database

                    closeCurrentWindow();       //đóng cửa sổ hiện tại
                } else System.out.println("nam sinh hoac mail khong hop le");       //TODO: năm sinh hoặc mail không hợp lệ
            } catch (Exception e) {
                //TODO: lỗi trong quá trình nhập liệu thì xử lý ở đây?
                System.out.println(TAG + "BUG -> " + e.getMessage());
            }
        } else {
            //TODO: dữ liệu bị bỏ trống
            System.out.println(TAG + ": empty data");
        }
    }

    private ObservableList<String> getItemsType() {
        List<String> types = new ArrayList<>();
        types.add("VIP");
        types.add("Normal");
        return FXCollections.observableArrayList(types);
    }

    private void closeCurrentWindow(){
        Stage stage = (Stage) bt_submit.getScene().getWindow();
        stage.close();
    }
}

