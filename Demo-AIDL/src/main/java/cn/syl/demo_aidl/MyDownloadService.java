package cn.syl.demo_aidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class MyDownloadService extends Service {

    @Override
    public IBinder onBind(Intent intent) {
        return new ServiceBinder();
    }

    class ServiceBinder extends IDownloadInterface.Stub {

        @Override
        public void download(String path) throws RemoteException {
            Log.d("ServiceBinder", path);
        }
    }
}
