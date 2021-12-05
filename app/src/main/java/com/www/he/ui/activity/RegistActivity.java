package com.www.he.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mirkowu.basetoolbar.BaseToolbar;
import com.www.he.R;
import com.www.he.global.Constants;
import com.www.he.ui.main.ToolbarActivity;
import com.www.he.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
/**
 * 注册页面
 */
public class RegistActivity extends ToolbarActivity {

    @BindView(R.id.iv_login_logo)
    ImageView ivLoginLogo;
    @BindView(R.id.et_regist_username)
    EditText etRegistUsername;
    @BindView(R.id.et_regist_pwd)
    EditText etRegistPwd;
    @BindView(R.id.et_regist_msg)
    EditText etRegistMsg;
    @BindView(R.id.tv_regist_btmsg)
    TextView tvRegistBtmsg;
    @BindView(R.id.bt_regist_submit)
    Button btRegistSubmit;
    @BindView(R.id.tv_regist_ty)
    TextView tvRegistTy;
    @BindView(R.id.lay_login_container)
    LinearLayout layLoginContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initialize() {

    }

    @Nullable
    @Override
    protected BaseToolbar.Builder setToolbar(@NonNull BaseToolbar.Builder builder) {
        return builder.setTitle("用户注册");
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, RegistActivity.class);
        context.startActivity(starter);
    }

    @OnClick({R.id.et_regist_username, R.id.et_regist_pwd, R.id.et_regist_msg, R.id.tv_regist_btmsg, R.id.bt_regist_submit, R.id.tv_regist_ty})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_regist_username:
                break;
            case R.id.et_regist_pwd:
                break;
            case R.id.et_regist_msg:
                break;
            case R.id.tv_regist_btmsg:
                if ( "".equals(etRegistUsername.getText().toString())|| etRegistUsername.getText().toString() == null) {
                    ToastUtil.s("手机号码不能为空！");
                    return;
                }
                ToastUtil.s("暂时无法获取短信");
                break;
            case R.id.bt_regist_submit:
                if ( "".equals(etRegistUsername.getText().toString())|| etRegistUsername.getText().toString() == null) {
                    ToastUtil.s("手机号码不能为空！");
                    return;
                }
                if ( "".equals(etRegistPwd.getText().toString())|| etRegistPwd.getText().toString() == null) {
                    ToastUtil.s("密码不能为空！");
                    return;
                }
                if ( "".equals(etRegistMsg.getText().toString())|| etRegistMsg.getText().toString() == null) {
                    ToastUtil.s("验证码不能为空！");
                    return;
                }
                ToastUtil.s("只有开同团队的才有注册的权限！");
                break;
            case R.id.tv_regist_ty:
                WebActivity.start(getActivity(), "好业绩用户协议", Constants.agreeAgreement);
                break;
        }
    }
}
