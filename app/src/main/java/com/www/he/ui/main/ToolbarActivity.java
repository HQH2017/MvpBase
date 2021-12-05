package com.www.he.ui.main;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.mirkowu.basetoolbar.BaseToolbar;
import com.mirkowu.statusbarutil.StatusBarUtil;
import com.www.he.R;
import com.www.he.ui.base.BaseActivity;
import com.www.he.ui.base.IBasePresenter;
import com.www.he.utils.BaseSPManager;

import butterknife.ButterKnife;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;


public abstract class ToolbarActivity<P extends IBasePresenter> extends BaseActivity<P> {
    private BaseToolbar mBaseToolbar;


    @Override
    public void bindView() {
        /*** 这里可以对Toolbar进行统一的预设置 */
        BaseToolbar.Builder builder
                = new BaseToolbar.Builder(getContext())
                .setBackButton(R.mipmap.back)//统一设置返回键
                //    .setStatusBarColor(ContextUtil.getColor(R.color.colorPrimary))//统一设置颜色
                .setBackgroundColor(ContextCompat.getColor(getContext(),R.color.colorHeadtoolbar))
                .setSubTextColor(Color.WHITE)
                // .setTitleTextSize(15)
                .setTitleTextColor(Color.WHITE);

        builder = setToolbar(builder);
        if (builder != null) {
            mBaseToolbar = builder.build();
        }
        if (mBaseToolbar != null) {
            //添加Toolbar
            LinearLayout layout = new LinearLayout(getContext());
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);
            layout.setLayoutParams(params);
            layout.setOrientation(LinearLayout.VERTICAL);
            layout.addView(mBaseToolbar);
            View mView = getActivity().getLayoutInflater().inflate(getLayoutId(), layout, false);
            layout.addView(mView);

            setContentView(layout);

            //将toolbar设置为actionbar
            setSupportActionBar(mBaseToolbar);
        } else {
            setContentView(getLayoutId());
        }

        //设置沉浸式透明状态栏
        // StatusBarUtil.setTransparent(this);
        StatusBarUtil.setStatusBarColor(getActivity(), ContextCompat.getColor(getContext(),R.color.colorHeadtoolbar));

        //ButterKnife
        unbinder = ButterKnife.bind(this);

        //非夜间模式 要开启亮色模式
        // setStatusBarLightMode();
    }

    public void setStatusBarLightMode() {
        if (!BaseSPManager.isNightMode()) {
            if (StatusBarUtil.setStatusBarLightModeWithNoSupport(getActivity(), true)) {
                if (getToolbar() != null) getToolbar().hideStatusBar();
            }
        }
    }

    public BaseToolbar getToolbar() {
        return mBaseToolbar;
    }


    public void showToolbar() {
        if (mBaseToolbar != null) mBaseToolbar.setVisibility(View.VISIBLE);
    }

    public void hideToolbar() {
        if (mBaseToolbar != null) mBaseToolbar.setVisibility(View.GONE);
    }

    // 控制toolbar 的左边的按钮 显示或隐藏
    public void hideToolbBack(boolean back) {
        if (mBaseToolbar != null && back)  if (back) mBaseToolbar.hideBackButton();
    }

    /**
     * 不需要toolbar的 可以不用管
     * 头部栏 设置
     * @return
     */
    @Nullable
    protected abstract BaseToolbar.Builder setToolbar(@NonNull BaseToolbar.Builder builder);
}


