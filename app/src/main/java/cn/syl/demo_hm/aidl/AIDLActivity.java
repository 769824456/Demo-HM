package cn.syl.demo_hm.aidl;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import cn.syl.demo_aidl.IDownloadInterface;
import cn.syl.demo_hm.R;

public class AIDLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        this.bindService(new Intent("cn.syl.demo_aidl.MyDownloadService"),serviceConnection,BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.unbindService(serviceConnection);
    }
    private IDownloadInterface iDownloadInterface;
    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            //1.
            iDownloadInterface = IDownloadInterface.Stub.asInterface(iBinder);
            try {
                iDownloadInterface.download("http://www.baidu.com");
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            iDownloadInterface=null;
        }
    };
}
