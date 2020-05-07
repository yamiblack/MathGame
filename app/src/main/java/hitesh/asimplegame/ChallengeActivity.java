package hitesh.asimplegame;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static hitesh.asimplegame.QuestionDBOpenHelper.setRandomDB;


public class ChallengeActivity extends Activity {
    private static final String TAG = ChallengeActivity.class.getSimpleName();

    private List<Question> questionList;

    private List<RankingInformation> rankingInformationList;

    private int challengeScore = 0;
    private int questionID = 0;

    private int life = 2;
    private int showLife = life + 1;

    private Question currentQ;
    private TextView txtQuestion, times, scored, txtLife;
    private Button button1, button2, button3, btnRestart;

    public static String difficulty;

    final CounterClass timer = new CounterClass(60000, 1000);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent intent = getIntent();
        final String setDifficulty = intent.getExtras().getString("Difficulty");
        QuestionDBOpenHelper db = new QuestionDBOpenHelper(this);
//        Bundle b = getIntent().getExtras();
//        email = b.getString("email");

        if (setDifficulty.equals("Challenge")) {
            difficulty = "Challenge";
            questionList = db.getAllChallengeQuestions();
        }

        currentQ = questionList.get(questionID);

        txtQuestion = (TextView) findViewById(R.id.txtQuestion);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        btnRestart = (Button) findViewById(R.id.btn_restart);

        scored = (TextView) findViewById(R.id.score);
        txtLife = (TextView) findViewById(R.id.btn_life);
        times = (TextView) findViewById(R.id.timers);

        setQuestionView();

//        final CounterClass timer = new CounterClass(60000, 1000);
        timer.start();


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button1.getText().toString());

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button2.getText().toString());

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getAnswer(button3.getText().toString());

            }
        });

        btnRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (setDifficulty.equals("Challenge")) {
                    timer.cancel();
                    setRandomDB();
                    Intent intent = new Intent(getApplicationContext(), ChallengeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                    Bundle b = new Bundle();
//                    b.putString("email", email);
//                    intent.putExtras(b);
                    intent.putExtra("Difficulty", "Challenge");
                    startActivity(intent);
                }
            }
        });


    }

    public void getAnswer(String AnswerString) {

        if (currentQ.getANSWER().equals(AnswerString)) {

            // if conditions matches increase the int (score) by 1
            // and set the text of the score view
            challengeScore++;
            scored.setText("Score : " + challengeScore);

        } else {

            if (life == 0) {
                Intent intent = new Intent(ChallengeActivity.this, ChallengeResultActivity.class);

                // passing the int value
                Bundle b = new Bundle();
//                b.putInt("id",1);
                b.putInt("score", challengeScore); // Your score
//                b.putString("email", email);
                intent.putExtras(b); // Put your score to your next
                startActivity(intent);
                finish();
                timer.cancel();
            } else {
                life--;
                showLife--;
                txtLife.setText("Life : " + showLife);
            }
        }


        if (questionID < 999) {
            // if questions are not over then do this
            currentQ = questionList.get(questionID);
            setQuestionView();
        } else {

            // if over do this
            Intent intent = new Intent(ChallengeActivity.this, ChallengeResultActivity.class);
            Bundle b = new Bundle();
            b.putInt("score", challengeScore); // Your score
//            b.putString("email", email);
            intent.putExtras(b); // Put your score to your next
            startActivity(intent);
            finish();
        }

    }


    @TargetApi(Build.VERSION_CODES.GINGERBREAD)
    @SuppressLint("NewApi")
    public class CounterClass extends CountDownTimer {
        public CounterClass(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {

            times.setText("Time is up");



            Intent intent = new Intent(ChallengeActivity.this, ChallengeResultActivity.class);

            Bundle b = new Bundle();
//            b.putInt("id",1);
//            b.putString("email", email);
            b.putInt("score", challengeScore);
            intent.putExtras(b);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            finish();

        }

        @Override
        public void onTick(long millisUntilFinished) {
            long millis = millisUntilFinished;
            String hms = String.format("%02d:%02d:%02d",
                    TimeUnit.MILLISECONDS.toHours(millis),
                    TimeUnit.MILLISECONDS.toMinutes(millis)
                            - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS
                            .toHours(millis)),
                    TimeUnit.MILLISECONDS.toSeconds(millis)
                            - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS
                            .toMinutes(millis)));

            Log.d(TAG, "current time: " + hms);
            times.setText(hms);
        }

    }

    private void setQuestionView() {
        // the method which will put all things together
        txtQuestion.setText(currentQ.getQUESTION());
        button1.setText(currentQ.getOPTA());
        button2.setText(currentQ.getOPTB());
        button3.setText(currentQ.getOPTC());

        questionID++;
    }


}
