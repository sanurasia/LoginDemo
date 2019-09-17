package com.example.sanjaychaurasia.logindemo;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void signInAction(View v){
        final TextInputLayout mEmailInput;
        mEmailInput =  findViewById(R.id.textInputLayout);
        String email = mEmailInput.getEditText().getText().toString();
        if(emailValidator(email)){
            Toast.makeText(this, R.string.valid_email, Toast.LENGTH_SHORT).show();

        }else{
            Toast.makeText(this, R.string.enter_valid_email, Toast.LENGTH_SHORT).show();
            return;
        }

        final TextInputLayout passwordInput;
        passwordInput = findViewById(R.id.passwordLayout);
        String password = passwordInput.getEditText().getText().toString();
        if(validatePassword(password)){
            //Alt + enter to save string constant
            Toast.makeText(this, R.string.valid_password, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, R.string.enter_valid_password, Toast.LENGTH_SHORT).show();
            return;
        }

    }

    public boolean emailValidator(String email)
    {
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public boolean validatePassword(String password) {
        return password.length() > 5;
    }

}
