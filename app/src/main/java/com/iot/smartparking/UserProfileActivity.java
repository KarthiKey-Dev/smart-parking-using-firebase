package com.iot.smartparking;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserProfileActivity extends AppCompatActivity {

    // Creating button.
    Button map;
    Button logout ;
    Button findparking;
    Button booking;
    Button profile;
    Button details;
    // Creating TextView.
    TextView userEmailShow ;

    // Creating FirebaseAuth.
    FirebaseAuth firebaseAuth ;

    // Creating FirebaseAuth.
    FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Assigning ID's to button and TextView.
        logout = (Button)findViewById(R.id.logout);
        userEmailShow = (TextView)findViewById(R.id.user_email);
        findparking = (Button)findViewById(R.id.findparking);
        booking = (Button)findViewById(R.id.booking);
        profile = (Button) findViewById(R.id.profile);
        map = (Button) findViewById(R.id.map);
        //details = (Button)findViewById(R.id.details);
        // Adding FirebaseAuth instance to FirebaseAuth object.
        firebaseAuth = FirebaseAuth.getInstance();

        // On activity start check whether there is user previously logged in or not.
        if(firebaseAuth.getCurrentUser() == null){

            // Finishing current Profile activity.
            finish();

            // If user already not log in then Redirect to LoginActivity .
            Intent intent = new Intent(UserProfileActivity.this, LoginActivity.class);
            startActivity(intent);

            // Showing toast message.
            Toast.makeText(UserProfileActivity.this, "Please Log in to continue", Toast.LENGTH_LONG).show();

        }

        // Adding firebaseAuth current user info into firebaseUser object.
        firebaseUser = firebaseAuth.getCurrentUser();

        // Getting logged in user email from firebaseUser.getEmail() method and set into TextView.
        userEmailShow.setText("Successfully Logged In, Your Email = " + firebaseUser.getEmail());

        // Adding click listener on logout button.
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Destroying login season.
                firebaseAuth.signOut();

                // Finishing current User Profile activity.
                finish();

                // Redirect to Login Activity after click on logout button.
                Intent intent = new Intent(UserProfileActivity.this, login2.class);
                startActivity(intent);

                // Showing toast message on logout.
                Toast.makeText(UserProfileActivity.this, "Logged Out Successfully.", Toast.LENGTH_LONG).show();



            }
        });

        findparking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, findparking.class);
                startActivity(intent);

                Toast.makeText(UserProfileActivity.this, "Loading....", Toast.LENGTH_SHORT).show();
            }
        });

        booking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, viewbooking.class);
                startActivity(intent);
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, profile.class);
            startActivity(intent);
            }
        });

        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UserProfileActivity.this, freeparking.class);
                startActivity(intent);
            }
        });

       }
}