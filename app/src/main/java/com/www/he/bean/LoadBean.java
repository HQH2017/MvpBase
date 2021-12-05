package com.www.he.bean;

import androidx.annotation.NonNull;

import java.io.Serializable;

/**
 * @Anthor : HQH
 * @Date : 2021/11/9
 *
 * 登录时保存本地的属性
 */
public class LoadBean implements Serializable {

    private String phone;       // 账号
    private String password;    // 密码
    private boolean isCheck;    // 记住密码
    private boolean auto;       // 自动登录

    public LoadBean(String phone, String password, boolean isCheck, boolean auto) {
        this.phone = phone;
        this.password = password;
        this.isCheck = isCheck;
        this.auto = auto;
    }

    public LoadBean() {
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getIsCheck() {
        return isCheck;
    }

    public void setIsCheck(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public boolean getAuto() {
        return auto;
    }

    public void setAuto(boolean auto) {
        this.auto = auto;
    }

    @Override
    public String toString() {
        return "LoadBean{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", isCheck='" + isCheck + '\'' +
                ", auto='" + auto + '\'' +
                '}';
    }
}
