package com.wenoun.library.gcm;

/**
 * Created by jeyhoon on 16. 2. 10..
 */
/*

AndroidMenifest.xml Add

<!-- [START gcm_receiver] -->
<receiver
    android:name="com.google.android.gms.gcm.GcmReceiver"
    android:exported="true"
    android:permission="com.google.android.c2dm.permission.SEND">
    <intent-filter>
        <action android:name="com.google.android.c2dm.intent.RECEIVE" />
        <category android:name="package.gcm" />
    </intent-filter>
</receiver>
<!-- [END gcm_receiver] -->

 */
public class GCMConst {
    public static final String REGISTRATION_READY = "registrationReady";
    public static final String REGISTRATION_GENERATING = "registrationGenerating";
    public static final String REGISTRATION_COMPLETE = "registrationComplete";
    public static final int PLAY_SERVICES_RESOLUTION_REQUEST = 9000;
    public static class CharSet{
        public static final String UTF8="UTF-8";
        public static final String EUC_KR="EUC-KR";
    }

}
