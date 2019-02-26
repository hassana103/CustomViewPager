//>> created by HaSSaN
//>> 2/25/2019
//>> CustomViewPager


package com.coyot.app.customviewpager;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class CustomViewPager implements View.OnTouchListener {

    VelocityTracker mVelocityTracker;

    private float startX;
    private float maxV;

    private ViewGroup _Parent;
    private int _itemLayoutID;
    private ArrayList _items;
    private Context _context;

   public CustomViewPager(Context context,ViewGroup parent , int itemLayoutID, ArrayList items){
       mVelocityTracker=VelocityTracker.obtain();
       _Parent=parent;
       _itemLayoutID=itemLayoutID;
       _items=items;
       _context=context;



      for (int i=0 ; i<items.size(); i++){
           View temp=itemMaker(itemLayoutID,parent,i);
           //parent.addView(temp);
       }


       Log.d("#####################",parent.getChildCount()+"");

       parent.setOnTouchListener(this);

   }

   public View itemMaker(int itemLayoutID,ViewGroup parent,int position){

       View v= LayoutInflater.from(_context).inflate(itemLayoutID,parent);

       ImageView imgv=(ImageView) v.findViewById(R.id.imageView);
       imgv.setImageResource(R.drawable.ic_launcher_foreground);

       TextView tv=(TextView) v.findViewById(R.id.textView2);
       tv.setText("test text "+position);

        v.setId(10000+position);

       return v;

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
