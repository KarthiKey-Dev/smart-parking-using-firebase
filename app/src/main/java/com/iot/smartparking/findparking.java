package com.iot.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class findparking extends AppCompatActivity {
    Button button,button2,button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findparking);

        button4 = (Button)findViewById(R.id.button4);
        button = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);


        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent intent = new Intent(findparking.this, freeparking.class);
            startActivity(intent);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(findparking.this, paidparking.class );
                startActivity(intent);
            }
        });


    }
}
