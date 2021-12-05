package com.www.he.bean;

/**
 * @Anthor : HQH
 * @Date : 2021/11/10
 *
 * 客户类别
 */
public class CustTypeBean {

    private String custname;
    private String type;

    public CustTypeBean() {
    }

    public CustTypeBean(String custname, String type) {
        this.custname = custname;
        this.type = type;
    }

    public String getCustname() {
        return custname;
    }

    public void setCustname(String custname) {
        this.custname = custname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
