package hitesh.asimplegame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RankingAdapter extends BaseAdapter {

    ArrayList<RankingInformation> rankingInformationList = new ArrayList<RankingInformation>();

    TextView tvRanking;
    TextView tvChallengeScore;

    public RankingAdapter() {

    }

    @Override
    public int getCount() {
        return rankingInformationList.size();
    }

    @Override
    public Object getItem(int position) {
        return rankingInformationList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.ranking_list, parent, false);
        }

        tvRanking = (TextView)convertView.findViewById(R.id.tv_ranking);
        tvChallengeScore = (TextView)convertView.findViewById(R.id.tv_challengeScore);

        RankingInformation rankingItem = rankingInformationList.get(position);

        tvRanking.setText("Ranking : " + String.valueOf(rankingItem.getRanking()));
        tvChallengeScore.setText("Score : " + String.valueOf(rankingItem.getChallengeScore()));

        return convertView;
    }

    public void addRanking(int ranking, int score) {
        RankingInformation newRanking = new RankingInformation();
        newRanking.setChallengeScore(score);
        newRanking.setRanking(ranking);
        rankingInformationList.add(newRanking);
    }
}
