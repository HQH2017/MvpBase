package com.www.he.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * 
 * @date on 2018/4/17
 * @describe
 *
 * 用户表 (作用我的页面)
 */
public class UserBean implements Parcelable {
    private String billno;
    private String username;
    private String userno;
    private String address;
    private String phone;
    private String tel;
    private String team;
    private String teamnae;
    private String image;
    private String image1;
    private String image2;
    private String app;
    private String admin;
    private String token;

    public UserBean(String billno, String username, String userno, String address, String phone, String tel, String team, String teamnae, String image, String image1, String image2, String app, String admin, String token) {
        this.billno = billno;
        this.username = username;
        this.userno = userno;
        this.address = address;
        this.phone = phone;
        this.tel = tel;
        this.team = team;
        this.teamnae = teamnae;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.app = app;
        this.admin = admin;
        this.token = token;
    }

    public UserBean() {
    }

    public String getBillno() {
        return billno;
    }

    public void setBillno(String billno) {
        this.billno = billno;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserno() {
        return userno;
    }

    public void setUserno(String userno) {
        this.userno = userno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeamnae() {
        return teamnae;
    }

    public void setTeamnae(String teamnae) {
        this.teamnae = teamnae;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    // 序列化过程
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.billno);
        dest.writeString(this.username);
        dest.writeString(this.userno);
        dest.writeString(this.address);
        dest.writeString(this.phone);
        dest.writeString(this.tel);
        dest.writeString(this.team);
        dest.writeString(this.teamnae);
        dest.writeString(this.image);
        dest.writeString(this.image1);
        dest.writeString(this.image2);
        dest.writeString(this.app);
        dest.writeString(this.admin);
        dest.writeString(this.token);
    }

    protected UserBean(Parcel in) {
        this.billno = in.readString();
        this.username = in.readString();
        this.userno = in.readString();
        this.address = in.readString();
        this.phone = in.readString();
        this.tel = in.readString();
        this.team = in.readString();
        this.teamnae = in.readString();
        this.image = in.readString();
        this.image1 = in.readString();
        this.image2 = in.readString();
        this.app = in.readString();
        this.admin = in.readString();
        this.token = in.readString();
    }

    // 反序列化
    public static final Creator<UserBean> CREATOR = new Creator<UserBean>() {
        @Override
        public UserBean createFromParcel(Parcel source) {
            return new UserBean(source);
        }

        @Override
        public UserBean[] newArray(int size) {
            return new UserBean[size];
        }
    };

    @Override
    public String toString() {
        return "UserBean{" +
                "billno='" + billno + '\'' +
                ", username='" + username + '\'' +
                ", userno='" + userno + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", tel='" + tel + '\'' +
                ", team='" + team + '\'' +
                ", teamnae='" + teamnae + '\'' +
                ", image='" + image + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", app='" + app + '\'' +
                ", admin='" + admin + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

}
