package com.wenoun.library.gcm;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by jeyhoon on 16. 2. 10..
 */
/*

<!-- [START instanceId_listener_service] -->
<service
    android:name=".gcm.TInstanceIDListenerService"
    android:exported="false">
    <intent-filter>
        <action android:name="com.google.android.gms.iid.InstanceID" />
    </intent-filter>
</service>
<!-- [END instanceId_listener_service] -->

 */
public class TInstanceIDListenerService extends InstanceIDListenerService {

    private static final String TAG = "TInstanceIDLS";

    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}