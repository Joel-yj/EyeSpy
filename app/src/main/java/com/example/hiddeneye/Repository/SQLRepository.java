package com.example.hiddeneye.Repository;

import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLRepository {

    private static final String DB_URL = "jdbc:sqlserver://hiddeneye.database.windows.net:1433;database=test;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String USER = "hiddeneye";
    private static final String PASS = "htxQteam3";

//  ac20add1-ffda-45c1-adc5-16a0db15810f

    public static void getConnection(){

        try(Connection connection = DriverManager.getConnection(DB_URL,USER,PASS)){
            System.out.println("connected");
        }catch (SQLException e){
            Log.e("shit","shitshit");
        }

    }



}
