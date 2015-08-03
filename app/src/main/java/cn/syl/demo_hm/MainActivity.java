package cn.syl.demo_hm;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import cn.syl.demo_aidl.IDownloadInterface;
import cn.syl.demo_hm.aidl.AIDLActivity;

/*
 * PACKAGE_NAME :cn.syl.demo_hm
 * VERSION :[V 1.0.0]
 * AUTHOR :  yulongsun 
 * CREATE AT : 8/3/2015 1:58 PM
 * COPYRIGHT : InSigma HengTian Software Ltd.
 * E-MAIL: yulongsun@hengtiansoft.com
 * NOTE : 
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aidlDemo(View v) {
        Intent intent = new Intent(this, AIDLActivity.class);
        startActivity(intent);
    }

}
