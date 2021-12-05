package com.www.he.ui.adapter;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.www.he.R;
import com.www.he.bean.Customer;
import com.www.he.ui.base.BaseRVAdapter;
import com.www.he.ui.base.BaseRVHolder;
import com.www.he.utils.ImageUtil;
import com.www.he.utils.L;

import java.util.List;

/**
 * @Anthor : HQH
 * @Date : 2021/11/9
 */
public class CustomerAdapter extends BaseRVAdapter<Customer> {
    public CustomerAdapter() {
        super(R.layout.item_customer);
    }

    @Override
    public void onBindVH(BaseRVHolder holder, Customer data, int position) {
        holder.setText(R.id.tv_item_title, data.getTitle())
                .setText(R.id.tv_item_linnane, "小明"+position)  // data.getLinkman()
                .setText(R.id.tv_item_phone, data.getTel())
                .setImageResource(R.id.tv_item_image, R.mipmap.failed_team_custemor)
                .setText(R.id.tv_item_address, data.getAddress());

        // item点击事件
        holder.addOnClickListener(R.id.ll_item_click);

        String imageurl = data.getImage();
        if (null == holder || null == imageurl || imageurl.equals("")) {
            return;
        }
        Glide.with(mContext)
                .load(data.getImage())
                .placeholder(R.mipmap.failed_team_custemor)
                .into((ImageView) holder.getView(R.id.tv_item_image));

    }

}
