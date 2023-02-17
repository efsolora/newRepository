package com.sofkaU.integration.database.mysql;

import com.sofkaU.integration.database.Idatabase;

import java.sql.*;

import static com.sofkaU.integration.database.mysql.MySqlConstants.CONNECTION_STRING;
import static com.sofkaU.integration.database.mysql.MySqlConstants.MY_SQLC_JDBC_DRIVER;

public class MySqlOperation implements Idatabase {

    private Connection connection = null;

    private Statement statement = null;

    private ResultSet resultSet = null;

    private String sqlStatement;

    private String server;

    private String database;

    private String username;

    private String password;

    public String getSqlStatement() {
        return sqlStatement;
    }

    public void setSqlStatement(String sqlStatement) {
        this.sqlStatement = sqlStatement;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void configureDatabaseConnection() {
        try {
            Class.forName(MY_SQLC_JDBC_DRIVER);
            connection = DriverManager.getConnection(
                    String.format(CONNECTION_STRING,
                            this.server,
                            this.database,
                            this.username,
                            this.password)
            );

        }catch (Exception e) {
            close();
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void executeSQLStatement() {
        try {
            configureDatabaseConnection();
            statement.execute(sqlStatement);
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

    @Override
    public ResultSet getResulset() {
        return resultSet;
    }

    @Override
    public void close() {
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(connection != null){
                connection.close();
            }
            if(statement != null){
                statement.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void printResult() throws SQLException {
        System.out.println(resultSet);
    }
}
