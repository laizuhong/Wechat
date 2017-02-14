package com.lzh.texticonview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/**
 *
 * Created by laizuhong on 2017/2/14.
 */

public class TextIconView extends View{

    String text;
    Bitmap bitmap;
    Paint paint;

    int width,height;

    int MARGIN_LEFT=-1;
    int MARGIN_RIGHT=-1;

    boolean showRightIcon;

    private float leftTextSize = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP,
            16, getResources().getDisplayMetrics());

    public TextIconView(Context context) {
        super(context);
    }

    public TextIconView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TextIconView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray array=context.obtainStyledAttributes(attrs, R.styleable.TextIconView);


        text=array.getString(R.styleable.TextIconView_left_text);
        int resId=array.getResourceId(R.styleable.TextIconView_left_icon,Color.RED);
        bitmap= BitmapFactory.decodeResource(getResources(),resId);
        Log.e("length",array.length()+""+resId);
        MARGIN_LEFT=array.getDimensionPixelSize(R.styleable.TextIconView_icon_margin_left,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,-1,getResources().getDisplayMetrics()));
        MARGIN_RIGHT=array.getDimensionPixelSize(R.styleable.TextIconView_icon_margin_right,
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,-1,getResources().getDisplayMetrics()));
//        showRightIcon=array.getBoolean(R.styleable.TextIconView_show_right_icon,false);
        Log.e("length",MARGIN_LEFT+" 123   "+MARGIN_RIGHT);

        initPain();
        array.recycle();
    }

    private void initPain(){
        paint=new Paint();
        paint.setTextSize(leftTextSize);
        //抗锯齿
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        //文字水平居中
        paint.setTextAlign(Paint.Align.CENTER);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width=getWidth();
        height=getHeight();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);



        if (bitmap!=null) {
            Rect rect=new Rect();
            rect.left=MARGIN_LEFT;
            rect.top=height/4;
            rect.right=MARGIN_LEFT+height/2;
            rect.bottom=height*3/4;
            Log.e("RECT",rect.left+" "+rect.top+"  "+rect.right+"  "+rect.bottom);
            canvas.drawBitmap(bitmap,null,rect,paint);

        }else {
            Log.e("Error","图片错误");
        }
//
        //左上角起始位置
        Rect mRect=new Rect(getPaddingLeft(),getPaddingTop(),width-getPaddingRight(),height-getPaddingBottom());

        Paint.FontMetrics fontMetrics=paint.getFontMetrics();
        int baseLine= (int) (mRect.bottom+mRect.top-fontMetrics.bottom+fontMetrics.top);

        Log.e("Error","baseLine"+baseLine+"");
        if (!TextUtils.isEmpty(text)) {
            int left=MARGIN_LEFT+height/2+MARGIN_RIGHT;

            paint.setTextAlign(Paint.Align.LEFT);
            canvas.drawText(text,left,baseLine,paint);
        }else {
            Log.e("Error","字符串错误");
        }




    }
}
