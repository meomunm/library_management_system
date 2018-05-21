package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ControllerFragmentSearch {
    @FXML
    private TableView<?> tb;

    @FXML
    private TableColumn<?, ?> tc1;

    @FXML
    private TableColumn<?, ?> tc2;

    @FXML
    private TableColumn<?, ?> tc3;

    @FXML
    private TableColumn<?, ?> tc4;

    @FXML
    private JFXTextField jfx_textSearch;

    @FXML
    private JFXRadioButton jfx_radioLB;

    @FXML
    private JFXRadioButton jfx_radio_books;

    @FXML
    private JFXButton jfx_button_search;
}
