package com.www.he.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.mirkowu.basetoolbar.BaseToolbar;
import com.www.he.R;
import com.www.he.bean.LoadBean;
import com.www.he.bean.LoginBean;
import com.www.he.bean.UserBean;
import com.www.he.global.Constants;
import com.www.he.http.net.RxCallback;
import com.www.he.presenter.LoginPresenter;
import com.www.he.ui.main.ToolbarActivity;
import com.www.he.utils.L;
import com.www.he.utils.RxBusUtil;
import com.www.he.utils.SPManager;
import com.www.he.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 登陆页面
 */
public class LoginActivity extends ToolbarActivity<LoginPresenter> {

    @BindView(R.id.iv_login_logo)
    ImageView ivLoginLogo;
    @BindView(R.id.iv_login_username_icon)
    ImageView ivLoginUsernameIcon;
    @BindView(R.id.et_login_username)
    EditText etLoginUsername;
    @BindView(R.id.ll_login_username)
    LinearLayout llLoginUsername;
    @BindView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @BindView(R.id.bt_login_submit)
    Button btLoginSubmit;
    @BindView(R.id.lay_login_container)
    LinearLayout layLoginContainer;
    @BindView(R.id.ib_login_wx)
    ImageView ibLoginWx;
    @BindView(R.id.ib_login_qq)
    ImageView ibLoginQq;
    @BindView(R.id.tv_yh)
    TextView tvYh;
    @BindView(R.id.tv_ys)
    TextView tvYs;
    @BindView(R.id.checkbox_mm)
    CheckBox checkboxMm;
    @BindView(R.id.tv_forget)
    TextView tvForget;
    @BindView(R.id.checkbox_outo)
    CheckBox checkboxOuto;

    @Nullable
    @Override
    protected BaseToolbar.Builder setToolbar(@NonNull BaseToolbar.Builder builder) {
        return builder.setTitle("用户登陆").addRightText("注册", Color.WHITE, 13, new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                RegistActivity.start(getActivity());
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initialize() {
        hideToolbBack(true);
        // 本地数据
        LoadBean loadBean = SPManager.getLoginStatus();
        if (loadBean != null) {
            etLoginUsername.setText(loadBean.getPhone());
            etLoginPwd.setText(loadBean.getPassword());
            checkboxMm.setChecked(loadBean.getIsCheck());
            checkboxOuto.setChecked(loadBean.getAuto());
        }

//        etLoginUsername.setText("18316498508");
//        etLoginPwd.setText("1234");
//        checkboxMm.setChecked(true);
//        checkboxOuto.setChecked(false);
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, LoginActivity.class);
        context.startActivity(starter);
    }

    @OnClick({R.id.et_login_username, R.id.et_login_pwd, R.id.bt_login_submit, R.id.ib_login_wx, R.id.ib_login_qq, R.id.tv_yh, R.id.tv_ys, R.id.checkbox_mm, R.id.tv_forget, R.id.checkbox_outo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_login_username:

                break;
            case R.id.et_login_pwd:
                break;
            case R.id.bt_login_submit:
                if ("".equals(etLoginUsername.getText().toString()) || etLoginUsername.getText().toString() == null) {
                    ToastUtil.s("账号：123456，不能为空！");
                    return;
                }
                if ("".equals(etLoginPwd.getText().toString()) || etLoginPwd.getText().toString() == null) {
                    ToastUtil.s("密码：123456，不能为空！");
                    return;
                }

                if ("123456".equals(etLoginUsername.getText().toString()) && "123456".equals(etLoginPwd.getText().toString())) {
                       MainActivity.start(LoginActivity.this, new LoginBean());
                        finish();
                }

                // 获取网络数据
//                getPresenter().getLoginData(etLoginUsername.getText().toString(), etLoginPwd.getText().toString()).subscribe(new RxCallback<LoginBean>() {
//                    @Override
//                    public void onSuccess(@Nullable LoginBean data) {
//                        // 存放本地数据
//                        LoadBean loadBean = new LoadBean();
//                        loadBean.setPhone(etLoginUsername.getText().toString());
//                        loadBean.setPassword(checkboxMm.isChecked() ? etLoginPwd.getText().toString() : "");
//                        loadBean.setIsCheck(checkboxMm.isChecked());
//                        loadBean.setAuto(checkboxOuto.isChecked());
//                        SPManager.setLoginStatus(loadBean);
//                        MainActivity.start(LoginActivity.this, data);
//                        finish();
//                    }
//                });
                break;
            case R.id.ib_login_wx: // 微信
                break;
            case R.id.ib_login_qq: // QQ
                break;
            case R.id.tv_yh:
                WebActivity.start(getActivity(), "用户协议", Constants.userAgreement);
                break;
            case R.id.tv_ys:
                WebActivity.start(getActivity(), "隐私协议", Constants.secretAgreement);
                break;
            case R.id.checkbox_mm:
                break;
            case R.id.tv_forget: // 找回密码
                FindPwActivity.start(getActivity());
                break;
            case R.id.checkbox_outo:
                break;
        }
    }

}
