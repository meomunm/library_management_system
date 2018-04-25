package sample.controllers;

import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import sample.utils.Util;

public class ControllerLayoutChart {

    @FXML
    private BorderPane border_pane;

    @FXML
    private Label lb_nameChart;

    @FXML
    private JFXToggleButton sw_chartType;

    @FXML
    void click_switch_chartType(ActionEvent event) {

    }

    public void initialize(){
        Controller.clone_lbMain.setVisible(true);
        Controller.clone_lbMain.setText("Chart");
        Controller.bt_back_clone.setVisible(true); //show button back and image back
        Controller.iv_back_clone.setVisible(true); //show button back and image back

        lb_nameChart.setVisible(false);

        Util.loadUI("layout_area_chart.fxml", border_pane);
    }
}
