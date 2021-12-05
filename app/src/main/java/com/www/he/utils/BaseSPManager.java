package com.www.he.utils;

import com.www.he.bean.LoadBean;
import com.www.he.ui.base.BaseApplication;

import java.util.Locale;

/**
 * 
 * @date on 2017/11/29
 * @describe SharedPreferences 数据保存管理类
 */

public class BaseSPManager {
    public static final String FOLLOW_SYSTEM_LANGUAGE = "follow_system_language";//语言
    public static final String LANGUAGE = "language";//语言
    public static final String LANGUAGE_COUNTRY = "language_country";//语言_国家地区
    public static final String DAY_NIGHT_MODE = "day_night_mode";//日夜模式
    public static final String IS_FIRST_LAUNCH = "is_first_launch";//是否第一次启动
    public static final String VERSION_CODE = "version_code";//版本号

    public static final String LOGIN_STATUS = "login_status";        // 账号
//    public static final String LOGIN_PASSWORD = "login_password";  // 密码
//    public static final String LOGIN_ISCHECK = "login_ischeck";    // 记住密码
//    public static final String LOGIN_OUTO = "login_outo";          // 自动登录


    /*** 是否跟随系统 */
    public static boolean isFollowSystemLanguage() {
        return (boolean) SPUtil.get(FOLLOW_SYSTEM_LANGUAGE, true);
    }

    public static void setFollowSystemLanguage(boolean isFollow) {
        SPUtil.put(FOLLOW_SYSTEM_LANGUAGE, isFollow);
    }

    /***  语言 默认系统语言*/
    public static Locale getLanguage() {
        boolean isSystem = isFollowSystemLanguage();
        if (isSystem) return Locale.getDefault();
        String language = (String) SPUtil.get(LANGUAGE, Locale.getDefault().getLanguage());//默认简体中文
        String country = (String) SPUtil.get(LANGUAGE_COUNTRY, Locale.getDefault().getCountry());//默认简体中文
        return new Locale(language, country);
    }


    public static void setLanguage(Locale language) {
        SPUtil.put(LANGUAGE, language.getLanguage());
        SPUtil.put(LANGUAGE_COUNTRY, language.getCountry());
    }


    /*** 日夜模式 */
    public static boolean isNightMode() {
        return (boolean) SPUtil.get(DAY_NIGHT_MODE, false);
    }

    public static void setNightMode(boolean nightMode) {
        SPUtil.put(DAY_NIGHT_MODE, nightMode);
    }

    /*** 是否第一次启动 */
    public static boolean isFirstLaunch() {
        return (boolean) SPUtil.get(IS_FIRST_LAUNCH, true);
    }

    public static void setIsFirstLaunch(boolean isFirstLunch) {
        SPUtil.put(IS_FIRST_LAUNCH, isFirstLunch);
    }

    /*** 是否新版本 */
    public static boolean isNewVersion() {
        int versionCode = (int) SPUtil.get(VERSION_CODE, 0);
        int curCode = AppUtil.getPackageInfo(BaseApplication.getInstance()).versionCode;
        return curCode > versionCode;
    }

    public static void updateVersionCode() {
        int curCode = AppUtil.getPackageInfo(BaseApplication.getInstance()).versionCode;
        SPUtil.put(VERSION_CODE, curCode);
    }

    /*** 登录状态，账号，密码等状态 */
    public static void setLoginStatus(LoadBean lbean) {
        SPUtil.putSerializableObject(LOGIN_STATUS, lbean);
    }
    public static LoadBean getLoginStatus() {
        return SPUtil.getSerializableObject(LOGIN_STATUS);
    }

}
