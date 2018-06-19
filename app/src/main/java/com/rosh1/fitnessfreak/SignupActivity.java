package com.rosh1.fitnessfreak;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {


    Button btnCreateAccountSignup, btnLoginSignup;
    EditText txtFirstNameSignup, txtLastNameSignup, txtEmailSignup,
            txtPasswordSignup, txtRetypePasswordSignup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        btnCreateAccountSignup = findViewById(R.id.btnCreateAccountSignup);
        btnLoginSignup = findViewById(R.id.btnLoginSignup);

        txtFirstNameSignup = findViewById(R.id.txtFirstNameSignup);
        txtLastNameSignup = findViewById(R.id.txtLastNameSignup);
        txtEmailSignup = findViewById(R.id.txtEmailSignup);
        txtPasswordSignup = findViewById(R.id.txtPasswordSignup);
        txtRetypePasswordSignup = findViewById(R.id.txtRetypePasswordSignup);


        btnLoginSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });


        btnCreateAccountSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(intent);
                Toast.makeText(SignupActivity.this, "Account Created", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
