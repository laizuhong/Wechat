package com.lzh.wechat.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.lzh.wechat.R;

/**
 * 首字母导航
 * Created by laizuhong on 2017/2/10.
 */

public class IndexBar extends View{
    private float mTextSize = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, 14, getResources().getDisplayMetrics());

    Context context;
    Paint paint;
    int itemWidth,itemHeight;

    private String[] strs = {"↑", "☆","A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
            "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#"};

    OnClickUpdateListener listener;

    public OnClickUpdateListener getListener() {
        return listener;
    }

    public void setListener(OnClickUpdateListener listener) {
        this.listener = listener;
    }

    public interface OnClickUpdateListener{
        void onLetterUpdate(String letter);
    }

    public IndexBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context=context;
        paint=new Paint();
        paint.setTextSize(30);
        paint.setColor(getResources().getColor(R.color.side_bar));
        paint.setTextSize(mTextSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setBackgroundColor(Color.TRANSPARENT);
        for (int i = 0; i < strs.length; i++) {
            String text=strs[i];
            // 计算坐标
            // x坐标为单元格宽度的一半 减去 文字宽度的一半
            int x= (int) (itemWidth/2-paint.measureText(text)/2);

            Rect bounds = new Rect();
            paint.getTextBounds(text, 0, text.length(), bounds);
            int textHeight=bounds.height();
            // y坐标为单元格高度的一半 + 文字高度的一半 + 上面有多少个单元格的高度（index*cellHeight）
            int y= itemHeight/2+textHeight/2+i*itemHeight;
            canvas.drawText(strs[i],x,y,paint);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        itemWidth=getMeasuredWidth();
        itemHeight=getMeasuredHeight()/strs.length;
    }

    int index;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int i=-1;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                index= (int) (event.getY()/itemHeight);
                if (index>=0&&index<strs.length&&listener!=null){
                    listener.onLetterUpdate(strs[index]);
                    index=i;
                }
                setBackgroundColor(ContextCompat.getColor(context,R.color.side_bar_pressed));
                break;
            case MotionEvent.ACTION_MOVE:
                index= (int) (event.getY()/itemHeight);
                if (index>=0&&index<strs.length&&listener!=null){
                    listener.onLetterUpdate(strs[index]);
                    index=i;
                }
                setBackgroundColor(ContextCompat.getColor(context,R.color.side_bar_pressed));
                break;
            case MotionEvent.ACTION_UP:
                index=-1;
                setBackgroundColor(Color.TRANSPARENT);
                break;
        }
        return true;
    }
}
