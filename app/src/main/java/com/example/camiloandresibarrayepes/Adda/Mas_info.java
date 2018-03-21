package com.example.camiloandresibarrayepes.Adda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.camiloandresibarrayepes.pruebafoto3.R;

public class Mas_info extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mas_info);


    }

    public void usar_adda(View view) {

        Intent intent = new Intent(getApplicationContext(), Slider.class)/*.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP)*/;
        startActivity(intent);
    }
}
