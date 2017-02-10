package com.lzh.wechat.fragment;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lzh.wechat.R;
import com.lzh.wechat.view.IndexBar;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by laizuhong on 2017/2/10.
 */

public class ContactsFragment extends BaseFragment {
    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;
    @Bind(R.id.index_bar)
    IndexBar indexBar;
    @Bind(R.id.tag)
    TextView tag;

    String[] tags=new String[]{"↑", "☆", "A", "B", "C", "D",
            "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
            "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

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
            }
        });
    }
}
