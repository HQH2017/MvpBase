package com.www.he.presenter;


import com.www.he.bean.Customer;
import com.www.he.bean.ListBean;
import com.www.he.bean.LoginBean;
import com.www.he.http.RetrofitClient;
import com.www.he.http.net.NetworkTransformer;
import com.www.he.ui.base.BasePresenter;

import java.util.List;

import io.reactivex.Observable;

/**
 * 
 * @date on 2018/4/12
 * @describe
 * 客户页面
 */
public class CustomerPresenter extends BasePresenter {

    // 获取客户列表
    public Observable<ListBean<List<Customer>>> getCustomer(int page, int pagesize,String uid, String admin, String sid, String custname) {
        return RetrofitClient.getApiService()
                .getCustomer(page, pagesize, uid, admin, sid, custname)
                .compose(new NetworkTransformer<>(this));
    }

}
