package hitesh.asimplegame;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

public class RankingActivity extends Activity {

    ListView lvRanking;
    Button btnBackToMainpage;
    private List<RankingInformation> rankingInformationsList;
    QuestionDBOpenHelper dbOpenHelper = new QuestionDBOpenHelper(this);
    RankingAdapter rankingAdapter;
    private int maxRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        rankingAdapter = new RankingAdapter();
        lvRanking = (ListView) findViewById(R.id.lv_ranking);
        lvRanking.setAdapter(rankingAdapter);

        btnBackToMainpage = (Button) findViewById(R.id.btn_backToMainpage);

//        rankingInformationsList = dbOpenHelper.getChallengeRanking();
//        rankingAdapter =new RankingAdapter(this, (ArrayList<RankingInformation>) rankingInformationsList);
//        lvRanking.setAdapter(rankingAdapter);

        rankingInformationsList = dbOpenHelper.getChallengeRanking();

        maxRanking = rankingInformationsList.size();

        if (maxRanking > 5) {
            maxRanking = 5;
        }

        for (int i = 0; i < maxRanking; i++) {
            RankingInformation rankingInformation = rankingInformationsList.get(i);
            rankingAdapter.addRanking(i + 1, rankingInformation.getChallengeScore());
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
