package com.example.tablayoutfragmentviewpager;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tablayoutfragmentviewpager.onelevelfragment.AttentionFragment;
import com.example.tablayoutfragmentviewpager.onelevelfragment.HomeFragment;
import com.example.tablayoutfragmentviewpager.onelevelfragment.JevelFragment;
import com.example.tablayoutfragmentviewpager.onelevelfragment.MeFragment;
import com.example.tablayoutfragmentviewpager.onelevelfragment.NotificationFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout mBottomTabLayout;
    private ViewPager mBottomViewPager;

    private List<Fragment> mFragmentList;
    private FragmentPagerAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initEvent();
    }

    private void initEvent() {
        mBottomTabLayout = findViewById(R.id.main_bottom_tabLayout);
        mBottomViewPager = findViewById(R.id.bottom_tab_viewpager);
        //"首页", "关注", "简书钻", "消息", "我的"
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setText("首页"));
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setText("关注"));
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setText("简书钻"));
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setText("消息"));
        mBottomTabLayout.addTab(mBottomTabLayout.newTab().setText("我的"));

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new HomeFragment());
        mFragmentList.add(new AttentionFragment());
        mFragmentList.add(new JevelFragment());
        mFragmentList.add(new NotificationFragment());
        mFragmentList.add(new MeFragment());

        mAdapter = new BaseTabFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mBottomViewPager.setAdapter(mAdapter);
        mBottomViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mBottomTabLayout));
        mBottomTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mBottomViewPager));
    }
}
