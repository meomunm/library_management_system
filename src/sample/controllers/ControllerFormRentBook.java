package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.adatper_database.SQLiteConnector;
import sample.models.BookModel;
import sample.models.CustomerModel;
import sample.utils.Algorithms;
import sample.utils.DialogWarning;
import sample.utils.Util;

import java.util.List;

public class ControllerFormRentBook {
    private static String TAG = ControllerFormRentBook.class.toString();

    @FXML
    private ImageView iv_icon_form;

    @FXML
    private JFXTextField tf_idTransaction;

    @FXML
    private JFXTextField tf_idLibraryCard;

    @FXML
    private JFXButton bt_cancel;

    @FXML
    private JFXButton bt_submit;

    @FXML
    private JFXTextField tf_idBook;

    public void initialize(){
        iv_icon_form.setImage(Util.getImage("rent_book.png"));
    }


    @FXML
    void setOnClickCancel(ActionEvent event) {
        closeCurrentWindow();
    }

    @FXML
    void setOnClickSubmit(ActionEvent event) {
        String idCus = tf_idLibraryCard.getText();
        String idBook = tf_idBook.getText();
        System.out.println(idCus + idBook);
        CustomerModel customerModel = Algorithms.searchCusomerID(SQLiteConnector.getInstanceSQLiteConnector().getAllCustomer(), idCus);
        BookModel bookModel = Algorithms.searchBook(SQLiteConnector.getInstanceSQLiteConnector().getAllBook(), idBook);

        //System.out.println(customerModel.getId_cus()+bookModel.getId_book());
        if (tf_idBook.getText() != null            //kiểm tra dữ liệu đầu vào có để trống hay không
                && tf_idLibraryCard.getText() != null
                && tf_idTransaction.getText() != null){
           if (customerModel != null && bookModel != null){
               if (Algorithms.isBanned(SQLiteConnector.getInstanceSQLiteConnector().getAllBannedList(), tf_idLibraryCard.getText())){

                   DialogWarning.createNewDialog("ID Library Card has banned! Contact Library.");
               }else {
                   try {      //TODO: kiểm tra xem có tồn tại ID library hay không
                       SQLiteConnector.getInstanceSQLiteConnector().insertIntoTableRentBook(
                               tf_idTransaction.getText(),
                               bookModel.getId_book(),
                               customerModel.getId_cus(),
                               bookModel.getName_book(),
                               customerModel.getName_cus(),
                               Util.getDateNow());
                       System.out.println("hop le");  //TODO: khi input điền vào hợp lệ
                       Util.loadUI("fragment_rent_books_database.fxml", Controller.border_clone);  //refresh table database

                       closeCurrentWindow();       //đóng cửa sổ hiện tại
                   } catch (Exception e) {
                       DialogWarning.createNewDialog("write text again.");
                       //TODO: lỗi trong quá trình nhập liệu thì xử lý ở đây?
                       System.out.println(TAG + "BUG -> " + e.getMessage());
                   }
               }

           }else {
               //TODO: ID không hợp lệ
               DialogWarning.createNewDialog("Not found ID Library card  and ID Book in Database.");
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