package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RankingActivity extends Activity {

    ListView lvRanking;
    Button btnBackToMainpage;
    List<RankingInformation> rankingInformationsList;
    QuestionDBOpenHelper dbOpenHelper = new QuestionDBOpenHelper(this);
    RankingAdapter rankingAdapter;
    int maxRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);


        lvRanking = (ListView) findViewById(R.id.lv_ranking);
        btnBackToMainpage = (Button) findViewById(R.id.btn_backToMainpage);

        rankingInformationsList = dbOpenHelper.getChallengeRanking();
        rankingAdapter =new RankingAdapter(this, (ArrayList<RankingInformation>) rankingInformationsList);
        lvRanking.setAdapter(rankingAdapter);

        maxRanking = rankingInformationsList.size();

        if(maxRanking > 5) {
            maxRanking = 5;
        }

        btnBackToMainpage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RankingActivity.this, MainPageActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}
