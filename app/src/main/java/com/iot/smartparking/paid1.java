package com.iot.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class paid1 extends AppCompatActivity {

    Button book1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid1);

        book1 = (Button)findViewById(R.id.button7);

        book1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(paid1.this, booking.class);
                startActivity(intent);

                Toast.makeText(paid1.this, "Loading....", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
