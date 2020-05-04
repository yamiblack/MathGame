package hitesh.asimplegame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.service.notification.NotificationListenerService;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class IntroPage extends Activity {
    Button btnGame;
    Button btnMypage;
    Button btnSettings;
    Button btnRanking;
    ImageButton btnSignin;

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

        @SuppressLint("WrongViewCast")
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.intropage);

            btnGame = (Button) findViewById(R.id.btn_game);
            btnMypage = (Button) findViewById(R.id.btn_mypage);
            btnSettings = (Button) findViewById(R.id.btn_settings);
            btnRanking = (Button) findViewById(R.id.btn_ranking);
            btnSignin = (ImageButton) findViewById(R.id.btn_signin);             //이미지버튼?


            btnSignin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //화면전환할 클래스명을 입력한다.
                    Intent intent1 = new Intent(getApplicationContext(),QuestionActivity.class);
                    startActivity(intent1);
                }
            });



//            btn_game.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    AlertDialog.Builder builder = new AlertDialog.Builder((IntroPage.this));
//                    builder.setTitle("Select Difficulty");
//
//
//                    builder.setNeutralButton("Easy", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialogInterface, int i) {
//                            Intent intent1 = new Intent(getApplicationContext(), QuestionActivity.class);
//                        }
//                    });
//
//                    AlertDialog alertDialog = builder.create();
//                    alertDialog.show();
//                }
//            });

            btnGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //화면전환할 클래스명을 입력한다.

                    Intent intent1 = new Intent(getApplicationContext(),DifficultyPopup.class);
                    startActivity(intent1);
                }
            });

            btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환할 클래스명을 입력한다.
                Intent intent1 = new Intent(getApplicationContext(), DifficultyPopup.class);
                startActivity(intent1);
            }
            });

        btnMypage.setOnClickListener(new View.OnClickListener() {
                @Override
        public void onClick(View view) {
            //화면전환할 클래스명을 입력한다.
            Intent intent1 = new Intent(getApplicationContext(),MyPage.class);
            startActivity(intent1);
        }
        });


        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //화면전환할 클래스명을 입력한다.
                Intent intent1 = new Intent(getApplicationContext(),Setting.class);
                startActivity(intent1);
            }
        });

    }

    public void mOnPopupClick(View view) {
        Intent intent = new Intent(this,QuestionActivity.class);
        startActivityForResult(intent, 1);
    }
}
