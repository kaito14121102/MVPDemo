package com.example.minh.mvpdemo1.model.data;

import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;

import com.example.minh.mvpdemo1.model.entity.User;
import com.example.minh.mvpdemo1.view.MainActivity;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by Minh on 8/17/2018.
 */

public class QueryData {
    public static List<User> getUsers() {
        String sqlQuery = "Select * from information";
        Cursor cursor = MainActivity.mDatabase.rawQuery(sqlQuery, null);
        List<User> mUserList = new ArrayList<>();
        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(1);
                String age = cursor.getString(2);
                mUserList.add(new User(name,age));
            }while (cursor.moveToNext());

        }
        return mUserList;
    }
}
