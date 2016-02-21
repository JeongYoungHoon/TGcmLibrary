package com.wenoun.library.gcm;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import java.io.IOException;

/**
 * Created by jeyhoon on 16. 2. 10..
 */

/*

AndroidMenifest.xml Add

<!-- [START gcm_registration_service] -->
<service
        android:name=".gcm.RegistrationIntentService"
        android:exported="false"/>
<!-- [END gcm_registration_service] -->
 */
public class RegistrationIntentService extends IntentService {
    private int gcm_defaultSenderId=-1;
    private static final String TAG = "RegistrationIntentService";

    public RegistrationIntentService() {
        super(TAG);
    }
    public void setGcmDefaultSenderId(int gcm_defaultSenderId){
        this.gcm_defaultSenderId=gcm_defaultSenderId;
    }
    public int getGcmDefaultSenderId(){
        return gcm_defaultSenderId;
    }

    /**
     * GCM을 위한 Instance ID의 토큰을 생성하여 가져온다.
     * @param intent
     */
    @SuppressLint("LongLogTag")
    @Override
    protected void onHandleIntent(Intent intent) {

        // GCM Instance ID의 토큰을 가져오는 작업이 시작되면 LocalBoardcast로 GENERATING 액션을 알려 ProgressBar가 동작하도록 한다.
        LocalBroadcastManager.getInstance(this)
                .sendBroadcast(new Intent(GCMConst.REGISTRATION_GENERATING));

        // GCM을 위한 Instance ID를 가져온다.
        InstanceID instanceID = InstanceID.getInstance(this);
        String token = null;
        try {
            synchronized (TAG) {
                // GCM 앱을 등록하고 획득한 설정파일인 google-services.json을 기반으로 SenderID를 자동으로 가져온다.
                String default_senderId = getString(getGcmDefaultSenderId());
                // GCM 기본 scope는 "GCM"이다.
                String scope = GoogleCloudMessaging.INSTANCE_ID_SCOPE;
                // Instance ID에 해당하는 토큰을 생성하여 가져온다.
                token = instanceID.getToken(default_senderId, scope, null);

                Log.i(TAG, "GCM Registration Token: " + token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // GCM Instance ID에 해당하는 토큰을 획득하면 LocalBoardcast에 COMPLETE 액션을 알린다.
        // 이때 토큰을 함께 넘겨주어서 UI에 토큰 정보를 활용할 수 있도록 했다.
        Intent registrationComplete = new Intent(GCMConst.REGISTRATION_COMPLETE);
        registrationComplete.putExtra("token", token);
        LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete);
    }
}
