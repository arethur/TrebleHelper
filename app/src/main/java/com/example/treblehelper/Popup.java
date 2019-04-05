package com.example.treblehelper;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;

public class Popup extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width * 0.8), (int)(height * 0.2));

    }

    public void getResult(View view) {
        EditText editor = findViewById(R.id.getUserName);
        Intent intent = new Intent();
        intent.putExtra("valueId", editor.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        finish();
    }

}
