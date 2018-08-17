package com.example.minh.mvpdemo1.view;

import com.example.minh.mvpdemo1.model.entity.User;

import java.util.List;

/**
 * Created by Minh on 8/16/2018.
 */

public interface MainView {
    void succesLogin(String username, String pass);
    void failLogin();
    void displayMain(List<User> listUser);
}
