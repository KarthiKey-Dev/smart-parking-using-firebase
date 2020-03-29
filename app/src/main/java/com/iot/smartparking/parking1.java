package com.iot.smartparking;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class parking1 extends AppCompatActivity {


    TextView t1,t2,t3;
    DatabaseReference dref;
    TextView slot1,slot2,slot3;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking1);
        button3 = (Button)findViewById(R.id.button3);
        t1 = (TextView) findViewById(R.id.t1);
        t2 = (TextView) findViewById(R.id.t2);
        t3 = (TextView) findViewById(R.id.t3);
        slot1 = (TextView) findViewById(R.id.view1);
        slot2 = (TextView) findViewById(R.id.view2);
        slot3 = (TextView) findViewById(R.id.view3);

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dref = FirebaseDatabase.getInstance().getReference();
                dref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot)
                    {
                        String distance=dataSnapshot.child("slot1").getValue().toString();
                        slot1.setText(distance);

                        String distance1=dataSnapshot.child("slot2").getValue().toString();
                        slot2.setText(distance1);

                        String distance2=dataSnapshot.child("slot3").getValue().toString();
                        slot3.setText(distance2);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });



    }
}
