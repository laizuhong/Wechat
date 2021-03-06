package com.lzh.wechat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.blankj.utilcode.utils.SizeUtils;
import com.luseen.luseenbottomnavigation.BottomNavigation.BottomNavigationView;
import com.lzh.wechat.fragment.ContactsFragment;
import com.lzh.wechat.fragment.DiscoveryFragment;
import com.lzh.wechat.fragment.MessageFragment;
import com.lzh.wechat.fragment.MineFragment;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.bar)
    BottomNavigationView bar;
    @Bind(R.id.content_main)
    RelativeLayout contentMain;
    @Bind(R.id.viewPager)
    ViewPager viewPager;
    @Bind(R.id.doc)
    TextView doc;

    PopupWindow popupWindow;
    boolean isShow=true;

    List<Fragment> fragments;
    String[] title=new String[]{"消息","通讯录","发现","我"};

    String[] menu=new String[]{"发起群聊","添加好友","扫一扫","收付款","帮助与反馈"};
    int[] res=new int[]{R.drawable.ic_create_group_cheat,R.drawable.ic_add_friend
            ,R.drawable.ic_scan_white,R.drawable.ic_payment_received
            ,R.drawable.ic_help_feedback};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        BottomNavigationItem item1=new BottomNavigationItem("消息", ContextCompat.getColor(this,R.color.white),R.drawable.message_normal);
//        BottomNavigationItem item2=new BottomNavigationItem("通讯录", ContextCompat.getColor(this,R.color.white),R.drawable.contacts_normal);
//        BottomNavigationItem item3=new BottomNavigationItem("发现", ContextCompat.getColor(this,R.color.white),R.drawable.discovery_normal);
//        BottomNavigationItem item4=new BottomNavigationItem("我", ContextCompat.getColor(this,R.color.white),R.drawable.me_normal);
//
//        bar.addTab(item1);
//        bar.addTab(item2);
//        bar.addTab(item3);
//        bar.addTab(item4);
        bar.isColoredBackground(false);
        bar.setItemActiveColorWithoutColoredBackground(ContextCompat.getColor(this,R.color.green0));

        fragments=new ArrayList<>();
        fragments.add(new MessageFragment());
        fragments.add(new ContactsFragment());
        fragments.add(new DiscoveryFragment());
        fragments.add(new MineFragment());
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        bar.setUpWithViewPager(viewPager,new int[]{R.color.white,R.color.white,R.color.white,R.color.white},
                new int[]{R.drawable.message_normal,R.drawable.contacts_normal,R.drawable.discovery_normal,R.drawable.me_normal});

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        initPopMenu();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.search:
                break;
            case R.id.other:
                if (popupWindow!=null)
                    if (!popupWindow.isShowing()){
                        popupWindow.showAtLocation(viewPager, Gravity.TOP|Gravity.END, SizeUtils.dp2px(this,12),toolbar.getHeight()+getStatusBarHeight());
                    }else {
                        popupWindow.dismiss();
                    }
                break;
        }

        return true;
    }

    /**
     * 获取状态栏的高度
     *
     * @return
     */
    public int getStatusBarHeight() {
        try {
            Class<?> c = Class.forName("com.android.internal.R$dimen");
            Object obj = c.newInstance();
            Field field = c.getField("status_bar_height");
            int x = Integer.parseInt(field.get(obj).toString());
            return getResources().getDimensionPixelSize(x);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    class MyPagerAdapter extends FragmentPagerAdapter{

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return title[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }


    private void initPopMenu(){
        popupWindow=new PopupWindow(this);
        View contentView=View.inflate(this,R.layout.pop_menu,null);
        popupWindow.setContentView(contentView);
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
//        popupWindow.setTouchable(true);

        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {

            }
        });
        contentView.findViewById(R.id.create).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        contentView.findViewById(R.id.add_friend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        contentView.findViewById(R.id.scan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        contentView.findViewById(R.id.payment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        contentView.findViewById(R.id.help).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }


//    class MenuAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return res.length;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return menu[position];
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            convertView= View.inflate(MainActivity.this,R.layout.item_list_pop,null);
//            ImageView imageView= (ImageView) convertView.findViewById(R.id.img);
//            TextView textView= (TextView) convertView.findViewById(R.id.text);
//            imageView.setBackgroundResource(res[position]);
//            textView.setText(menu[position]);
//            return convertView;
//        }
//    }
}
