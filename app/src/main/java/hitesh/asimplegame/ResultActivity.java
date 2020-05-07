package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static hitesh.asimplegame.QuestionDBOpenHelper.setRandomDB;


public class ResultActivity extends Activity {

    TextView textResult;
    Button btnYes;
    Button btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textResult = (TextView) findViewById(R.id.textResult);
        btnYes = (Button) findViewById(R.id.btn_yes1);
        btnNo = (Button) findViewById(R.id.btn_no1);

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");

        textResult.setText("Your score is " + " " + score + ". Play again??");

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), QuestionActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                if (QuestionActivity.difficulty.equals("Easy")) {
                    setRandomDB();
                    intent.putExtra("Difficulty", "Easy");
                    startActivity(intent);
                }

                if (QuestionActivity.difficulty.equals("Medium")) {
                    setRandomDB();
                    intent.putExtra("Difficulty", "Medium");
                    startActivity(intent);
                }

                if (QuestionActivity.difficulty.equals("Hard")) {
                    setRandomDB();
                    intent.putExtra("Difficulty", "Hard");
                    startActivity(intent);
                }
            }
        });


        btnNo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
    }

//	public void playagain(View o) {
//			setRandomDB();
//			Intent intent = new Intent(this, QuestionActivity.class);
//			intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//			startActivity(intent);
//	}

    private void startMainActivity() {
        setRandomDB();
        Intent intent = new Intent(this, MainPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}