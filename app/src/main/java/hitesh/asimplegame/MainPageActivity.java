package hitesh.asimplegame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class MainPageActivity extends Activity {
    Button btnGame;
    Button btnMypage;
    Button btnSettings;
    Button btnRanking;
    Button btnSignOut;

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

        @SuppressLint("WrongViewCast")
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.mainpage);


            if(FirebaseAuth.getInstance().getCurrentUser() == null) {
                startSignInActivity();
            }


            btnGame = (Button) findViewById(R.id.btn_game);
            btnMypage = (Button) findViewById(R.id.btn_mypage);
            btnSettings = (Button) findViewById(R.id.btn_settings);
            btnRanking = (Button) findViewById(R.id.btn_ranking);
            btnSignOut = (Button) findViewById(R.id.btn_signout);

            btnSignOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();
                    startSignInActivity();
                }
            });

            btnGame.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(getApplicationContext(), GameDifficultyPopup.class));
                }
            });

            btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), RankingActivity.class));
            }
            });

        btnMypage.setOnClickListener(new View.OnClickListener() {
                @Override
        public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), MyPageActivity.class));
        }
        });

    }

    public void mOnPopupClick(View view) {
        Intent intent = new Intent(this, QuestionActivity.class);
        startActivityForResult(intent, 1);
    }

    private void startSignInActivity() {
        Intent intent = new Intent(this, SignInActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}
