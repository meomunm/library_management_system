package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.adatper_database.SQLiteConnector;
import sample.models.RentBookModel;

public class ControllerFragmentRentBookDatabase {
    @FXML
    private TableView<RentBookModel> table_rent_book;

    @FXML
    private TableColumn<RentBookModel, String> tc_idRentBook;

    @FXML
    private TableColumn<RentBookModel, String> tc_renterName;

    @FXML
    private TableColumn<RentBookModel, String> tc_nameOfBook;

    @FXML
    private TableColumn<RentBookModel, String> tc_dateOfRent;

    public void initialize(){
        Controller.clone_lbMain.setVisible(true);
        Controller.clone_lbMain.setText("List Rent Book");
        Controller.bt_back_clone.setVisible(true); //show button back and image back
        Controller.iv_back_clone.setVisible(true); //show button back and image back
        this.setupTableView();
    }

    private void setupTableView(){
        tc_idRentBook.setCellValueFactory(new PropertyValueFactory<RentBookModel, String>("idRentBook"));
        tc_renterName.setCellValueFactory(new PropertyValueFactory<RentBookModel, String>("nameOfCustomer"));
        tc_nameOfBook.setCellValueFactory(new PropertyValueFactory<RentBookModel, String>("nameOfBook"));
        tc_dateOfRent.setCellValueFactory(new PropertyValueFactory<RentBookModel, String>("dateOfRentBook"));

        table_rent_book.setItems(getListRentBook());
    }

    private ObservableList<RentBookModel> getListRentBook(){
        return FXCollections.observableArrayList(SQLiteConnector.getInstanceSQLiteConnector().getAllRenterBook());
    }
}
