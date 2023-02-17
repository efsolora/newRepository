package com.sofkaU.integration.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface Idatabase {
    public  void  configureDatabaseConnection();

    public void executeSQLStatement();

    public ResultSet getResulset();

    public void close();

    public void printResult()throws SQLException;
}
