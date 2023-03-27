package com.example.hiddeneye.Activities;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hiddeneye.databinding.ActivitySqlBinding;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlActivity extends AppCompatActivity {

    ActivitySqlBinding binding;

    private static final String dbURL = "jdbc:sqlserver://hiddeneye.database.windows.net:1433;database=test;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    private static final String user = "hiddeneye@hiddeneye";
    private static final String password = "htxQteam3";


    String connectionUrl = "jdbc:sqlserver://hiddeneye.database.windows.net:1433;" + "database=hiddeneye;" + "user=hiddeneye@hiddeneye;" + "password=htxQteam3;" + "encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    String connectionString = "jdbc:sqlserver://hiddeneye.database.windows.net:1433;database=hiddeneye;user=hiddeneye;password=htxQteam3;encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySqlBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                StrictMode.setThreadPolicy(policy);
                try (Connection connection = DriverManager.getConnection(connectionString)) {
                    System.out.println("connected");
                } catch (SQLException e) {
                    Log.e("shit", "shitshit");
                }
            }
        });


    }

}
