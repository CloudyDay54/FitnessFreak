package com.rosh1.fitnessfreak;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.rosh1.fitnessfreak.R;

public class LoginActivity extends AppCompatActivity {

    Button btnLoginLogin, btnSignupLogin;
    EditText txtUserNameLogin, txtPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLoginLogin =  findViewById(R.id.btnLoginLogin);
        btnSignupLogin = findViewById(R.id.btnSignupLogin);

        txtUserNameLogin = findViewById(R.id.txtUsernameLogin);
        txtPasswordLogin = findViewById(R.id.txtPasswordLogin);

        //Info.setText("No of attempts remaining: 5");

        btnLoginLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(txtUserNameLogin.getText().toString(), txtPasswordLogin.getText().toString());

            }
        });

        btnSignupLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }


    private void validate (String Username, String Password){
        if((Username.equals("Admin")) && (Password.equals("1234"))){

            Toast toast = Toast.makeText(LoginActivity.this, "Successfully Logged In", Toast.LENGTH_LONG);
            toast.show();

            Intent intent = new Intent(LoginActivity.this, Home.class);
            startActivity(intent);

        } else {

            Toast toast = Toast.makeText(LoginActivity.this, "Invalid Login. Please Try Again", Toast.LENGTH_LONG);
            toast.show();
        }
    }

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
}
