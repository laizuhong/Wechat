package com.lzh.wechat.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lzh.texticonview.TextIconView;
import com.lzh.wechat.R;
import com.lzh.wechat.util.ShareUtils;
import com.netease.nimlib.sdk.NIMClient;
import com.netease.nimlib.sdk.uinfo.UserService;
import com.netease.nimlib.sdk.uinfo.model.NimUserInfo;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
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
    TextIconView photoLayout;
    @Bind(R.id.sellection_layout)
    TextIconView sellectionLayout;
    @Bind(R.id.wallet_layout)
    TextIconView walletLayout;
    @Bind(R.id.card_layout)
    TextIconView cardLayout;
    @Bind(R.id.emo_layout)
    TextIconView emoLayout;
    @Bind(R.id.setting_layout)
    TextIconView settingLayout;

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
        getUserInfo();
    }


    private void getUserInfo() {
        NimUserInfo userInfo = NIMClient.getService(UserService.class).getUserInfo(ShareUtils.getStringXml("username"));

    }

    @OnClick({R.id.wx_number, R.id.user_layout, R.id.photo_layout, R.id.sellection_layout, R.id.wallet_layout, R.id.card_layout, R.id.emo_layout, R.id.setting_layout})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.wx_number:
                break;
            case R.id.user_layout:
                break;
            case R.id.photo_layout:
                break;
            case R.id.sellection_layout:
                break;
            case R.id.wallet_layout:
                break;
            case R.id.card_layout:
                break;
            case R.id.emo_layout:
                break;
            case R.id.setting_layout:
                break;
        }
    }
}
