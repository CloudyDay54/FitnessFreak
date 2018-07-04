package com.rosh1.fitnessfreak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity implements View.OnClickListener {
    Button btnGymLocationsHome, btnProfileHome, btnGymInstructorsHome,
            btnWorkoutsHome, btnPastWorkoutsHome, btnLanguageHome, btnLogoutHome;

    //firebase auth object
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //initializing firebase authentication object
        mAuth = FirebaseAuth.getInstance();

        //if the user is not logged in that means current user will return null
        if(mAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        FirebaseUser user = mAuth.getCurrentUser();

        //initializing views
        btnGymInstructorsHome = findViewById(R.id.btnGymInstructorsHome);
        btnLanguageHome = findViewById(R.id.btnLanguageHome);
        btnPastWorkoutsHome = findViewById(R.id.btnPastWorkoutsHome);
        btnProfileHome = findViewById(R.id.btnProfileHome);
        btnLanguageHome = findViewById(R.id.btnLanguageHome);
        btnGymLocationsHome = findViewById(R.id.btnGymLocationsHome);
        btnLogoutHome = findViewById(R.id.btnLogoutHome);

        btnLogoutHome.setOnClickListener(this);

        btnGymLocationsHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home.this, GymLocations.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == btnLogoutHome){
            //logging out the user
            mAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }
}
