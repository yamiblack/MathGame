package hitesh.asimplegame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class RankingAdapter extends BaseAdapter {

    ArrayList<RankingInformation> rankingList = new ArrayList<RankingInformation>();


    private LayoutInflater inflater=null;

    TextView tvRanking;
    TextView tvEmail;
    TextView tvChallengeScore;

    Context context=null;

    public RankingAdapter(Context context, ArrayList<RankingInformation> rankingList) {
        this.context= context;
        this.rankingList = rankingList;
        inflater=LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return rankingList.size();
    }

    @Override
    public Object getItem(int position) {
        return rankingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

//        if (convertView == null) {
//            convertView = inflater.inflate(layout, parent, false);
//        }

        View view= inflater.inflate(R.layout.ranking_list, null);

        tvRanking = (TextView)view.findViewById(R.id.tv_ranking);
        tvEmail = (TextView)view.findViewById(R.id.tv_email);
        tvChallengeScore = (TextView)view.findViewById(R.id.tv_challengeScore);

        tvRanking.setText(String.valueOf((rankingList.get(position).getRanking())));
        tvEmail.setText(rankingList.get(position).getPlayer());
        tvChallengeScore.setText("Score : " + String.valueOf(rankingList.get(position).getChallengeScore()));


//        RankingInformation rankingInformation = rankingList.get(position);
//
//        tvRanking = (TextView) convertView.findViewById(R.id.tv_ranking);
//        tvEmail = (TextView) convertView.findViewById(R.id.tv_email);
//        tvChallengeScore = (TextView) convertView.findViewById((R.id.tv_challengeScore));
//


        return view;
    }
}
