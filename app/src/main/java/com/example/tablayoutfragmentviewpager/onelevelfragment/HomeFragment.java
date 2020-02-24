package com.example.tablayoutfragmentviewpager.onelevelfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tablayoutfragmentviewpager.BaseTabFragmentPagerAdapter;
import com.example.tablayoutfragmentviewpager.R;
import com.example.tablayoutfragmentviewpager.twolevelfragment.KojimaFragment;
import com.example.tablayoutfragmentviewpager.twolevelfragment.MakeListFragment;
import com.example.tablayoutfragmentviewpager.twolevelfragment.RecommendFragment;
import com.example.tablayoutfragmentviewpager.twolevelfragment.SerialFragment;
import com.example.tablayoutfragmentviewpager.twolevelfragment.ThematicFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yds
 * on 2020/2/24.
 */
public class HomeFragment extends Fragment {
    private TabLayout mTabLayout;
    private List<Fragment> mFragmentList;
    private FragmentPagerAdapter mAdapter;
    private ViewPager mViewPager;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_module_fragment_home,container,false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTabLayout = view.findViewById(R.id.tab_layout);
        mViewPager = view.findViewById(R.id.viewpager);

        mTabLayout.addTab(mTabLayout.newTab().setText("打榜"));
        mTabLayout.addTab(mTabLayout.newTab().setText("推荐"));
        mTabLayout.addTab(mTabLayout.newTab().setText("小岛"));
        mTabLayout.addTab(mTabLayout.newTab().setText("专题"));
        mTabLayout.addTab(mTabLayout.newTab().setText("连载"));

        mFragmentList = new ArrayList<>(5);
        mFragmentList.add(new MakeListFragment());
        mFragmentList.add(new RecommendFragment());
        mFragmentList.add(new KojimaFragment());
        mFragmentList.add(new ThematicFragment());
        mFragmentList.add(new SerialFragment());

        mAdapter = new BaseTabFragmentPagerAdapter(getChildFragmentManager(),mFragmentList);
        mViewPager.setAdapter(mAdapter);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
        mTabLayout.setOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }
}
