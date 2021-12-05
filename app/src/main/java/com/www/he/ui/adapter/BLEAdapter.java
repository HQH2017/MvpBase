package com.www.he.ui.adapter;

import android.bluetooth.BluetoothDevice;

import com.www.he.R;
import com.www.he.ui.base.BaseRVAdapter;
import com.www.he.ui.base.BaseRVHolder;

/**
 * 
 * @date on 2019/3/4
 * @describe
 */
public class BLEAdapter extends BaseRVAdapter<BluetoothDevice> {
    public BLEAdapter() {
        super(R.layout.item_ble);
    }

    @Override
    public void onBindVH(BaseRVHolder holder, BluetoothDevice data, int position) {
        holder.setText(R.id.tvName, data.getName())
                .setText(R.id.tvMac, data.getAddress())
                .setText(R.id.tvOther, String.format("uuid%s ,type=%d", data.getUuids(),data.getType()));
    }
}
