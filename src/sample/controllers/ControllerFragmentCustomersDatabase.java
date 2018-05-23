package sample.controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.adatper_database.SQLiteConnector;
import sample.models.CustomerModel;
import sample.utils.Algorithms;
import sample.utils.DialogWarning;

import java.util.function.Predicate;

public class ControllerFragmentCustomersDatabase {
    ObservableList<CustomerModel> listCustomer;

    private final String TAG = ControllerFragmentCustomersDatabase.class.toString();

    @FXML
    private TableView<CustomerModel> table_customer;

    @FXML
    private TableColumn<CustomerModel, String> id_column;

    @FXML
    private TableColumn<CustomerModel, String> name_column;

    @FXML
    private TableColumn<CustomerModel, String> mail_column;

    @FXML
    private TableColumn<CustomerModel, String> bod_column;

    @FXML
    private TableColumn<CustomerModel, String> doc_column;

    @FXML
    private TableColumn<CustomerModel, String> address_column;

    @FXML
    private TableColumn<CustomerModel, String> type_column;

    private FilteredList<CustomerModel> filterData;

    @FXML
    private JFXTextField tf_search;

    public void initialize() {
        Controller.clone_lbMain.setVisible(true);
        Controller.clone_lbMain.setText("Library Card");
        // table_customer_clone = table_customer; //dieu gi se xay ra? if table(clone) is var static

        Controller.bt_back_clone.setVisible(true); //show button back and image back
        Controller.iv_back_clone.setVisible(true); //show button back and image back


        setupDataForTableView(); //init data
    }

    private void setupDataForTableView() {
        // Định nghĩa cách để lấy dữ liệu cho mỗi ô
        // Lấy giá trị từ các properties của class CustomerModel
        id_column.setCellValueFactory(new PropertyValueFactory<CustomerModel, String>("id_cus"));
        name_column.setCellValueFactory(new PropertyValueFactory<CustomerModel, String>("name_cus"));
        mail_column.setCellValueFactory(new PropertyValueFactory<CustomerModel, String>("mail_cus"));
        bod_column.setCellValueFactory(new PropertyValueFactory<CustomerModel, String>("born_date_cus"));
        doc_column.setCellValueFactory(new PropertyValueFactory<CustomerModel, String>("date_create_cus"));
        address_column.setCellValueFactory(new PropertyValueFactory<CustomerModel, String>("address_cus"));
        type_column.setCellValueFactory(new PropertyValueFactory<CustomerModel, String>("type_cus"));

        this.filterData();

        listCustomer = getListCustomer();
        //fill data vào tableview
        table_customer.setItems(listCustomer);
    }

    private ObservableList<CustomerModel> getListCustomer() {
        return FXCollections.observableArrayList(SQLiteConnector
                .getInstanceSQLiteConnector().getAllCustomer()); //fill list customer vào ObservableList
    }

    private void filterData() {
        filterData = new FilteredList<>(getListCustomer(), model -> false);

        tf_search.textProperty().addListener((observable, oldValue, newValue) -> {
            filterData.setPredicate(model -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                //true  = match
                if (model.getId_cus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (model.getName_cus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (model.getAddress_cus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (model.getBorn_date_cus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                } else if (model.getMail_cus().toLowerCase().contains(lowerCaseFilter)) {
                    return true;
                }

                return false; //filter do not match
            });

            SortedList<CustomerModel> sortedData = new SortedList<>(filterData);
            sortedData.comparatorProperty().bind(table_customer.comparatorProperty());
            table_customer.setItems(sortedData);
        });
    }


    @FXML
    void delete_rowTable(ActionEvent event) {
        //delete item selected
        CustomerModel modelItemSelected = table_customer.getSelectionModel().getSelectedItem();

        if (Algorithms.isBanned(SQLiteConnector.getInstanceSQLiteConnector().getAllBannedList(), modelItemSelected.getId_cus())) {
            DialogWarning.createNewDialog("The user being banned can not be deleted.");
        } else if (Algorithms.isCustomerRentingBook(SQLiteConnector.getInstanceSQLiteConnector().getAllRenterBook(), modelItemSelected.getId_cus())) {
            DialogWarning.createNewDialog("The user being rented book can not be deleted.");
        } else {
            table_customer.getItems().remove(modelItemSelected);
            SQLiteConnector.getInstanceSQLiteConnector().deleteCustomerBindID(modelItemSelected.getId_cus());
            System.out.println(TAG + "- delete_rowTable(): deleted user");
        }
    }
}
