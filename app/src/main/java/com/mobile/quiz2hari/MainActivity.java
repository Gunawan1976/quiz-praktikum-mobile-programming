package com.mobile.quiz2hari;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mobile.quiz2hari.R;
import com.mobile.quiz2hari.presenter.MainPresenterImp;
import com.mobile.quiz2hari.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView {
    MainPresenterImp mainPresenterImp;
    Handler handler = new Handler();
    EditText user,pass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.etName);
        pass =findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.button);

        mainPresenterImp = new MainPresenterImp(this);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,halloUser.class);
                String phone = user.getText().toString();
                String password = pass.getText().toString();
                mainPresenterImp.onLogin(phone, password);
                startActivity(i);
            }
        });
    }

    @Override
    public void LoginSucces(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void LooginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}