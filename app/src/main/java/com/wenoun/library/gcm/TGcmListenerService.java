package com.wenoun.library.gcm;

import android.os.Bundle;

import com.google.android.gms.gcm.GcmListenerService;

import java.net.URLDecoder;

/**
 * Created by jeyhoon on 16. 2. 10..
 */
/*

AndroidMenifest.xml Add

<!-- [START gcm_listener_service] -->
<service
    android:name=".gcm.TGcmListenerService"
    android:exported="false">
    <intent-filter>
        <action android:name="com.google.android.c2dm.intent.RECEIVE" />
    </intent-filter>
</service>
<!-- [END gcm_listener_service] -->


 */
public class TGcmListenerService extends GcmListenerService {
    private static final String TAG = "TGcmListenerService";


    public String decodeUrl(String value, String charSet){
        try{
            return URLDecoder.decode(value, charSet);
        }catch(Exception e){
            return value;
        }
    }
    public String decodeUrl(String value){
        return decodeUrl(value,GCMConst.CharSet.UTF8);
    }

    /**
     *
     * @param from SenderID 값을 받아온다.
     * @param data Set형태로 GCM으로 받은 데이터 payload이다.
     */
    @Override
    public void onMessageReceived(String from, Bundle data) {
        super.onMessageReceived(from, data);
    }

}