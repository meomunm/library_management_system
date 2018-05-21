package sample.controllers;


import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;
import sample.utils.DialogWarning;
import sample.utils.Util;

import java.io.IOException;
import java.util.Optional;


public class Controller {
    private final String TAG = Controller.class.toString();

    @FXML
    private ImageView iv_add_lbrary_card;

    @FXML
    private ImageView iv_add_new_book;

    @FXML
    private ImageView iv_rent_book;

    @FXML
    private ImageView iv_return_book;

    @FXML
    private ImageView iv_create_report;

    @FXML
    private ImageView iv_exit;

    @FXML
    private ImageView iv_create_fines_ticket;

    @FXML
    private ImageView iv_back;

    @FXML
    private ImageView iv_search;


    @FXML
    private BorderPane border_pane_layout;

    @FXML
    private JFXButton bt_back_main;

    @FXML
    private Label lb_main;

    public static Label clone_lbMain;

    //clone biến -> passing data another class
    static BorderPane border_clone = null;
    static ImageView iv_back_clone = null;
    static JFXButton bt_back_clone = null;

    //tương tự hàm onCreate trong Android
    public void initialize() {
        lb_main.setVisible(false);
        clone_lbMain = lb_main;
        cloneBorderPane();
        Util.loadUI("fragment_home.fxml", border_pane_layout);

        bt_back_main.setVisible(false); //hide button back
        iv_back.setVisible(false);      //hide image back
        initData();
    }

    //xoá hàm này code ko chạy
    private void cloneBorderPane() {
        //nếu xóa thì code ko chạy, ko biết vì sao nhưng phải tạo 1 biến clone của
        // Border Pane thì mới setScene đc cho nó
        border_clone = border_pane_layout;
        iv_back_clone = iv_back;
        bt_back_clone = bt_back_main;
    }

    //initdata
    private void initData() {
        //setup ảnh cho icon
        iv_create_fines_ticket.setImage(Util.getImage("fines_ticket.png"));
        iv_return_book.setImage(Util.getImage("return_book.png"));
        iv_rent_book.setImage(Util.getImage("rent_book.png"));
        iv_add_new_book.setImage(Util.getImage("add_new_book.png"));
        iv_create_report.setImage(Util.getImage("file-chart.png"));
        iv_add_lbrary_card.setImage(Util.getImage("ic_assignment_white_48dp_1x.png"));
        iv_back.setImage(Util.getImage("chevron-left.png"));
        iv_exit.setImage(Util.getImage("exit-to-app.png"));
        iv_search.setImage(Util.getImage("search.png"));
        System.out.println("done done");
    }

    @FXML
    void clickButtonAddLibraryCard(ActionEvent event) {
        Util.createForm("form_add_library_card.fxml");
    }


    @FXML
    void clickButtonAddNewBook(ActionEvent event) {
        Util.createForm("form_add_book.fxml");
    }

    @FXML
    void clickButtonCreateFinesTicket(ActionEvent event) {
        Util.createForm("form_create_fines_ticket.fxml");
    }

    @FXML
    void clickButtonCreateReport(ActionEvent event) {

    }

    @FXML
    void clickButtonRentBook(ActionEvent event) {
        Util.createForm("form_rent_book.fxml");
    }

    @FXML
    void clickButtonReturnBook(ActionEvent event) {
        Util.createForm("form_return_book.fxml");
    }

    @FXML
        //handle event button -> exit program
    void closeButtonAction(ActionEvent event) {
        Alert alert = DialogWarning.createNewDialogCancel("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            Platform.exit();
        }

    }

    @FXML
    void setOnClickBack(ActionEvent event) {
        Util.loadUI("fragment_home.fxml", border_pane_layout);
    }

    @FXML
    void clickButtonSearch(ActionEvent event) {
        //todo: search
    }
}
