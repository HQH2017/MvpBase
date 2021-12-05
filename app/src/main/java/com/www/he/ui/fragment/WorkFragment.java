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
 * 工作台页面
 */

public class WorkFragment extends ToolbarFragment {

    public static WorkFragment newInstance() {
        Bundle args = new Bundle();
        WorkFragment fragment = new WorkFragment();
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


    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onRefresh() {

    }
}
