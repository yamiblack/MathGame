package hitesh.asimplegame;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;

        public class Setting extends Activity {
            Switch music;
            Button initial;

            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                //타이틀바 삭제
                requestWindowFeature(Window.FEATURE_NO_TITLE);
                setContentView(R.layout.difficultypopup_activity);

                setContentView(R.layout.settingspopup);
                final Intent intent = new Intent(this, MusicService.class);
                String data = intent.getStringExtra("data");

                 music = (Switch) findViewById(R.id.switch2);
                 initial = (Button) findViewById(R.id.button10);



                music.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                            CheckState();
                    }
                });




    }

            private void CheckState() {
                if(music.isChecked()){
                    Intent intent = new Intent(getApplicationContext(),MusicService.class);
                    startService(intent);
                }else{
                    Intent intent = new Intent(getApplicationContext(),MusicService.class);
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
