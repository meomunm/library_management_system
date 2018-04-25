package sample.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.utils.Util;

public class ControllerFragmentHome {
    private final String TAG = ControllerFragmentHome.class.toString();
    @FXML
    private ImageView iv_logo1;

    @FXML
    private ImageView iv_sub_logo1;

    @FXML
    private ImageView iv_logo2;

    @FXML
    private ImageView iv_sub_logo2;

    @FXML
    private ImageView iv_logo3;

    @FXML
    private ImageView iv_sub_logo3;

    @FXML
    private Pane area_click_library_card;

    @FXML
    private Pane area_click_books;

    @FXML
    private Pane area_click_rent_book;

    @FXML
    private ImageView iv_logo_banned;

    @FXML
    private ImageView iv_sublogo_banned;

    @FXML
    private Pane area_click_banned;

    @FXML
    private ImageView iv_logo_chart;

    @FXML
    private ImageView iv_sublogo_chart;

    @FXML
    private Pane area_click_chart;

    public void initialize() {
        Controller.clone_lbMain.setVisible(false);
        Controller.iv_back_clone.setVisible(false); //hide image back
        Controller.bt_back_clone.setVisible(false); //hide button back
        //show button back and image back
        initdata();
        listenner();
    }

    private void initdata() {
        //setup image
        iv_logo1.setImage(Util.getImage("user_library_card.png"));
        iv_logo2.setImage(Util.getImage("books.png"));
        iv_logo3.setImage(Util.getImage("rent_book.png"));
        iv_sub_logo1.setImage(Util.getImage("view_table.png"));
        iv_sub_logo2.setImage(Util.getImage("view_table.png"));
        iv_sub_logo3.setImage(Util.getImage("view_table.png"));
        iv_logo_banned.setImage(Util.getImage("ban.png"));
        iv_sublogo_banned.setImage(Util.getImage("view_table.png"));
        iv_logo_chart.setImage(Util.getImage("chart.png"));
    }

    private void listenner(){
        //custom event handle :))
        area_click_library_card.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO: chuyen scene sau khi an
                if (Controller.border_clone != null) {
                    Util.loadUI("fragment_customers_database.fxml", Controller.border_clone);
                }else{
                    System.out.println(TAG + ": WARNING -> have a null object!");
                }
            }
        });

        area_click_books.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (Controller.border_clone != null){
                    Util.loadUI("fragment_books_database.fxml", Controller.border_clone);
                }else {
                    System.out.println(TAG + ": WARNING -> have a null object!");
                }
            }
        });

        area_click_rent_book.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //TODO: show table rent book
                if (Controller.border_clone != null){
                    Util.loadUI("fragment_rent_books_database.fxml", Controller.border_clone);
                }else {
                    System.out.println(TAG + ": WARNING -> have a null object!");
                }
            }
        });

        area_click_banned.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //todo: show table banned list
                if (Controller.border_clone != null){
                    Util.loadUI("fragment_banned_list.fxml", Controller.border_clone);
                }else {
                    System.out.println(TAG + ": WARNING -> have a null object!");
                }
            }
        });

        area_click_chart.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (Controller.border_clone != null){
                    Util.loadUI("layout_chart.fxml", Controller.border_clone);
                }else {
                    System.out.println(TAG + ": WARNING -> have a null object!");
                }
            }
        });
    }


}
