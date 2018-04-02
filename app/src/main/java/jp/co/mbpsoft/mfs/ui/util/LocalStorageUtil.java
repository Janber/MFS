package jp.co.mbpsoft.mfs.ui.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import jp.co.mbpsoft.mfs.MyApplication;
import jp.co.mbpsoft.mfs.consts.S;

public class LocalStorageUtil {

    public static boolean getBoolean(String key, boolean defValue) {
        return getLocalStorage().getBoolean(key, defValue);
    }

    public static Editor getEditor() {
        return getLocalStorage().edit();
    }

    public static int getInt(String key, int defValue) {
        return getLocalStorage().getInt(key, defValue);
    }

    public static int getInt(String key) {
        return getLocalStorage().getInt(key, 0);
    }

    public static SharedPreferences getLocalStorage() {
        return MyApplication.getInstance().getSharedPreferences(S.common_pref, Context.MODE_PRIVATE);
    }

    public static String getString(String key) {
        return getLocalStorage().getString(key, "");
    }

    /*
     *put and commit
     */
    public static void putBoolean(String key, boolean value) {
        getEditor().putBoolean(key, value).apply();
    }

    public static void putString(String key, String value) {
        getEditor().putString(key, value).apply();
    }

}
