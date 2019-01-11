package com.chat.pcon.pconchat.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.chat.pcon.pconchat.Others.ChatAdapter;
import com.chat.pcon.pconchat.Models.MessageInfo;
import com.chat.pcon.pconchat.Others.MyItemAnimator;
import com.chat.pcon.pconchat.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.List;

public class ChatActivity extends AppCompatActivity {
    RecyclerView rView;
    EditText msg;
    ImageView send;
    ChatAdapter mAdapter;
    FirebaseFirestore mFirestore;
    FirebaseUser mUser;
    FirebaseAuth mAuth;
    List<MessageInfo> infos=new ArrayList<>();

    private static final String TAG = "ChatActivity";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        init();
        setAdapter();
        rView.setItemAnimator(new MyItemAnimator(this));
        onSend();
        onReceiveMsg();
    }

    void init(){
        rView = findViewById(R.id.chat_rview);
        msg = findViewById(R.id.chat_msg);
        send = findViewById(R.id.chat_send_btn);
        mAdapter = new ChatAdapter(infos);

        mFirestore = FirebaseFirestore.getInstance();
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
    }


    void setAdapter(){
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setReverseLayout(true);
        rView.setLayoutManager(manager);
        rView.setAdapter(mAdapter);
    }
    void onSend(){
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(msg.getText().toString().compareTo("")!=0){
                    //TODO 13: get userinfo
                    //TODO 14: get messageinfo
                    //TODO 15: add messageinfo to firestore
                    //TODO 16: notify change adapter & scroll down
                }
                msg.setText("");

            }
        });
    }

    void onReceiveMsg(){
        //TODO 17: listen to room order by timestamp
        //TODO 18: initial load + receive new messages

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.chat,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.log_out:
                //TODO 12: clear shared preferences and sign out
                startActivity(new Intent(this,LoginActivity.class));
                finish();
                break;
            case  R.id.menu_profile:
                Intent intent = new Intent(this,ProfileActivity.class);
                //TODO 19: pass uid to next activity
                startActivity(intent);
        }
        return true;
    }
}
