package com.example.minh.mvpdemo1.view;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.minh.mvpdemo1.R;
import com.example.minh.mvpdemo1.model.data.MyDatabase;
import com.example.minh.mvpdemo1.model.entity.User;
import com.example.minh.mvpdemo1.presenter.MainPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {
    private EditText mEditName;
    private EditText mEditPass;
    private TextView mTextLogin;
    private Button mButtonLogin;
    private MainPresenter mMainPresenter;
    private final String DATABASE_NAME = "student.sqlite";
    public static SQLiteDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainPresenter.loadData();
            }
        });

    }

    private void init() {
        mEditName = (EditText) findViewById(R.id.edit_name);
        mEditPass = (EditText) findViewById(R.id.edit_pass);
        mTextLogin = (TextView) findViewById(R.id.text_login);
        mButtonLogin = (Button) findViewById(R.id.button_login);
        mMainPresenter = new MainPresenter(this);
        mDatabase = MyDatabase.initDatabase(this, DATABASE_NAME);
    }

    @Override
    public void succesLogin(String user, String pass) {
        Toast.makeText(this, "Success Login", Toast.LENGTH_SHORT).show();
        mTextLogin.setText(user + "/" + pass);
    }

    @Override
    public void failLogin() {
        Toast.makeText(this, "Fail Login", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void displayMain(List<User> listUser) {
        Toast.makeText(this, listUser.size()+"", Toast.LENGTH_SHORT).show();
    }

}
