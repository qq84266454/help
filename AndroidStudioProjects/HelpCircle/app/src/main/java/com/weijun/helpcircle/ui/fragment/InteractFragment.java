package com.weijun.helpcircle.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.weijun.helpcircle.R;
import com.weijun.helpcircle.adapter.help.InteractAdapter;
import com.weijun.helpcircle.pojo.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InteractFragment extends Fragment {

    public static final String TYPE = "type";
    private RecyclerView mRv;

    public InteractFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_interact, container, false);
        mRv = view.findViewById(R.id.mRv);
        initView();
        return view;
    }

    private void initView() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            int type = arguments.getInt("type");
            switch (type) {
                case 0:
                    // 助力过的人
                    break;
                case 1:
                    // 转发过的人
                    break;
            }
        }
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRv.setAdapter(new InteractAdapter(testData()));

    }

    private List<User> testData() {
        List<User> list = new ArrayList<>();
        list.add(new User("张三1"));
        list.add(new User("张三2"));
        list.add(new User("张三3"));
        return list;
    }

}
