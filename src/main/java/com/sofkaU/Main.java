package com.sofkaU;

import com.sofkaU.integration.database.mysql.MySqlOperation;

import java.sql.SQLException;

public class Main {

    private static final String SERVER = "localhost";

    private static final String DATABASE_NAME = "barberia";

    private static final String USER_NAME = "root";

    private static final String PASSWORD = "onpjd9bf";

    private static final String SELECT_ALL_CUSTOMER = "select * from cliente";

    private static final MySqlOperation mySqlOperation = new MySqlOperation();

    public static void main(String[] args) throws SQLException {
        openConnection();
        allCustomer();
        closeConnection();
    }

    public static void openConnection(){
        mySqlOperation.setServer(SERVER);
        mySqlOperation.setDatabase(DATABASE_NAME);
        mySqlOperation.setUsername(USER_NAME);
        mySqlOperation.setPassword(PASSWORD);
    }

    public static void allCustomer() throws SQLException {
        System.out.println(SELECT_ALL_CUSTOMER);
        mySqlOperation.setSqlStatement(SELECT_ALL_CUSTOMER);
        mySqlOperation.executeSQLStatement();
        mySqlOperation.printResult();
    }

    public static void closeConnection() throws SQLException {
            mySqlOperation.close();
    }
}