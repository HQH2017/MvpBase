package com.www.he.utils;

import com.hwangjr.rxbus.Bus;

/**
 * @Anthor : HQH
 * @Date : 2021/11/10
 */
public final class RxBusUtil {
    private static Bus sBus;

    public static synchronized Bus get() {
        if (sBus == null) {
            sBus = new Bus();
        }
        return sBus;
    }
}
