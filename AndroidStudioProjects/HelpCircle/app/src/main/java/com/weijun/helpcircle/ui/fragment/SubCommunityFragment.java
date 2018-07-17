package com.weijun.helpcircle.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.community.SubCommunityAdapter;
import com.weijun.helpcircle.pojo.Community;
import com.weijun.helpcircle.ui.CommunityActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubCommunityFragment extends Fragment {


    private View view;
    private RecyclerView mRv;
    private SubCommunityAdapter adapter;

    public SubCommunityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sub_community, container, false);
        initView();
        return view;
    }

    private void initView() {
        mRv = view.findViewById(R.id.mRv);
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        List<Community> communities = new ArrayList<>();
        communities.add(new Community(null, null, null, 1000l, "", "雷锋社区"));
        communities.add(new Community(null, null, null, 1000l, "", "雷锋社区"));
        communities.add(new Community(null, null, null, 1000l, "", "雷锋社区"));
        adapter = new SubCommunityAdapter(communities);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), CommunityActivity.class));
            }
        });
        mRv.setAdapter(adapter);

    }

}
