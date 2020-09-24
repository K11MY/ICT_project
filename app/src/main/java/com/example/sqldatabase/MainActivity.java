package com.example.sqldatabase;

import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MyDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDb = new MyDatabaseHelper(this);
    }
}