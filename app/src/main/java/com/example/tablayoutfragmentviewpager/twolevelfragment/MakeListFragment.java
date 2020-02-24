package com.example.tablayoutfragmentviewpager.twolevelfragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.example.tablayoutfragmentviewpager.DividerItemDecoration;
import com.example.tablayoutfragmentviewpager.R;
import com.example.tablayoutfragmentviewpager.TestAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yds
 * on 2020/2/18.
 */
public class MakeListFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private TestAdapter mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_module_fragment_make_list,container,false);
        mRecyclerView = view.findViewById(R.id.recyclerview);
        initAdapter();
        return view;
    }

    private void initAdapter(){
        mRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL_LIST));;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add(i);
        }
        mAdapter = new TestAdapter(list,getActivity());
        mRecyclerView.setAdapter(mAdapter);

    }
}
