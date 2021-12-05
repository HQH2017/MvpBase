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
import com.www.he.ui.main.ToolbarActivity;
import com.www.he.utils.RxBusUtil;
import com.www.he.utils.ToastUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 找回密码页面
 */
public class FindPwActivity extends ToolbarActivity {


    @BindView(R.id.iv_login_logo)
    ImageView ivLoginLogo;
    @BindView(R.id.et_findpw_username)
    EditText etFindpwUsername;
    @BindView(R.id.et_findpw_msg)
    EditText etFindpwMsg;
    @BindView(R.id.tv_findpw_btmsg)
    TextView tvFindpwBtmsg;
    @BindView(R.id.et_findpw_pwd)
    EditText etFindpwPwd;
    @BindView(R.id.bt_findpw_submit)
    Button btFindpwSubmit;
    @BindView(R.id.lay_login_container)
    LinearLayout layLoginContainer;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_find_pw;
    }

    @Override
    protected void initialize() {

    }

    @Nullable
    @Override
    protected BaseToolbar.Builder setToolbar(@NonNull BaseToolbar.Builder builder) {
        return builder.setTitle("找回密码");
    }

    public static void start(Context context) {
        Intent starter = new Intent(context, FindPwActivity.class);
        context.startActivity(starter);
    }

    @OnClick({R.id.et_findpw_username, R.id.et_findpw_msg, R.id.tv_findpw_btmsg, R.id.et_findpw_pwd, R.id.bt_findpw_submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.et_findpw_username:
                break;
            case R.id.et_findpw_msg:
                break;
            case R.id.tv_findpw_btmsg:
                if ("".equals(etFindpwUsername.getText().toString()) || etFindpwUsername.getText().toString() == null) {
                    ToastUtil.s("手机号码不能为空！");
                    return;
                }
                ToastUtil.s("暂时无法获取短信");
                break;
            case R.id.et_findpw_pwd:
                break;
            case R.id.bt_findpw_submit:
//                if ("".equals(etFindpwUsername.getText().toString()) || etFindpwUsername.getText().toString() == null) {
//                    ToastUtil.s("手机号码不能为空！");
//                    return;
//                }
//                if ("".equals(etFindpwMsg.getText().toString()) || etFindpwMsg.getText().toString() == null) {
//                    ToastUtil.s("验证码不能为空！");
//                    return;
//                }
//                if ("".equals(etFindpwPwd.getText().toString()) || etFindpwPwd.getText().toString() == null) {
//                    ToastUtil.s("新密码不能为空！");
//                    return;
//                }
//                ToastUtil.s("只有开同团队的才有注册的权限！");
                break;
        }
    }
}
