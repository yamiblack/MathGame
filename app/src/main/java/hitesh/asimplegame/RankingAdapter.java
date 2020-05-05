package hitesh.asimplegame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.RankingViewHolder> {


    private ArrayList<RankingInformation> arrayList;
    private Context context;


    public RankingAdapter(ArrayList<RankingInformation> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public RankingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_ranking, parent, false);
        RankingViewHolder holder = new RankingViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RankingViewHolder holder, int position) {
        holder.tvDifficulty.setText(arrayList.get(position).getDifficulty());
        holder.tvRanking.setText(String.valueOf(arrayList.get(position).getRanking()));
        holder.tvEmail.setText(arrayList.get(position).getEmail());
        holder.tvScore.setText(String.valueOf(arrayList.get(position).getScore()));

    }

    @Override
    public int getItemCount() {


        return (arrayList != null ? arrayList.size() : 0);
    }

    public class RankingViewHolder extends RecyclerView.ViewHolder {

        TextView tvDifficulty;
        TextView tvRanking;
        TextView tvEmail;
        TextView tvScore;


        public RankingViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvDifficulty = itemView.findViewById(R.id.tv_difficulty);
            this.tvRanking = itemView.findViewById(R.id.tv_ranking);
            this.tvEmail = itemView.findViewById(R.id.tv_email);
            this.tvScore = itemView.findViewById(R.id.tv_score);

        }
    }
}
