package com.www.he.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mirkowu.basetoolbar.BaseToolbar;
import com.www.he.R;
import com.www.he.ui.activity.MainActivity;
import com.www.he.ui.main.ToolbarFragment;
import com.www.he.utils.BaseSPManager;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 
 * @date on 2018/2/24
 * @describe
 *
 * 我的页面
 */

public class MineFragment extends ToolbarFragment {

    public static MineFragment newInstance() {
        Bundle args = new Bundle();
        MineFragment fragment = new MineFragment();
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Nullable
    @Override
    protected BaseToolbar.Builder setToolbar(@NonNull BaseToolbar.Builder builder) {
        return builder.addLeftImage(R.mipmap.menu, v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).openDrawer();
            }
        });
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void lazyLoad() {

    }

//    @OnClick({R.id.mBtnChangeDayNightMode, R.id.mBtnChangeLanguage, R.id.mBtnMvpTemp,
//            R.id.mBtnRefreshTemp, R.id.mBtnToolbarTemp, R.id.mBtnDataBindingTemp,
//            R.id.mBtnSocketTest, R.id.mBtnBLETest, R.id.mBtnWebView})
//    public void onClick(View v) {
//        int id = v.getId();
//        switch (id) {
//            case R.id.mBtnChangeDayNightMode://切换日夜模式
//                BaseSPManager.setNightMode(!BaseSPManager.isNightMode());
//                getBaseActivity().reload();
//                break;
//
//        }
//    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRefresh() {

    }
}
