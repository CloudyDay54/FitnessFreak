package com.rosh1.fitnessfreak;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    //defining firebase auth object
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    private static final String TAG = "EmailPassword";

    Button btnCreateAccountSignup, btnLoginSignup;
    EditText txtFirstNameSignup, txtLastNameSignup, txtEmailSignup,
            txtPasswordSignup, txtRetypePasswordSignup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        //initializing firebase auth object
        mAuth = FirebaseAuth.getInstance();

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


        btnCreateAccountSignup.setOnClickListener(this);
    }

    private void registerUser(){
        //getting email and password from EditTexts
        String email = txtEmailSignup.getText().toString().trim();
        String password = txtPasswordSignup.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and passsword are not empty displaying a progress dialog

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Registering: Please Wait...");
        progressDialog.show();

        //creating a new user
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if successful
                        if(task.isSuccessful()){
                            //display some message here
                            Toast.makeText(SignupActivity.this, "Registartion Successfull", Toast.LENGTH_SHORT).show();
                        } else {
                            //display some message here
                            Toast.makeText(SignupActivity.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }


    @Override
    public void onClick(View view) {
        registerUser();
    }
}
