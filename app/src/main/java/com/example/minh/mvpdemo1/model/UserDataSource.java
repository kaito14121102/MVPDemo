package com.example.minh.mvpdemo1.model;

import com.example.minh.mvpdemo1.model.entity.User;

import java.util.List;

/**
 * Created by Minh on 8/16/2018.
 */

public interface UserDataSource {
    interface LoadUserCallBack{
        void loadUserSuccess(List<User> listUser);
        void loadUserFail();
    }
    void getListUser(LoadUserCallBack callback);
}
