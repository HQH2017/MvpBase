package com.www.he.ui.activity;

import android.content.Context;
import android.content.Intent;

import com.www.he.R;
import com.www.he.ui.base.BaseActivity;
import com.www.he.utils.SPManager;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
/**
 * 第一个页面
 */
public class SplashActivity extends BaseActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, SplashActivity.class);
//	    starter.putExtra( );
        context.startActivity(starter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initialize() {
        Observable.timer(1500, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .compose(bindToLifecycle())
                .subscribe(aLong -> {
                    boolean isFirstLaunch = SPManager.isFirstLaunch();
                    if (isFirstLaunch) {
                        GuideActivity.start(getActivity());
                    } else {
                        // MainActivity.start(getActivity());
                        LoginActivity.start(getActivity());
                    }
                    finish();
                });
    }

    @Override
    protected void onDestroy() {
        getWindow().setBackgroundDrawable(null);//释放资源
        super.onDestroy();
    }
}
