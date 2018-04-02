package jp.co.mbpsoft.mfs;

import android.app.Application;
import android.content.res.Configuration;
import jp.co.mbpsoft.mfs.ui.util.LocalStorageUtil;

public class MFSApp extends Application {

    private static MFSApp sApp;

    public static MFSApp getInstance() {
        if (sApp == null) {
            sApp = new MFSApp();
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

    public MFSApp() {

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
