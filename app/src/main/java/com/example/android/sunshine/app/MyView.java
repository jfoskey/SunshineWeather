package com.example.android.sunshine.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by Jerma_000 on 9/18/2015.
 */
public class MyView extends View{
    private ShapeDrawable mDrawable;
    private static final  String LOG_TAG = MyView.class.getSimpleName();
    public MyView(Context context){
        super(context);
        Log.d(LOG_TAG, "One parameter constructor");
        int x = 10;
        int y = 10;
        int width = 300;
        int height = 50;

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.BLACK);
        mDrawable.setBounds(x, y, x + width, y + height);

        //makeCircle();
    }

    public MyView(Context context, AttributeSet attrs){
        super(context,attrs);
        Log.d(LOG_TAG, "Two parameter constructor");
        int x = 10;
        int y = 10;
        int width = 300;
        int height = 50;

        mDrawable = new ShapeDrawable(new OvalShape());
        mDrawable.getPaint().setColor(Color.BLACK);
        mDrawable.setBounds(x, y, x + width, y + height);
      //      makeCircle();
    }

    public MyView(Context context, AttributeSet attrs, int DefaultStyle){
        super(context, attrs, DefaultStyle);
       // makeCircle();
    }

    @Override
    protected void onMeasure(int wMeasureSpec, int hMeasureSpec){
        setMeasuredDimension(wMeasureSpec, hMeasureSpec);
    }

    /**
     * Implement this to do your drawing.
     *
     * @param canvas the canvas on which the background will be drawn
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mDrawable.draw(canvas);
        makeCircle().draw(canvas);

    }

    protected  ShapeDrawable makeCircle( ){
        ShapeDrawable windCircle = new ShapeDrawable( new OvalShape());
        windCircle.setIntrinsicHeight(10);
        windCircle.setIntrinsicWidth(10);
        windCircle.setBounds(new Rect(0, 0, 10, 10));
        windCircle.getPaint().setColor(Color.RED);
        windCircle.setPadding(50, 50, 50, 50);
        return windCircle;
    }
}
