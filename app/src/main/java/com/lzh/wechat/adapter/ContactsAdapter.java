package com.lzh.wechat.adapter;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.lzh.wechat.R;
import com.lzh.wechat.util.MyLog;
import com.netease.nimlib.sdk.friend.model.Friend;

import java.util.List;

/**
 *
 * Created by laizuhong on 2017/2/13.
 */

public class ContactsAdapter extends BaseQuickAdapter<Friend>{


    public ContactsAdapter(Context context, List<Friend> data) {
        super(context, R.layout.item_friend, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Friend friend) {
        if (friend.getAlias()!=null){
            baseViewHolder.setText(R.id.name,friend.getAlias());
        }else {
            baseViewHolder.setText(R.id.name,friend.getAccount());
        }

        if (friend.getExtension()!=null) {

            MyLog.e(friend.getExtension().toString());
//        ImageLoader.getInstance().displayImage(friend.getExtension().get("userhead"),(ImageView) baseViewHolder.getView(R.id.head), MyApp.options);
        }
    }
}
