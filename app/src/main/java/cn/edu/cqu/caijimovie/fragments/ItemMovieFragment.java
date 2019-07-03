package cn.edu.cqu.caijimovie.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.example.xlhratingbar_lib.XLHRatingBar;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.customize_widget.SimpleRatingView;
import cn.edu.cqu.caijimovie.item.Movie;
import cn.edu.cqu.caijimovie.utils.ThreadUtil;

//Todo:
@SuppressLint("ValidFragment")
public class ItemMovieFragment extends Fragment {

    private Movie movie;
    Context mContext;

    @SuppressLint("ValidFragment")
    public ItemMovieFragment(Movie movie) {
        super();
        this.movie = movie;

        initMovieInfo();
        initRateView();
        ThreadUtil.runInThread(new Runnable() {
            @Override
            public void run() {
                initPoster();
            }
        });
    }

    //Todo:加载海报
    private void initPoster() {
    }


    //Todo:加载Fragment电影信息
    public void initMovieInfo() {
        //Todo:加载电影名称（年份）
        TextView textViewTitleYear = getActivity().findViewById(R.id.item_movie_title_year);
        textViewTitleYear.setText(movie.getTitle() + "（" + movie.getShowtime() + "）");

        //Todo:加载电影评分信息
        String rate = String.valueOf(movie.getRate());
        String[] s1 = rate.split("\\.");
        TextView rateInt = getActivity().findViewById(R.id.ratingTextRatedInt);
        TextView rateDec = getActivity().findViewById(R.id.ratingTextRatedDec);
        rateInt.setText(s1[0] + ".");
        rateDec.setText(s1[1] + ".");
        //Todo:加载电影标签信息
        TextView textTag = getActivity().findViewById(R.id.tagText);
        textTag.setText(movie.getShowtime() + "/" + movie.getDistrict() + "/" + "movie.tags" + movie.getDirector() + "/" + movie.getActor());
        //Todo:加载电影片长
        TextView textDuration = getActivity().findViewById(R.id.durationText);
        textDuration.setText("片长：" + movie.getDuration() + "分钟");
    }

    //Todo:加载电影评星
    private void initRateView() {
        final XLHRatingBar xlhRatingBar_rated = getActivity().findViewById(R.id.ratingBarRated);
        xlhRatingBar_rated.setNumStars(5);
        xlhRatingBar_rated.setRating((float) ((movie.getRate() / 2) + 0.2));
        xlhRatingBar_rated.setRatingView(new SimpleRatingView());
//        xlhRatingBar_rated.setOnRatingChangeListener(new XLHRatingBar.OnRatingChangeListener() {
//            @Override
//            public void onChange(float rating, int numStars) {
//                Toast.makeText(getActivity(), "rating:" + rating, Toast.LENGTH_SHORT).show();
//            }
//        });
    }


    //Todo:加载关注按钮(ImageButton)

}
