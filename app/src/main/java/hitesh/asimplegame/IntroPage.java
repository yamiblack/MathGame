package hitesh.asimplegame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IntroPage extends Activity {
    Button Game_b;
    Button Mypage_b;
    Button Settings_b;
    Button Rank_b;
    Button login_b;

//    public boolean onCreateOptionsMenu(Menu menu){
//        getMenuInflater().inflate(R.menu.menu_main);
//        return true;
//    }

        @SuppressLint("WrongViewCast")
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.intropage);

            Game_b = (Button) findViewById(R.id.button4);
            Mypage_b = (Button) findViewById(R.id.button5);
            Settings_b = (Button) findViewById(R.id.button6);
            Rank_b = (Button) findViewById(R.id.button);
            login_b = (Button) findViewById(R.id.imageButton2);             //이미지버튼?


            login_b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //화면전환할 클래스명을 입력한다.
                    Intent intent1 = new Intent(getApplicationContext(),DifficultyPopup.class);
                    startActivity(intent1);
                }
            });

            Game_b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //화면전환할 클래스명을 입력한다.
                    Intent intent1 = new Intent(getApplicationContext(),DifficultyPopup.class);
                    startActivity(intent1);
                }
            });

            Rank_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환할 클래스명을 입력한다.
                Intent intent1 = new Intent(getApplicationContext(),DifficultyPopup.class);
                startActivity(intent1);
            }
            });

        Mypage_b.setOnClickListener(new View.OnClickListener() {
                @Override
        public void onClick(View view) {
            //화면전환할 클래스명을 입력한다.
            Intent intent1 = new Intent(getApplicationContext(),MyPage.class);
            startActivity(intent1);
        }
        });


        Settings_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환할 클래스명을 입력한다.
                Intent intent1 = new Intent(getApplicationContext(),Setting.class);
                startActivity(intent1);
            }
        });

    }

    public void mOnPopupClick(View view) {
        Intent intent = new Intent(this,DifficultyPopup.class);
        startActivityForResult(intent, 1);
    }
}
