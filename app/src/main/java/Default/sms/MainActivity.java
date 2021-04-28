package Default.sms;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Telephony;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.provider.Telephony.Sms.getDefaultSmsPackage;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener {

    private static final int MESSAGE_CODE = 100;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button);
//        perm();
//         Intent open_CSV = new Intent(this, csv.class);
//        perm();
//        btn.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        Toast.makeText(MainActivity.this, "dhingapuray", Toast.LENGTH_SHORT).show();
//        startActivity(open_CSV);
//
//
//    }
//});

       // perm();
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            perm2();
//        }
perm2();

    }

    // PERM 2
    /* working where the android 30 is the target API

    android {
    compileSdkVersion 30
    buildToolsVersion "30.0.3"

    defaultConfig {
        applicationId "Default.sms"
        minSdkVersion 16
        targetSdkVersion 30
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }


     */

    public void perm2(){
        Context mContext3 = getApplicationContext();
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.P) {
            RoleManager roleManager = null;
            roleManager = mContext3.getSystemService(RoleManager.class);
            Intent roleRequestIntent = roleManager.createRequestRoleIntent(
                    RoleManager.ROLE_SMS);
            startActivityForResult(roleRequestIntent, MESSAGE_CODE);

        } else {
            Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
            intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME,
                    mContext3.getPackageName());
            startActivityForResult(intent, MESSAGE_CODE);
        }

    }

    // PERM
    /* working where the android 29 is the target API
    android {
    compileSdkVersion 30
    buildToolsVersion "30.0.3"

    defaultConfig {
        applicationId "Default.sms"
        minSdkVersion 16
        targetSdkVersion 29
        versionCode 1
        versionName "1.0"

        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }


     */

    public void perm(){

        String[] permissions = new String[]
                {
                        Manifest.permission.READ_SMS,
                        Manifest.permission.RECEIVE_SMS,
                        Manifest.permission.SEND_SMS,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.READ_CALL_LOG,
                        Manifest.permission.WRITE_CALL_LOG
                };
        ActivityCompat.requestPermissions(this, permissions, 0);
        Context mContext = getApplicationContext();

        if (1==1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                if (getDefaultSmsPackage(mContext) != null && !getDefaultSmsPackage(mContext).equals(mContext.getPackageName())) {
                    RoleManager roleManager = null;
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        roleManager = mContext.getSystemService(RoleManager.class);

                        if (roleManager.isRoleAvailable(RoleManager.ROLE_SMS)) {
                            if (roleManager.isRoleHeld(RoleManager.ROLE_SMS)) {
                                Log.d("role", "role");
                            } else {
                                Intent roleRequestIntent = roleManager.createRequestRoleIntent(
                                        RoleManager.ROLE_SMS);
                                startActivityForResult(roleRequestIntent, MESSAGE_CODE);
                            }
                        }
                    } else {
                        Intent intent = new Intent(Telephony.Sms.Intents.ACTION_CHANGE_DEFAULT);
                        intent.putExtra(Telephony.Sms.Intents.EXTRA_PACKAGE_NAME,
                                mContext.getPackageName());
                        startActivityForResult(intent, MESSAGE_CODE);
                    }
                }
            }
        }

    }

    @Override
    public void onClick(View v) {

    }
}