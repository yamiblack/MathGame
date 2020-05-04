package hitesh.asimplegame;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {
    private static final String TAG = "MusicService";
    public MediaPlayer mp;

    public IBinder onBind(Intent intent){

        return null;
    }

    public void onCreate(){
        super.onCreate();
        Log.d(TAG,"onCreate");
        mp = MediaPlayer.create(this, R.raw.bgm111);
        mp.setLooping(false);
    }

    public void  onDestory(){
        super.onDestroy();
        Log.d(TAG,"onDestory");
        mp.stop();
    }

    public int onStartCommand(Intent intent, int flags, int startld){
        Log.d(TAG, "onStart");
        mp.start();
        return super.onStartCommand(intent, flags, startld);
    }

}
