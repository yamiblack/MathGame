package hitesh.asimplegame;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static hitesh.asimplegame.QuestionDBOpenHelper.setRandomDB;


public class ChallengeResultActivity extends Activity {

    TextView textResult;
    Button btnYes;
    Button btnNo;

    QuestionDBOpenHelper dbOpenHelper = new QuestionDBOpenHelper(this);
    SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        sqLiteDatabase = dbOpenHelper.getWritableDatabase();

        textResult = (TextView) findViewById(R.id.textResult);
        btnYes = (Button) findViewById(R.id.btn_yes1);
        btnNo = (Button) findViewById(R.id.btn_no1);

        Bundle b = getIntent().getExtras();
        int challengeScore = b.getInt("score");
        textResult.setText("Your challenge score is " + challengeScore + ". Play again??");

        ContentValues values = new ContentValues();
        values.put(dbOpenHelper.getKeyChallengescore(), challengeScore);
        sqLiteDatabase.insert(dbOpenHelper.getTableRankinginformation(),null,values);


        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), ChallengeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                    setRandomDB();
                    intent.putExtra("Difficulty", "Challenge");
                    startActivity(intent);



            }
        });


        btnNo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startMainActivity();
            }
        });
    }

    private void startMainActivity() {
        setRandomDB();
        Intent intent = new Intent(this, MainPageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
}