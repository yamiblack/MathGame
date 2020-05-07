package hitesh.asimplegame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.ToggleButton;

public class Setting extends Activity {
    ToggleButton music;
    SeekBar volumeseek = null;
    AudioManager audioManager = null;
    TextView text;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //타이틀바 삭제
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.settingspopup);
        text = (TextView)findViewById(R.id.textView2);
        music = (ToggleButton) findViewById(R.id.toggleButton);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        initControls();



        music.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                CheckState();
            }
        });

    }


    private void initControls(){
        try
        {
            volumeseek = (SeekBar)findViewById(R.id.seekBar);
            audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
            volumeseek.setMax(audioManager
                    .getStreamMaxVolume(AudioManager.STREAM_MUSIC));
            volumeseek.setProgress(audioManager
                    .getStreamVolume(AudioManager.STREAM_MUSIC));


            volumeseek.setOnSeekBarChangeListener(new OnSeekBarChangeListener()
            {
                @Override
                public void onStopTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onStartTrackingTouch(SeekBar arg0)
                {
                }

                @Override
                public void onProgressChanged(SeekBar arg0, int progress, boolean arg2)
                {
                    audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,
                            progress, 0);
                    text.setText("VOLUME: "+progress);

                }
            });
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    private void CheckState() {
        if(music.isChecked() == true) {
            Intent intent = new Intent(getApplicationContext(), MusicService.class);
            startService(intent);
        } else{
            Intent intent = new Intent(getApplicationContext(), MusicService.class);
            stopService(intent);
        }
    }


    public void mOnClose(View v){
        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("result", "Close Popup");
        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }


    public boolean onTouchEvent(MotionEvent event) {
        //바깥 레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }
}
