package cn.edu.cqu.caijimovie.activities;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.TextView;

import cn.edu.cqu.caijimovie.R;
import cn.edu.cqu.caijimovie.adapter.ViewPagerAdapter;
import cn.edu.cqu.caijimovie.fragments.MainHomeFragment;
import cn.edu.cqu.caijimovie.fragments.MainMeFragment;
import cn.edu.cqu.caijimovie.fragments.MainRecommendFragment;

public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView navigation;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPagerMain);
        navigation = findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        /*侧滑监听*/
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }


            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    navigation.getMenu().getItem(0).setChecked(false);
                }
                menuItem = navigation.getMenu().getItem(position);
                menuItem.setChecked(true);
            }


            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });


        setupViewPager(viewPager);
    }


    //Todo:底部导航栏切换代码
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_rercommend:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_me:
                    viewPager.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };


    //Todo:设置侧滑页面
    private void setupViewPager(ViewPager viewPager) {
        /*ViewPager适配器*/
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        /*构建适配器构建一个fragment列表，将三个Fragment添加进去，生成FragAdapter实例。*/
        adapter.addFragment(new MainHomeFragment());
        adapter.addFragment(new MainRecommendFragment());
        adapter.addFragment(new MainMeFragment());
        viewPager.setAdapter(adapter);
    }
}
