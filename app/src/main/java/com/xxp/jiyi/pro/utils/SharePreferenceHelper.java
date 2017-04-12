package com.xxp.jiyi.pro.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者：MiaoMiao on 2017/4/12.
 * 邮箱：1340751953@163.com
 * 版本：v1.0
 */

public class SharePreferenceHelper {
    private final String SP_NAME = "config";
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    private static Context context;

    private SharePreferenceHelper() {
        sp = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sp.edit();

    }

    public static SharePreferenceHelper getInstance(Context context) {
        SharePreferenceHelper.context = context;
        return Singleton.sharePreferenceHelper;
    }

    private static class Singleton {
        private static SharePreferenceHelper sharePreferenceHelper = new SharePreferenceHelper();
    }


    public void putBoolbean(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.commit();
    }

    public boolean getBoolbean(String key, Boolean def) {
        return sp.getBoolean(key, def);
    }

    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String def) {
        return sp.getString(key, def);
    }

    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

    public int getInt(String key, int def) {
        return sp.getInt(key, def);
    }
}
