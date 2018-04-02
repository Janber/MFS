package jp.co.mbpsoft.mfs;

import android.app.Application;
import android.content.res.Configuration;
import jp.co.mbpsoft.mfs.ui.util.LocalStorageUtil;

public class MyApplication extends Application {

    private static MyApplication sApp;

    public static MyApplication getInstance() {
        if (sApp == null) {
            sApp = new MyApplication();
        }
        return sApp;

    }

    /**
     * If a device is a tablet, allow an applicaiton to autoRotate
     *
     * @return true: autoRotate false: Do not allow landscape mode
     */
    public static boolean isAutoLandscape() {
        return LocalStorageUtil.getBoolean("is_tablet", false);
    }

    public MyApplication() {

    }

    public boolean isLandscape() {
        return (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApp = this;
        //Check if a device is a tablet
        LocalStorageUtil.putBoolean("is_tablet", getResources().getBoolean(R.bool.is_tablet));
    }

}
