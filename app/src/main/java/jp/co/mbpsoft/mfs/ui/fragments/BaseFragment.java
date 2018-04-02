package jp.co.mbpsoft.mfs.ui.fragments;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.View;
import android.content.res.Resources;
import jp.co.mbpsoft.mfs.MyApplication;


public class BaseFragment extends Fragment {

    public Activity mActivity;

    @SuppressWarnings("unchecked")
    public <T extends View> T findView(View view, int resId) {
        return (T) view.findViewById(resId);
    }

    /**
     * {@link Fragment#getResources()} sometimes fails because a fragment is not attached to an activity<br>
     * Use this method to call getResources from Application<br>
     *
     * @return Resources
     */
    public Resources getResourcesFromApplication() {
        return MyApplication.getInstance().getResources();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;
    }

    protected void finish() {
        if (isResumed()) {
            getActivity().finish();
        }
    }

}
