package cn.edu.cqu.caijimovie.adapter;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.entities.Movie;
import cn.edu.cqu.caijimovie.fragments.ItemMovieFragment;

public class MovieCardAdapter extends RecyclerView.Adapter<MovieCardAdapter.MoviewCardViewHolder> {


    private final Context context;
    private ArrayList<Movie> recommendList;
    private OnItemClickListener onItemClickListener;


    public MovieCardAdapter(Context context, ArrayList<Movie> recommendList) {
        this.context = context;
        this.recommendList = recommendList;
    }

    @NonNull
    @Override
    //相当于getView方法中创建view和viewHolder
    public MoviewCardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = View.inflate(context, R.layout.cardview_movie, null);
        return new MoviewCardViewHolder(itemView);
    }

    @Override
    //数据和View绑定
    public void onBindViewHolder(@NonNull MoviewCardViewHolder moviewCardViewHolder, int i) {
        //根据位置得到对应的数据
        Movie movie = recommendList.get(i);
//        MoviewCardViewHolder.textViewTitleYear.setText();
    }


    //得到总条数
    @Override
    public int getItemCount() {
        return recommendList.size();
    }

    class MoviewCardViewHolder extends RecyclerView.ViewHolder {
        private AppCompatImageView poster;
        private AppCompatTextView textViewTitleYear;

        public MoviewCardViewHolder(@NonNull View itemView) {
            super(itemView);
            poster = itemView.findViewById(R.id.card_movie_poster);
            textViewTitleYear = itemView.findViewById(R.id.card_movie_title_year);

            //设置点击回调事件
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onItemClickListener != null) {
                        onItemClickListener.onItemClick(v, recommendList.get(getLayoutPosition()));
                    }
                    //Toast.makeText(context,"data="+recommendList.get(getLayoutPosition()),Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    //点击RecyclerView某条的监听
    public interface OnItemClickListener {

        //当RecyclerView某个被点击的时候回调
        public void onItemClick(View view, Movie movie);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
