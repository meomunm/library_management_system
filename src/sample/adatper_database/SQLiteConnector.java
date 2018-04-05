package sample.adatper_database;


import sample.models.CustomerModel;

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
        } catch (SQLException e) {
            System.out.printf(TAG + ": inGetAllCustomer() " + e.getMessage());
        }
        return list;
    }
}
