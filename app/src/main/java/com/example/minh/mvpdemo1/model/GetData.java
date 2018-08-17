package com.example.minh.mvpdemo1.model;

import com.example.minh.mvpdemo1.model.data.QueryData;
import com.example.minh.mvpdemo1.model.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Minh on 8/16/2018.
 */

public class GetData implements UserDataSource{
    private QueryData queryData;
    private UserDataSource mUserListener;

    public GetData(UserDataSource mUserListener) {
        this.mUserListener = mUserListener;
        this.queryData = new QueryData();
    }

    @Override
    public void getListUser(LoadUserCallBack callBack) {
        List<User> mListUsers = new ArrayList<>();
        mListUsers = QueryData.getUsers();
        if(mListUsers ==null){
           callBack.loadUserFail();
        }else {
            callBack.loadUserSuccess(mListUsers);
        }
    }
}
