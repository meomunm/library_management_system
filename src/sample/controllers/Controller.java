package sample.controllers;


import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;
import sample.utils.Util;

import java.io.IOException;


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
    private BorderPane border_pane_layout;

    @FXML
    private JFXButton bt_back_main;

    //clone biến -> passing data another class
    static BorderPane border_clone = null;
    static ImageView iv_back_clone = null;
    static JFXButton bt_back_clone = null;

    @FXML
        //handle event button -> exit program
    void closeButtonAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void clickButtonAddLibraryCard(ActionEvent event) {
        try {
            //getClass khac Main.getClass -> ly do bi null
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/form_add_library_card.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL); //Khoa window truoc do, ko the tuong tac den khi close window hien tai
            stage.setResizable(false);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.setScene(new Scene(root1));
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void setOnClickBack(ActionEvent event) {
        Util.loadUI("layout_home.fxml", border_pane_layout);
    }


    public void initialize() {
        cloneVar();
        Util.loadUI("layout_home.fxml", border_pane_layout);

        bt_back_main.setVisible(false); //hide button back
        iv_back.setVisible(false);      //hide image back
        initData();
    }

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
        System.out.println("done done");
    }

    private void cloneVar(){
        border_clone = border_pane_layout;
        iv_back_clone = iv_back;
        bt_back_clone = bt_back_main;
    }
}
