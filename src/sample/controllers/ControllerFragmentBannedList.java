package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.adatper_database.SQLiteConnector;
import sample.models.BannedListModel;

public class ControllerFragmentBannedList {


    @FXML
    private TableView<BannedListModel> tv_banned_list;

    @FXML
    private TableColumn<BannedListModel, String> tc_idRentBook;

    @FXML
    private TableColumn<BannedListModel, String> tc_name_library;

    @FXML
    private TableColumn<BannedListModel, String> tc_date_banned;

    public void initialize(){
        Controller.clone_lbMain.setVisible(true);
        Controller.clone_lbMain.setText("Banned List");
        Controller.bt_back_clone.setVisible(true); //show button back and image back
        Controller.iv_back_clone.setVisible(true); //show button back and image back
        tc_idRentBook.setCellValueFactory(new PropertyValueFactory<BannedListModel, String>("idLibraryCard"));
        tc_name_library.setCellValueFactory(new PropertyValueFactory<BannedListModel, String>("nameOfLibraryCard"));
        tc_date_banned.setCellValueFactory(new PropertyValueFactory<BannedListModel, String>("dateofBannedList"));

        tv_banned_list.setItems(getBannedList());
    }

    private ObservableList<BannedListModel> getBannedList(){
        return FXCollections.observableArrayList(SQLiteConnector.getInstanceSQLiteConnector().getAllBannedList());
    }
}
