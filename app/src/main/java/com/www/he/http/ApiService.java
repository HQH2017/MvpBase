package com.www.he.http;

import com.www.he.bean.Customer;
import com.www.he.bean.GankBaseBean;
import com.www.he.bean.ImageBean;
import com.www.he.bean.ListBean;
import com.www.he.bean.LoginBean;
import com.www.he.bean.UserBean;
import com.www.he.http.net.BaseBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * @Anthor : HQH
 * @Date : 2021/11/7
 * 数据接口
 */
public interface ApiService {

    String HOST_URL = "http://192.168.31.7/api/team/background/"; // 本地服务接口,(替换线上接口即可)

    //接口有参数时 要写上该注解
    // @FormUrlEncoded
    @POST("api/data/福利/{pageSize}/{page}")
    Observable<BaseBean<List<ImageBean>>> getData(/*@Field("is_new") int is_new*/);
    /**
     * gank 图片列表
     * @param page
     * @param pageSize
     * @return
     */
    @GET("api/data/福利/{pageSize}/{page}")
    Observable<GankBaseBean<List<ImageBean>>> getImages(@Path("page") int page, @Path("pageSize") int pageSize);
    // 自已传入url
    @POST
    Observable<BaseBean<List<ImageBean>>> getData(@Url String url/*@Field("is_new") int is_new*/);

    // ===================
    // 登录
    @GET("index.php?m=user&a=login")
    Observable<BaseBean<LoginBean>> getLogin(@Query("uid") String userPhone, @Query("upass") String passWord);
    // 客户 sid -1新客户
    @GET("index.php?m=main&a=getcustomer")
    Observable<BaseBean<ListBean<List<Customer>>>> getCustomer(@Query("page") int page, @Query("pagesize") int pagesize, @Query("uid") String uid, @Query("admin") String admin, @Query("sid") String sid, @Query("custname") String custname);



}
