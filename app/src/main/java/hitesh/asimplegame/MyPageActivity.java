package hitesh.asimplegame;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

public class MyPageActivity extends Activity {
    TextView tvBestScore;
    TextView tvAverageScore;

    private List<RankingInformation> rankingInformationsList;
    RankingAdapter rankingAdapter;

    QuestionDBOpenHelper dbOpenHelper = new QuestionDBOpenHelper(this);

    int sum = 0;
    int average;


    @Override
    protected void onCreate(Bundle savedinstancState) {
        super.onCreate(savedinstancState);
        setContentView(R.layout.activity_mypage);

        rankingAdapter = new RankingAdapter();

        tvBestScore = (TextView) findViewById(R.id.tv_bestScore);
        tvAverageScore = (TextView) findViewById(R.id.tv_averageScore);

        rankingInformationsList = dbOpenHelper.getChallengeRanking();

        tvBestScore.setText(String.valueOf(rankingInformationsList.get(0).getChallengeScore()));

        for (int i = 0; i < rankingInformationsList.size(); i++) {
            RankingInformation rankingInformation = rankingInformationsList.get(i);
            sum += rankingInformation.getChallengeScore();
        }

        average = sum / rankingInformationsList.size();

        tvAverageScore.setText(String.valueOf(average));

    }

}
