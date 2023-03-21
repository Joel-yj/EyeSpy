package com.example.hiddeneye.Activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hiddeneye.databinding.ActivitySqlBinding;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;

public class SqlActivity extends AppCompatActivity {

    ActivitySqlBinding binding;

    private static final String dbURL = "jdbc:sqlserver://hiddeneye.database.windows.net:1433;database=test";
    private static final String user = "hiddeneye";
    private static final String password = "htxQteam3";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySqlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        new SetupDatabaseTask().execute();


    }

    /**
     * Implements task which will setup Database
     */
    private class SetupDatabaseTask extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            Connection conn = null;

            try {
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                conn = DriverManager.getConnection(dbURL, user, password);

                InputStream ins = getAssets().open("application.properties");

                Properties properties = new Properties();
                properties.load(ins);

                Scanner scanner = new Scanner(getClassLoader().getResourceAsStream("schema.sql"));
                Statement statement = conn.createStatement();
                while (scanner.hasNextLine()) {
                    statement.execute(scanner.nextLine());
                }

                return true;

            } catch (SQLException e) {
                Log.d("DB connection failed", e.getMessage());
            } catch (Exception ex) {
                Log.e("Exception Occured:", ex.getMessage());
                return false;//Return if exception found.
            } finally {
                if (conn != null) {
                    try {
                        conn.close();//close DB connection
                    } catch (SQLException e) {
                        Log.d("Unable closing connection", e.getMessage());
                    }//end catch block
                }//check whether connection closed or not
            }

            return null;
        }
    }
}