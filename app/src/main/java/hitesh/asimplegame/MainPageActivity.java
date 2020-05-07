package hitesh.asimplegame;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
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

    SoundPool soundpool;
    int soundid;

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);

        soundpool = new SoundPool(5, AudioManager.STREAM_MUSIC,0);
        soundid = soundpool.load(this,R.raw.sound_button,1);


        if(FirebaseAuth.getInstance().getCurrentUser() == null) {
            startSignInActivity();
        }


        btnGame = (Button) findViewById(R.id.btn_game);
        btnMypage = (Button) findViewById(R.id.btn_mypage);
        btnSettings = (Button) findViewById(R.id.btn_settings);
        btnRanking = (Button) findViewById(R.id.btn_ranking);
        btnSignOut = (Button) findViewById(R.id.btn_signout);

        btnGame.setSoundEffectsEnabled(false);
        btnMypage.setSoundEffectsEnabled(false);
        btnRanking.setSoundEffectsEnabled(false);
        btnSignOut.setSoundEffectsEnabled(false);
        btnSettings.setSoundEffectsEnabled(false);


        btnSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(soundid,1f,1f,0,0,1f);
                FirebaseAuth.getInstance().signOut();
                startSignInActivity();
            }
        });



        btnGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(soundid,1f,1f,0,0,1f);
                startActivity(new Intent(getApplicationContext(), GameDifficultyPopup.class));
            }
        });

        btnSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(soundid,1f,1f,0,0,1f);
                startActivity(new Intent(getApplicationContext(), Setting.class));
            }
        });

        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(soundid,1f,1f,0,0,1f);
                startActivity(new Intent(getApplicationContext(), RankingActivity.class));
            }
        });

        btnMypage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                soundpool.play(soundid,1f,1f,0,0,1f);
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
