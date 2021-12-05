package com.www.he.presenter;


import com.www.he.bean.ImageBean;
import com.www.he.bean.LoginBean;
import com.www.he.bean.UserBean;
import com.www.he.http.ApiService;
import com.www.he.http.RetrofitClient;
import com.www.he.http.net.NetworkTransformer;
import com.www.he.ui.base.BasePresenter;

import java.util.List;

import io.reactivex.Observable;

/**
 * 
 * @describe
 * 登录
 */
public class LoginPresenter extends BasePresenter {

    // 登录
    public Observable<LoginBean> getLoginData(String phone, String password) {
        return RetrofitClient.getApiService()
                .getLogin(phone, password)
                .compose(new NetworkTransformer<>(this));
    }

}
