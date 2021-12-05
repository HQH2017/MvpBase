package com.www.he.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @Anthor : HQH
 * @Date : 2021/11/9
 *
 * 客户
 */
public class Customer implements Parcelable {

    private String billno;
    private String username;
    private String admin;
    private String showboss;
    private String title;
    private String linkman;
    private String tel;
    private String image;
    private String image1;
    private String image2;
    private String image3;
    private String major;
    private String phone;
    private String address;
    private String saler;
    private String sname;

    public Customer() {
    }

    public Customer(String billno, String username, String admin, String showboss, String title, String linkman, String tel, String image, String image1, String image2, String image3, String major, String phone, String address, String saler, String sname) {
        this.billno = billno;
        this.username = username;
        this.admin = admin;
        this.showboss = showboss;
        this.title = title;
        this.linkman = linkman;
        this.tel = tel;
        this.image = image;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.major = major;
        this.phone = phone;
        this.address = address;
        this.saler = saler;
        this.sname = sname;
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

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getShowboss() {
        return showboss;
    }

    public void setShowboss(String showboss) {
        this.showboss = showboss;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    protected Customer(Parcel in) {
        billno = in.readString();
        username = in.readString();
        admin = in.readString();
        showboss = in.readString();
        title = in.readString();
        linkman = in.readString();
        tel = in.readString();
        image = in.readString();
        image1 = in.readString();
        image2 = in.readString();
        image3 = in.readString();
        major = in.readString();
        phone = in.readString();
        address = in.readString();
        saler = in.readString();
        sname = in.readString();
    }

    public static final Creator<Customer> CREATOR = new Creator<Customer>() {
        @Override
        public Customer createFromParcel(Parcel in) {
            return new Customer(in);
        }

        @Override
        public Customer[] newArray(int size) {
            return new Customer[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(billno);
        parcel.writeString(username);
        parcel.writeString(admin);
        parcel.writeString(showboss);
        parcel.writeString(title);
        parcel.writeString(linkman);
        parcel.writeString(tel);
        parcel.writeString(image);
        parcel.writeString(image1);
        parcel.writeString(image2);
        parcel.writeString(image3);
        parcel.writeString(major);
        parcel.writeString(phone);
        parcel.writeString(address);
        parcel.writeString(saler);
        parcel.writeString(sname);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "billno='" + billno + '\'' +
                ", username='" + username + '\'' +
                ", admin='" + admin + '\'' +
                ", showboss='" + showboss + '\'' +
                ", title='" + title + '\'' +
                ", linkman='" + linkman + '\'' +
                ", tel='" + tel + '\'' +
                ", image='" + image + '\'' +
                ", image1='" + image1 + '\'' +
                ", image2='" + image2 + '\'' +
                ", image3='" + image3 + '\'' +
                ", major='" + major + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", saler='" + saler + '\'' +
                ", sname='" + sname + '\'' +
                '}';
    }
}
