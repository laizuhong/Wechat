package com.lzh.wechat.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lzh.wechat.R;
import com.lzh.wechat.adapter.ContactsAdapter;
import com.lzh.wechat.view.IndexBar;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.friend.FriendService;
import com.netease.nimlib.sdk.friend.model.Friend;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 *
 * Created by laizuhong on 2017/2/10.
 */

public class ContactsFragment extends BaseFragment {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.index_bar)
    IndexBar indexBar;
    @Bind(R.id.tag)
    TextView tag;

    ContactsAdapter adapter;
    List<Friend> friends=new ArrayList<>();


    @Override
    public View initView(LayoutInflater inflater) {
        return inflater.inflate(R.layout.fragment_contacts, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    public void bindView() {
        super.bindView();
        indexBar.setListener(new IndexBar.OnClickUpdateListener() {
            @Override
            public void onLetterUpdate(String letter) {
                tag.setVisibility(View.VISIBLE);
                tag.setText(letter);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tag.setVisibility(View.GONE);
                    }
                },500);
            }
        });

        adapter=new ContactsAdapter(context,friends);
        View headView=LayoutInflater.from(context).inflate(R.layout.headview_contact,null);
        adapter.addHeaderView(headView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
        recyclerView.setAdapter(adapter);
        getFriend();
    }


    private void getFriend(){
        List<Friend> item= NIMClient.getService(FriendService.class).getFriends();
        if (friends!=null&&friends.size()!=0){
            friends.addAll(item);
            adapter.notifyDataChangedAfterLoadMore(false);
        }
    }
}
