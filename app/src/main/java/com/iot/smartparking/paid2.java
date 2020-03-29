package com.iot.smartparking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class paid2 extends AppCompatActivity {

    Button book;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid2);

        book = (Button)findViewById(R.id.button7);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(paid2.this, booking.class);
                startActivity(intent);

                Toast.makeText(paid2.this, "Loading....", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
