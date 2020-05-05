package hitesh.asimplegame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainPage extends Activity {
    Button btnGame;
    Button btnMypage;
    Button btnSettings;
    Button btnRanking;
    Button btnSignIn;
    Button btnSignUp;

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

        @SuppressLint("WrongViewCast")
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainpage);

            btnGame = (Button) findViewById(R.id.btn_game);
            btnMypage = (Button) findViewById(R.id.btn_mypage);
            btnSettings = (Button) findViewById(R.id.btn_settings);
            btnRanking = (Button) findViewById(R.id.btn_ranking);
            btnSignUp = (Button) findViewById(R.id.btn_signup);
            btnSignIn = (Button) findViewById(R.id.btn_signin);

            btnSignUp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(getApplicationContext(), SignUpActivity.class));
                }
            });


            btnSignIn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(getApplicationContext(), GameDifficultyPopup.class));
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

                    startActivity(new Intent(getApplicationContext(), GameDifficultyPopup.class));
                }
            });

            btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), QuestionActivity.class));
            }
            });

        btnMypage.setOnClickListener(new View.OnClickListener() {
                @Override
        public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MyPage.class));
        }
        });


//        btnSettings.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(), Setting.class));
//            }
//        });

    }

    public void mOnPopupClick(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivityForResult(intent, 1);
    }
}
