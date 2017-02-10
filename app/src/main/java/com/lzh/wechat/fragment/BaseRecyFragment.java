package com.lzh.wechat.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;

import com.lzh.wechat.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 * Created by laizuhong on 2015/11/19.
 */
public class BaseRecyFragment extends BaseFragment {

    View footview;
    View rootView;
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.swiperefreshlayout)
    SwipeRefreshLayout swipeRefreshLayout;


    @Override
    public View initView(LayoutInflater inflater) {
        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_base_recy, null);
            ButterKnife.bind(this, rootView);
            init();
        }
        return rootView;
    }

    public void init() {


        footview = LayoutInflater.from(context)
                .inflate(R.layout.xlistview_footer, null);

        swipeRefreshLayout.setColorSchemeResources(R.color.holo_blue_bright,
                R.color.holo_green_light,
                R.color.holo_orange_light,
                R.color.holo_red_light);
        // 设置下拉刷新监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                update();
            }
        });

    }


    public void update() {

    }


}
