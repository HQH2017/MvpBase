package com.www.he.bean;

/**
 * @Anthor : HQH
 * @Date : 2021/11/9
 *
 * 对于返回数据{ data: { List: [], total: 0 }, msg: '', status: 0 }
 * 存放 data
 */
public class ListBean<T> {
    public T list;
    public String total;

    public ListBean() {
    }

    public T getResults() {
        return list;
    }

    public void setResults(T list) {
        this.list = list;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
