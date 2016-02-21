package com.wenoun.library.gcm;

import android.app.Activity;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

/**
 * Created by jeyhoon on 16. 2. 21..
 */
/*

/**

 // Instance ID를 이용하여 디바이스 토큰을 가져오는 RegistrationIntentService를 실행한다.
public void getInstanceIdToken() {
    if (GCMUtil.checkPlayServices()) {
        // Start IntentService to register this application with GCM.
        Intent intent = new Intent(ctx, RegistrationIntentService.class);
        startService(intent);
    }
}
private BroadcastReceiver mRegistrationBroadcastReceiver;


// LocalBroadcast 리시버를 정의한다. 토큰을 획득하기 위한 READY, GENERATING, COMPLETE 액션에 따라 UI에 변화를 준다.
public void registBroadcastReceiver(){
    mRegistrationBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if(action.equals(GCMConst.REGISTRATION_READY)){
                Log.d("Test"," REGISTRATION_READY : ");
                // 액션이 READY일 경우
            } else if(action.equals(GCMConst.REGISTRATION_GENERATING)){
                Log.d("Test"," REGISTRATION_GENERATING : ");
                // 액션이 GENERATING일 경우
            } else if(action.equals(GCMConst.REGISTRATION_COMPLETE)){
                // 액션이 COMPLETE일 경우
                String token = intent.getStringExtra("token");
                String regId=token;
                Log.d(TAG,"Result token : "+regId);
            }
            unregistBroadcastReceiver();
        }
    };
    try{
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
        new IntentFilter(GCMConst.REGISTRATION_READY));
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
        new IntentFilter(GCMConst.REGISTRATION_GENERATING));
        LocalBroadcastManager.getInstance(this).registerReceiver(mRegistrationBroadcastReceiver,
        new IntentFilter(GCMConst.REGISTRATION_COMPLETE));
    }catch(Exception e){
        e.printStackTrace();
    }
}
public void unregistBroadcastReceiver(){
    try {
        if (null != mRegistrationBroadcastReceiver)
            unregisterReceiver(mRegistrationBroadcastReceiver);
    }catch (Exception e){
        e.printStackTrace();
    }
}


 */
public class GCMUtil {
    public static boolean checkPlayServices(Activity act) {
        int resultCode = GooglePlayServicesUtil.isGooglePlayServicesAvailable(act);
        if (resultCode != ConnectionResult.SUCCESS) {
            if (GooglePlayServicesUtil.isUserRecoverableError(resultCode)) {
                GooglePlayServicesUtil.getErrorDialog(resultCode, act,
                        GCMConst.PLAY_SERVICES_RESOLUTION_REQUEST).show();
            } else {
//                Log.i(TAG, "This device is not supported.");
//                finish();
            }
            return false;
        }
        return true;
    }
}
