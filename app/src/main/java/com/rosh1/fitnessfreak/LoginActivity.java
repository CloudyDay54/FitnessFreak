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
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ProgressDialog;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.rosh1.fitnessfreak.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    //defining firebase auth object
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;

    Button btnLoginLogin, btnSignupLogin;
    EditText txtEmailLogin, txtPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initializing firebase auth object
        mAuth = FirebaseAuth.getInstance();

        //if the object getCurrentUser method is not null, it means the user is already logged in
        if(mAuth.getCurrentUser() != null){
            //close this activity
            finish();
            //opening Home Activity
            startActivity(new Intent(getApplicationContext(), Home.class));
        }

        //initializing views
        btnLoginLogin =  findViewById(R.id.btnLoginLogin);
        btnSignupLogin = findViewById(R.id.btnSignupLogin);

        txtEmailLogin = findViewById(R.id.txtEmailLogin);
        txtPasswordLogin = findViewById(R.id.txtPasswordLogin);

        progressDialog = new ProgressDialog(this);

        /*btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(txtUserNameLogin.getText().toString(), txtPasswordLogin.getText().toString());

            }
        }); */

        btnLoginLogin.setOnClickListener(this);

        btnSignupLogin.setOnClickListener(this);

    }

    //method for user login
    private void userLogin(){
        String email = txtEmailLogin.getText().toString().trim();
        String password = txtPasswordLogin.getText().toString().trim();

        //checking if email and password are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter Password", Toast.LENGTH_SHORT).show();
            return;
        }

        //if the meail and password are not empty, dispaly a progress dialog

        progressDialog.setMessage("Logging In: Please Wait...");
        progressDialog.show();

        //logging in the user
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successful
                        if(task.isSuccessful()){
                            //start the Home Activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), Home.class));
                            Toast.makeText(LoginActivity.this, "Login Successfull", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Error: Incorrect Email and Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }


    /*private void validate (String Username, String Password){
        if((Username.equals("Admin")) && (Password.equals("1234"))){

            Toast toast = Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_LONG);
            toast.show();

            Intent intent = new Intent(LoginActivity.this, Home.class);
            startActivity(intent);

        } else {

            Toast toast = Toast.makeText(LoginActivity.this, "Invalid Login. Please Try Again", Toast.LENGTH_LONG);
            toast.show();
        }
    } */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // created resource file menu_main... hope it doesn't bring problems
        getMenuInflater().inflate(R.menu.menu_login, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        if(view == btnLoginLogin){
            userLogin();
        }

        if(view == btnSignupLogin){
            finish();
            startActivity(new Intent(this, SignupActivity.class));
        }

    }
}
