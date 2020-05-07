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

    int bestScore;
    int sum = 0;
    int average=1;


    @Override
    protected void onCreate(Bundle savedinstancState) {
        super.onCreate(savedinstancState);
        setContentView(R.layout.activity_mypage);

        rankingAdapter = new RankingAdapter();

        tvBestScore = (TextView) findViewById(R.id.tv_bestScore);
        tvAverageScore = (TextView) findViewById(R.id.tv_averageScore);

        rankingInformationsList = dbOpenHelper.getChallengeRanking();

        if(rankingInformationsList.isEmpty()) {
            bestScore = 0;
            average = 0;
        }
        else {
            bestScore = rankingInformationsList.get(0).getChallengeScore();

            for (int i = 0; i < rankingInformationsList.size(); i++) {
                RankingInformation rankingInformation = rankingInformationsList.get(i);
                sum += rankingInformation.getChallengeScore();
            }
            average = sum / rankingInformationsList.size();
        }

        tvBestScore.setText(String.valueOf(bestScore));
        tvAverageScore.setText(String.valueOf(average));

    }

}
