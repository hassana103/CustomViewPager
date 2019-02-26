//>> created by HaSSaN
//>> 2/25/2019
//>> CustomViewPager


package com.coyot.app.customviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class CustomViewPager implements View.OnTouchListener {

    VelocityTracker mVelocityTracker;

    private float startX;
    private float maxV;

    private View _Parent;
    private ArrayList _items;

   public CustomViewPager(View v){
       mVelocityTracker=VelocityTracker.obtain();
       v.setOnTouchListener(this);
   }


    @Override
    public boolean onTouch(View view, MotionEvent event) {


        if(event.getAction()==MotionEvent.ACTION_DOWN){
            startX=event.getX();
            mVelocityTracker.clear();

        }else if(event.getAction()==MotionEvent.ACTION_MOVE){
            mVelocityTracker.addMovement(event);
            mVelocityTracker.computeCurrentVelocity(1000);

            float v =mVelocityTracker.getXVelocity();
            if(v>maxV){
                maxV=v;
            }

            Log.d("v and maxv",">>>>>"+v+"   "+maxV);

        }



        return true;
    }
}
