package com.lzh.wechat.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 *
 * Created by laizuhong on 2017/2/10.
 */

public abstract class BaseFragment extends Fragment{

    Context context;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context=getActivity();
        return initView(inflater);
    }


    public abstract View initView(LayoutInflater inflater);

    @Override
    public void onResume() {
        super.onResume();
        bindView();
    }

    public void bindView(){

    }
}
