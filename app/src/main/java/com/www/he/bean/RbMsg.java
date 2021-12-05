package com.www.he.bean;

/**
 * @Anthor : HQH
 * @Date : 2021/11/11
 *
 * rxbus 消息
 */
public class RbMsg<T> {

    private T bean;
    private String frstring; // 用于区分

    public RbMsg(T bean, String frstring) {
        this.bean = bean;
        this.frstring = frstring;
    }

    public T getBean() {
        return bean;
    }

    public void setBean(T bean) {
        this.bean = bean;
    }

    public String getFrstring() {
        return frstring;
    }

    public void setFrstring(String frstring) {
        this.frstring = frstring;
    }
}
