package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import static hitesh.asimplegame.QuestionDBOpenHelper.setRandomDB;


public class GameDifficultyPopup extends Activity {

    Button btnEasy;
    Button btnMedium;
    Button btnHard;
    Button btnPractice;
    Button btnChallenge;
    Button btnClose;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        layoutParams.dimAmount = 0.7f;
        getWindow().setAttributes(layoutParams);

        setContentView(R.layout.difficultypopup_activity);

        btnEasy = (Button) findViewById(R.id.btn_easy);
        btnMedium = (Button) findViewById(R.id.btn_medium);
        btnHard = (Button) findViewById(R.id.btn_hard);
        btnPractice = (Button) findViewById(R.id.btn_practice);
        btnChallenge = (Button) findViewById(R.id.btn_challenge);
        btnClose = (Button) findViewById(R.id.btn_close);


        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomDB();
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Difficulty", "Easy");
                startActivity(intent);
            }
        });

        btnMedium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomDB();
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Difficulty", "Medium");
                startActivity(intent);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomDB();
                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Difficulty", "Hard");
                startActivity(intent);
            }
        });

        btnPractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomDB();
                Intent intent = new Intent(getApplicationContext(), PracticeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Difficulty", "Practice");
                startActivity(intent);
            }
        });

        btnChallenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomDB();
                Intent intent = new Intent(getApplicationContext(), ChallengeActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("Difficulty", "Challenge");
                startActivity(intent);
            }
        });


        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GameDifficultyPopup.super.onBackPressed();
            }
        });

    }

}
