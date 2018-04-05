package sample.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import sample.utils.Util;

public class ControllerLayoutHome {
    private final String TAG = ControllerLayoutHome.class.toString();
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

    public void initialize() {
        Controller.iv_back_clone.setVisible(false); //hide image back
        Controller.bt_back_clone.setVisible(false); //hide button back
        //show button back and image back
        initdata();
    }

    private void initdata() {
        //setup image
        iv_logo1.setImage(Util.getImage("user_library_card.png"));
        iv_logo2.setImage(Util.getImage("books.png"));
        iv_logo3.setImage(Util.getImage("ban.png"));
        iv_sub_logo1.setImage(Util.getImage("view_table.png"));
        iv_sub_logo2.setImage(Util.getImage("view_table.png"));
        iv_sub_logo3.setImage(Util.getImage("view_table.png"));

        //custom event handle :))
        area_click_library_card.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println(TAG + ": area clicked");
                //TODO: chuyen scene sau khi an
                if (Controller.border_clone != null) {
                    Util.loadUI("layout_customers_database.fxml", Controller.border_clone);
                }else{
                    System.out.println(TAG + ": WARNING -> have a null object!");
                }
            }
        });
    }


}
