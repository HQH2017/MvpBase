package com.www.he.ui.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.mirkowu.basetoolbar.BaseToolbar;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.www.he.R;
import com.www.he.bean.Customer;
import com.www.he.bean.ListBean;
import com.www.he.bean.LoginBean;
import com.www.he.bean.CustTypeBean;
import com.www.he.bean.RbMsg;
import com.www.he.http.net.RxCallback;
import com.www.he.presenter.CustomerPresenter;
import com.www.he.ui.activity.MainActivity;
import com.www.he.ui.adapter.CustomerAdapter;
import com.www.he.ui.base.BaseRVAdapter;
import com.www.he.ui.main.ToolbarFragment;
import com.www.he.utils.L;
import com.www.he.utils.ToastUtil;

import java.util.List;

import butterknife.BindView;

/**
 * 
 * @describe 客户页面
 */

public class MainFragment extends ToolbarFragment<CustomerPresenter> {

    @BindView(R.id.mRecyclerView)
    RecyclerView mainRecyclerView;
    @BindView(R.id.mRefreshLayout)
    SmartRefreshLayout mainRefreshLayout;
    private CustomerAdapter mAdapter;
    private LoginBean loginBean;
    private String uid;
    private String admin;
    private String sid = "-1"; // -1新客户
    private String custname;
    private String mtitle = "新客户";

    public static MainFragment newInstance() {
        Bundle args = new Bundle();
        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }

    @Nullable
    @Override
    protected BaseToolbar.Builder setToolbar(@NonNull BaseToolbar.Builder builder) {
        return builder
                .setTitle(mtitle)
                .addLeftImage(R.mipmap.menu, v -> {
                    if (getActivity() instanceof MainActivity) {
                        ((MainActivity) getActivity()).openDrawer();
                    }
                })

                .addRightImage(R.mipmap.add_w, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
    }

    @Override
    protected void initEventAndData() {
        initRefreshLayout();
        initRecyclerView();
        setEnableEmptyView(true);  // 启用空布局
        addItemDecoration(R.color.text_light);
        mAdapter = new CustomerAdapter();
//        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
//            @Override
//            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
//                ToastUtil.s("=="+position);
//            }
//        });

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ToastUtil.s("=="+position);
            }
        });
        mRecyclerView.setAdapter(mAdapter);
        // 接收数据
       loginBean = (LoginBean) getActivity().getIntent().getParcelableExtra("loginBean");
        uid = loginBean != null ? loginBean.getUserno() : "18316498508";
        admin = loginBean != null ? loginBean.getAdmin() : "";
        sid = "-1";     // -1新客户
        custname = "";  // 查询
    }

    // 下拉刷新 onRefresh(), 下拉更多 onLoadMoreRequested()
    // mPage页码，PAGE_COUNT每一页的数量
    @Override
    protected void lazyLoad() {
        L.msg(sid+","+mPage);
        getPresenter().getCustomer(mPage, PAGE_COUNT, uid, admin, sid, custname).subscribe(new RxCallback<ListBean<List<Customer>>>() {
            @Override
            public void onSuccess(@Nullable ListBean<List<Customer>> data) {
                setLoadMore(mAdapter, data.getResults());
            }
        });
    }

    // 侧栏内容更改触发
    @Subscribe
    public void callMain(RbMsg rbMsg) {
        if (rbMsg.getFrstring() == "customer") {
            CustTypeBean custTypeBean = (CustTypeBean) rbMsg.getBean();
            sid = custTypeBean != null ? custTypeBean.getType() : "-1";
            mtitle = custTypeBean.getCustname();
            setToolbarTitle(mtitle); // 设置标题
            onRefresh();
        }
    }

}
