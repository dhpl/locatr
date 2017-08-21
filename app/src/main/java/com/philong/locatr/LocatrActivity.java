package com.philong.locatr;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.Fragment;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

public class LocatrActivity extends SingleFragmentActivity{

    private static final int REQUEST_ERROR = 0;


    @Override
    protected Fragment createFragment() {
        return LocatrFragment.newInstance();
    }

    @Override
    protected void onResume() {
        super.onResume();
        int erroCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        if(erroCode != ConnectionResult.SUCCESS){
            Dialog erroDialog = GooglePlayServicesUtil
                    .getErrorDialog(erroCode, this, REQUEST_ERROR,
                            new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialogInterface) {
                                    finish();
                                }
                            });
            erroDialog.show();
        }
    }
}