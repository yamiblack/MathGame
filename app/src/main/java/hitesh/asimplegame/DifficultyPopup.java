package hitesh.asimplegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

class DifficultyPopup extends AppCompatActivity {

    Button btnEasy;
    Button btnMedium;
    Button btnHard;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.difficultypopup_activity);

        btnEasy = (Button) findViewById(R.id.btn_easy);
        btnMedium = (Button) findViewById(R.id.btn_medium);
        btnHard = (Button) findViewById(R.id.btn_hard);

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(), QuestionActivity.class);
                startActivity(intent1);
            }
        });




    }
}
