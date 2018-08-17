package com.example.minh.mvpdemo1.presenter;

import com.example.minh.mvpdemo1.model.GetData;
import com.example.minh.mvpdemo1.model.UserDataSource;
import com.example.minh.mvpdemo1.model.entity.User;
import com.example.minh.mvpdemo1.view.MainView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minh on 8/16/2018.
 */

public class MainPresenter implements UserDataSource.LoadUserCallBack {
    private MainView mainView;
    private GetData mGetData;
    public MainPresenter(MainView mainView) {
        this.mainView = mainView;
        //mGetData = new GetData(this);
    }

    public void checkAccount(){
    }

    public void loadData(){
        mGetData.getListUser(this);
    }


    @Override
    public void loadUserSuccess(List<User> listUser) {
        mainView.displayMain(listUser);
    }

    @Override
    public void loadUserFail() {

    }
}
