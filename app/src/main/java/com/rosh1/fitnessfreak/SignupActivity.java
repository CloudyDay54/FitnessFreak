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

        //if getCurrentUser does not return null
        if(mAuth.getCurrentUser() != null){
            //that means user is already logged in so close this activity
            finish();

            //and open profile activity
            startActivity(new Intent(getApplicationContext(), Home.class));
        }

        //initializing views
        btnCreateAccountSignup = findViewById(R.id.btnCreateAccountSignup);
        btnLoginSignup = findViewById(R.id.btnLoginSignup);

        txtFirstNameSignup = findViewById(R.id.txtFirstNameSignup);
        txtLastNameSignup = findViewById(R.id.txtLastNameSignup);
        txtEmailSignup = findViewById(R.id.txtEmailSignup);
        txtPasswordSignup = findViewById(R.id.txtPasswordSignup);
        txtRetypePasswordSignup = findViewById(R.id.txtRetypePasswordSignup);


        btnLoginSignup.setOnClickListener(this);
        btnCreateAccountSignup.setOnClickListener(this);
    }

    private void registerUser(){
        //getting email and password from EditTexts
        String first_name = txtFirstNameSignup.getText().toString().trim();
        String last_name = txtLastNameSignup.getText().toString().trim();
        String email = txtEmailSignup.getText().toString().trim();
        String password = txtPasswordSignup.getText().toString().trim();
        String retype_password = txtRetypePasswordSignup.getText().toString().trim();

        if(TextUtils.isEmpty(first_name)){
            Toast.makeText(this, "Please enter your First Name", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(last_name)){
            Toast.makeText(this, "Please enter your Last Name", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(retype_password)){
            Toast.makeText(this, "Please Retype Your Password", Toast.LENGTH_LONG).show();
            return;
        }

        if(!password.equals(retype_password)){
            Toast.makeText(this, "Error: Password and Retype Password do not match", Toast.LENGTH_SHORT).show();
            return;
        }

        //if the details are not empty displaying a progress dialog

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
                            //open Home Activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                            //display some message here
                            Toast.makeText(SignupActivity.this, "Registartion Successfull", Toast.LENGTH_SHORT).show();
                        } else {
                            //display some message here
                            Toast.makeText(SignupActivity.this, "Registration Failed: Please Try Again", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }



    @Override
    public void onClick(View view) {

        if(view == btnCreateAccountSignup){
            registerUser();
        }

        if(view == btnLoginSignup){
            //open LoginActivity when user taps on btnLoginSignup\
            startActivity(new Intent(this, LoginActivity.class));
        }

    }
}
