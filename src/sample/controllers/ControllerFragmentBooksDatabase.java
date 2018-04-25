package sample.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.adatper_database.SQLiteConnector;
import sample.models.BookModel;

import java.util.List;

public class ControllerFragmentBooksDatabase {
    private final String TAG = ControllerFragmentBooksDatabase.class.toString();

    @FXML
    private TableView<BookModel> table_book;

    @FXML
    private TableColumn<BookModel, String> id_book_colum;

    @FXML
    private TableColumn<BookModel, String> name_book_colum;

    @FXML
    private TableColumn<BookModel, String> category_book_colum;

    @FXML
    private TableColumn<BookModel, Integer> cost_book_colum;

    @FXML
    private TableColumn<BookModel, String> author_book_colum;

    @FXML
    private TableColumn<BookModel, String>  total_book_colum;

    @FXML
    private TableColumn<BookModel, String> date_add_book_colum;

    public void initialize(){
        Controller.clone_lbMain.setVisible(true);
        Controller.clone_lbMain.setText("List Book");
        Controller.bt_back_clone.setVisible(true); //show button back and image back
        Controller.iv_back_clone.setVisible(true); //show button back and image back
        setupDataForTableView(); //init data
    }

    private void setupDataForTableView(){
        id_book_colum.setCellValueFactory(new PropertyValueFactory<BookModel, String>("id_book"));
        name_book_colum.setCellValueFactory(new PropertyValueFactory<BookModel, String>("name_book"));
        category_book_colum.setCellValueFactory(new PropertyValueFactory<BookModel, String>("category_book"));
        cost_book_colum.setCellValueFactory(new PropertyValueFactory<BookModel, Integer>("cost_book"));
        author_book_colum.setCellValueFactory(new PropertyValueFactory<BookModel, String>("author_book"));
        total_book_colum.setCellValueFactory(new PropertyValueFactory<BookModel, String>("total_book"));
        date_add_book_colum.setCellValueFactory(new PropertyValueFactory<BookModel, String>("date_add_book"));

        //ObservableList<BookModel> listBook = getListBook();
        table_book.setItems(getListBook());
    }

    private ObservableList<BookModel> getListBook(){
        return FXCollections.observableArrayList(SQLiteConnector.getInstanceSQLiteConnector().getAllBook());
    }

}
