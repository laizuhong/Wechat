package com.lzh.wechat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzh.wechat.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *
 * Created by laizuhong on 2017/2/10.
 */

public class MineFragment extends BaseFragment {


    @Bind(R.id.user_head)
    ImageView userHead;
    @Bind(R.id.nick_name)
    TextView nickName;
    @Bind(R.id.wx_number)
    TextView wxNumber;
    @Bind(R.id.user_layout)
    LinearLayout userLayout;
    @Bind(R.id.photo_layout)
    LinearLayout photoLayout;
    @Bind(R.id.sellect_layout)
    LinearLayout sellectLayout;
    @Bind(R.id.wallet_layout)
    LinearLayout walletLayout;
    @Bind(R.id._card_layout)
    LinearLayout CardLayout;
    @Bind(R.id.emo_layout)
    LinearLayout emoLayout;
    @Bind(R.id.setting_layout)
    LinearLayout settingLayout;

    @Override
    public View initView(LayoutInflater inflater) {

        return inflater.inflate(R.layout.fragment_mine, null);
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

    }

    @OnClick({R.id.user_head, R.id.user_layout, R.id.photo_layout, R.id.sellect_layout, R.id.wallet_layout, R.id._card_layout, R.id.emo_layout, R.id.setting_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.user_head:
                break;
            case R.id.user_layout:
                break;
            case R.id.photo_layout:
                break;
            case R.id.sellect_layout:
                break;
            case R.id.wallet_layout:
                break;
            case R.id._card_layout:
                break;
            case R.id.emo_layout:
                break;
            case R.id.setting_layout:
                break;
        }
    }
}
