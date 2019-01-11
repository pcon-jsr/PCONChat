package com.chat.pcon.pconchat.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chat.pcon.pconchat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    //widgets
    EditText email,password;
    Button cancel,submit;
    TextView register;
    // TextInputLayout email_wrapper,pass_wrapper;
    // TextInputEditText email,password;
    //variables
    FirebaseAuth mAuth;
    FirebaseFirestore mFirestore;
    private static final String TAG = "LoginActivity";
    private boolean isAutoLogin = false;
    ProgressDialog dialog;

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);

    @Override
    protected void onStart() {
        super.onStart();
        setDialog();
        //TODO 10: autologin
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        onSubmit();
        onCancel();
        onRegister();


    }
    void init(){
        email = findViewById(R.id.login_email);
        password = findViewById(R.id.login_password);
        cancel = findViewById(R.id.login_cancel);
        submit = findViewById(R.id.login_submit);
        register = findViewById(R.id.login_register);
//        email_wrapper = findViewById(R.id.register_email_wrapper);
//        pass_wrapper = findViewById(R.id.register_pass_wrapper);

//        mAuth = FirebaseAuth.getInstance();
//        mFirestore = FirebaseFirestore.getInstance();

    }

    void setDialog(){
        dialog = new ProgressDialog(this);
        dialog.setMessage("...Signing you up");
        dialog.setCancelable(false);
    }
    //TODO 7: add updateUI func
    //TODO 8: dismiss dialog
    //TODO 9: start chat activity
    //TODO 11: store user info at shared preferences

    void onSubmit(){
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO 5: firebase authentication
                //TODO 6: dialog show and dismiss
                //TODO: check input errors
            }
        });
    }

    void onCancel(){
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: remove text and focus
            }
        });
    }

    void onRegister(){
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: remove text and focus
                Intent intent = new Intent(getApplicationContext(),RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    private void removeTextnFocus(){
        email.setText("");
        password.setText("");
        email.clearFocus();
        password.clearFocus();
    }
    //    boolean checkInputErrors(){
//        String mail = email.getText().toString();
//        String pass = password.getText().toString();
//
//        if(!pattern.matcher(mail).matches()){
//            email_wrapper.setError("Not a valid Email");
//            return false;
//        }
//        if(pass.length()<=5){
//            pass_wrapper.setError("Not a valid Password");
//            return false;
//        }
//        email_wrapper.setErrorEnabled(false);
//        pass_wrapper.setErrorEnabled(false);
//        return true;
//    }

}
