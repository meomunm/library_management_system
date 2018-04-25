package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.adatper_database.SQLiteConnector;
import sample.models.CustomerModel;

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

        //fill data vào tableview
        //ObservableList<CustomerModel>
        listCustomer = getListCustomer();
        table_customer.setItems(listCustomer);
    }

    private ObservableList<CustomerModel> getListCustomer() {
        return FXCollections.observableArrayList(SQLiteConnector
                .getInstanceSQLiteConnector().getAllCustomer()); //fill list customer vào ObservableList
    }
}
