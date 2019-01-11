package com.chat.pcon.pconchat.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.chat.pcon.pconchat.R;

import java.util.Random;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity {
    //widgets

    EditText name,email,password;
   // TextInputLayout name_wrapper,email_wrapper,pass_wrapper;
    Button register;
    //TextInputEditText name,email,password;
    ProgressDialog dialog;

    //variables

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private static final String TAG = "RegisterActivity";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        //set back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        onRegister();
    }
    void init(){
        name = findViewById(R.id.register_name);
        email = findViewById(R.id.register_email);
        password = findViewById(R.id.register_password);
        register = findViewById(R.id.register_btn);
//        name_wrapper = findViewById(R.id.register_name_wrapper);
//        email_wrapper = findViewById(R.id.register_email_wrapper);
//        pass_wrapper = findViewById(R.id.register_pass_wrapper);

    }
    @Override
    protected void onStart() {
        super.onStart();
        setDialog();
    }

    void setDialog(){
        dialog = new ProgressDialog(this);
        dialog.setMessage("...Signing you up");
        dialog.setCancelable(false);
    }

    void onRegister(){

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 1: register user
                //TODO 2: show and dismiss dialog

            }
        });
    }
    //TODO 3: add updateUI method
    //TODO 4: add data to firestore


    String getRandomColor(){
        String [] colors = getResources().getStringArray(R.array.colors);
        return colors[new Random().nextInt(colors.length)];
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

//TODO: check input errors
//        boolean checkInputErrors(){
//        String username = name.getText().toString();
//        String mail = email.getText().toString();
//        String pass = password.getText().toString();
//        if(username.length()<=3){
//            name_wrapper.setError("Name must have atleast 4 characters");
//            return false;
//        }
//        if(!pattern.matcher(mail).matches()){
//            email_wrapper.setError("Not a valid Email");
//            return false;
//        }
//        if(pass.length()<=5){
//            pass_wrapper.setError("Password must have atleast 6 characters");
//            return false;
//        }
//        name_wrapper.setErrorEnabled(false);
//        email_wrapper.setErrorEnabled(false);
//        pass_wrapper.setErrorEnabled(false);
//        return true;
//    }
}
