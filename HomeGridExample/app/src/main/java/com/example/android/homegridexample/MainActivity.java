package com.example.android.homegridexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

public class MainActivity extends AppCompatActivity {

    private GridCell[] categories = new GridCell[]{
            new GridCell("Baby", R.drawable.ic_child_friendly_black_24dp),
            new GridCell("Timer", R.drawable.ic_access_alarms_black_24dp),
            new GridCell("Photos", R.drawable.ic_photo_camera_black_24dp),
            new GridCell("Settings", R.drawable.ic_settings_black_24dp),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        GridAdapter booksAdapter = new GridAdapter(this, categories);

        gridView.setAdapter(booksAdapter);
    }
}
