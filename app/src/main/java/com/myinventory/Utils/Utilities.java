package com.myinventory.Utils;

import android.app.Activity;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;

public class Utilities {
    private static DialogFragment mDialogFragment;
    private static final String TAG_FRAGMENT = "Dialog";

    public static void showProgressDialog(Activity context, FragmentManager manager) {
        if (context == null || context.isFinishing()) {
            return;
        }

        if (mDialogFragment != null && mDialogFragment.isVisible()) {
            return;
        }
        DialogFragment mPrevious = mDialogFragment;
        mDialogFragment = new ProgressDialogFragment();

        mDialogFragment.setCancelable(false);
        ((ProgressDialogFragment) mDialogFragment).setCanceledOnTouchOutside(false);

        if (mPrevious != null) {
            manager.beginTransaction().remove(mPrevious).commitAllowingStateLoss();
        }
        manager.beginTransaction().add(mDialogFragment, TAG_FRAGMENT).commitAllowingStateLoss();
    }

    public static void dismissProgressDialog() {
        if (mDialogFragment != null) {
            mDialogFragment.dismissAllowingStateLoss();
            mDialogFragment = null;
        }
    }

}
