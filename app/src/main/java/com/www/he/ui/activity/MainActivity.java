package com.www.he.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.drawerlayout.widget.DrawerLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.google.android.material.navigation.NavigationView;
import com.mirkowu.basetoolbar.BaseToolbar;
import com.mirkowu.statusbarutil.StatusBarUtil;
import com.www.he.R;
import com.www.he.bean.LoginBean;
import com.www.he.bean.RbMsg;
import com.www.he.bean.TabEntityBean;
import com.www.he.bean.CustTypeBean;
import com.www.he.ui.base.FragmentBasePagerAdapter;
import com.www.he.ui.fragment.MainFragment;
import com.www.he.ui.main.ToolbarActivity;
import com.www.he.ui.widget.NoScrollViewPager;
import com.www.he.utils.L;
import com.www.he.utils.RxBusUtil;
import com.www.he.utils.ToastUtil;

import java.util.ArrayList;

import butterknife.BindView;
import me.jessyan.autosize.AutoSizeConfig;

/**
 * 主页面
 */
public class MainActivity extends ToolbarActivity {

    @BindView(R.id.mTabLayout)
    CommonTabLayout mTabLayout;
    @BindView(R.id.mViewPager)
    NoScrollViewPager mViewPager;
    @BindView(R.id.mDrawerLayout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView navigationView;
    private String sid = "-1";  // 类别

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Nullable
    @Override
    protected BaseToolbar.Builder setToolbar(@NonNull BaseToolbar.Builder builder) {
        return null;
    }

    @Override
    protected void initialize() {
        StatusBarUtil.setTransparentForDrawerLayout(this, mDrawerLayout);

        FragmentBasePagerAdapter adapter = new FragmentBasePagerAdapter(getSupportFragmentManager(),
                MainFragment.newInstance(), MainFragment.newInstance(),
                MainFragment.newInstance(), MainFragment.newInstance());
        mViewPager.setAdapter(adapter);
        // , getString(R.string.mall) , R.mipmap.mall_unselec , R.mipmap.mall_selec
        String[] mTitles = {getString(R.string.customer), getString(R.string.news), getString(R.string.works), getString(R.string.me),};
        int[] mIconUnSelectIds = {
                R.mipmap.customer_unselect, R.mipmap.news_unselec, R.mipmap.work__unselec, R.mipmap.me_unselec};
        int[] mIconSelectIds = {
                R.mipmap.customer_select, R.mipmap.news_selec, R.mipmap.work_selec, R.mipmap.me_select};
        ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntityBean(mTitles[i], mIconSelectIds[i], mIconUnSelectIds[i]));
        }
        mTabLayout.setTabData(mTabEntities);
        mTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                mViewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {

            }
        });

        mTabLayout.showDot(2);
        mTabLayout.showMsg(1, 10);
        mTabLayout.setMsgMargin(3, -3, 5);
        setOrientationPortrait(false);

        // 获取数据
        // LoginBean loginBean = (LoginBean) getIntent().getParcelableExtra("loginBean");

        navigationView.setNavigationItemSelectedListener(onNavigationItemSelectedListener);

    }

    // 向其他的activity,fragment提供跳转到这里的方法
    public static void start(Context context, LoginBean obj) {
        Intent starter = new Intent(context, MainActivity.class);
        starter.putExtra("loginBean", obj);
        context.startActivity(starter);
    }

    /**
     * 检查是否为竖屏
     */
    public void checkScreenOrientation() {
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            AutoSizeConfig.getInstance().setDesignWidthInDp(360).setDesignHeightInDp(640);
        } else {
            AutoSizeConfig.getInstance().setDesignWidthInDp(640).setDesignHeightInDp(360);

        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        L.d("onConfigurationChanged调用了");
        checkScreenOrientation();
    }

    public void openDrawer() {
        mDrawerLayout.openDrawer(Gravity.LEFT);
    }


    /**
     * 再按一次退出程序
     */
    private long currentBackPressedTime = 0;
    private static int BACK_PRESSED_INTERVAL = 5000;

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN
                && event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - currentBackPressedTime > BACK_PRESSED_INTERVAL) {
                currentBackPressedTime = System.currentTimeMillis();
                ToastUtil.s("再按一次，退出应用！");
                return true;
            } else {
                finish(); // 退出
            }
            return false;

        } else if (event.getKeyCode() == KeyEvent.KEYCODE_MENU) {
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    private NavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mDrawerLayout.closeDrawer(Gravity.LEFT);
            CustTypeBean custTypeBean = new CustTypeBean();
            switch (item.getItemId()) {
                case R.id.nav_new_cust: {
                 sid = "-1";
                }
                break;
                case R.id.nav_vs_cust: {
                    sid = "0";
                }
                break;
                case R.id.nav_ys_cust: {
                    sid = "1";
                }
                break;
                case R.id.nav_no_cust: {
                    sid = "2";
                }
                break;
                case R.id.nav_go_cust: {
                    sid = "3";
                }
                break;
                case R.id.nav_old_cust: {
                    sid = "4";
                }
                break;
            }
            custTypeBean.setCustname(item.getTitle().toString());
            custTypeBean.setType(sid);
            RxBusUtil.get().post(new RbMsg<>(custTypeBean, "customer"));
            // MainFragment.newInstance().changeTitle(sid);   // 这种方法不行
            return false;
        }
    };

}
