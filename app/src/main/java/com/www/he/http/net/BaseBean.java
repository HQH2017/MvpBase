package com.www.he.http.net;

/**
 * Created by Administrator on 2016/11/11 0011.
 */

public class BaseBean<T> {
    /**
     * 状态码
     * 1  获取失败
     * 0  获取成功
     */
    public String status;

    /**
     * 返回的信息
     */
    public String msg;
    /**
     * 时间
     */
//    public long time;

    /**
     * 数据
     */
    public T data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

//    public long getTime() {
//        return time;
//    }
//
//    public void setTime(long time) {
//        this.time = time;
//    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "code=" + status +
                ", msg='" + msg + '\'' +
//                ", time=" + time +
                ", data=" + data +
                '}';
    }
}
