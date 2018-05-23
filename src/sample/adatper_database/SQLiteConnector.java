package sample.adatper_database;


import sample.models.BannedListModel;
import sample.models.BookModel;
import sample.models.CustomerModel;
import sample.models.RentBookModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteConnector {
    //singleton
    private static final SQLiteConnector instance = new SQLiteConnector();
    private static String TAG = SQLiteConnector.class.toString();
    private Connection connection = null;
    private Statement statement;

    public static SQLiteConnector getInstanceSQLiteConnector() {
        //singleton
        return instance;
    }

    private SQLiteConnector() {
        //download driver cho sqlite, config database (link nó đến đường dẫn file db)
        //belike android, sqlite
        String URL = "jdbc:sqlite:I:/Downloads/Compressed/SQLiteDatabaseBrowserPortable/library_database_project.db";

        try {
            connection = DriverManager.getConnection(URL);
            statement = connection.createStatement();
        } catch (Exception e) {
            System.out.printf(TAG + ": in Contructor " + e.getMessage());
        }
    }

    public List<CustomerModel> getAllCustomer() {
        List<CustomerModel> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("select * from customers");
            while (rs.next()) {
                // read the result set
                String id = rs.getString("id_cus");
                String name = rs.getString("name_cus");
                String mail = rs.getString("mail_cus");
                String bod = rs.getString("born_date_cus");
                String doc = rs.getString("date_create_cus");
                String address = rs.getString("address_cus");
                String type = rs.getString("type_cus");

                CustomerModel customerModel = new CustomerModel(id, name, mail, bod, doc, address, type);
                list.add(customerModel);
            }
            rs.close();
        } catch (SQLException e) {
            System.out.printf(TAG + ": inGetAllCustomer() " + e.getMessage());
        }
        return list;
    }

    public List<BookModel> getAllBook() {
        List<BookModel> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("select * from books");
            while (rs.next()) {
                String id = rs.getString("id_book");
                String name = rs.getString("name_book");
                String category = rs.getString("category_book");
                Integer costBook = rs.getInt("cost_book");
                String author = rs.getString("author_book");
                Integer total = rs.getInt("total_book");
                String date = rs.getString("date_add_book");

                BookModel model = new BookModel(id, name, category, costBook, author, date, total);
                list.add(model);
            }
            rs.close();
        } catch (Exception e) {
            System.out.printf(TAG + ": inGetAllBook() " + e.getMessage());
        }
        return list;
    }

    public List<RentBookModel> getAllRenterBook() {
        List<RentBookModel> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("select * from rent_book");
            while (rs.next()) {
                String idRentBook = rs.getString("id_rent_book");
                String idBook = rs.getString("id_book");
                String idCustomer = rs.getString("id_cus");
                String nameOfBook = rs.getString("name_book");
                String nameOfCustomer = rs.getString("name_cus");
                String dateOfRentBook = rs.getString("date_of_rent");

                RentBookModel model = new RentBookModel(idRentBook, idBook, idCustomer, nameOfBook, nameOfCustomer, dateOfRentBook);
                list.add(model);
            }

        } catch (Exception e) {
            System.out.printf(TAG + ": getAllRenterBook() " + e.getMessage());
        }
        return list;
    }

    public void insertIntoTableCustomer(String id, String name, String mail, String bod, String doc, String address, String type) {
        try {
            String query = String.format(
                    "INSERT INTO customers (id_cus, name_cus, mail_cus, born_date_cus, date_create_cus, address_cus, type_cus) "
                            + "VALUES (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\",\"%s\")"
                    , id, name, mail, bod, doc, address, type);

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoTableBook(String id, String name, String category, Integer cost, String author, Integer total, String date_add_book) {
        try {
            String query = String.format(
                    "INSERT INTO books (id_book, name_book, category_book, cost_book, author_book, total_book, date_add_book) "
                            + "VALUES (\"%s\", \"%s\", \"%s\", %s, \"%s\", %s,\"%s\")"
                    , id, name, category, cost, author, total, date_add_book);

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertIntoTableRentBook(String idRentBook, String idBook, String idCus, String nameBook, String nameCus, String dateOfRent) {
        try {
            String query = String.format(
                    "INSERT INTO rent_book (id_rent_book, id_book, id_cus, name_book, name_cus, date_of_rent)" +
                            "VALUES(\"%s\", \"%s\", \"%s\", \"%s\",\"%s\", \"%s\")", idRentBook, idBook, idCus, nameBook, nameCus, dateOfRent);

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteRentBookID(String id) {
        String query = String.format("DELETE FROM rent_book\n" +
                "WHERE `id_rent_book` = \"%s\"", id);
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteCustomerBindID(String id) {
        String query = String.format("DELETE FROM customers\n" +
                "WHERE `id_cus` = \"%s\"", id);
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBookWithID(String id) {
        String query = String.format("DELETE FROM books\n" +
                "WHERE `id_book` = \"%s\"", id);
        try {
            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<BannedListModel> getAllBannedList() {
        List<BannedListModel> list = new ArrayList<>();
        try {
            ResultSet rs = statement.executeQuery("select * from banned_list");
            while (rs.next()) {
                String id = rs.getString("id_cus");
                String name = rs.getString("name_cus");
                String date = rs.getString("date_banned");

                BannedListModel model = new BannedListModel(id, name, date);
                list.add(model);
            }
            rs.close();
        } catch (Exception e) {
            System.out.printf(TAG + ": inGetAllBanned() " + e.getMessage());
        }
        return list;
    }

    public void insertToBannedList(String id, String name, String date_banned) {
        try {
            String query = String.format(
                    "INSERT INTO banned_list (id_cus, name_cus, date_banned)" +
                            "VALUES(\"%s\", \"%s\", \"%s\")", id, name, date_banned);

            statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
