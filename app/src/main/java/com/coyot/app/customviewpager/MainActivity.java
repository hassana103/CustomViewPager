package com.coyot.app.customviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {


    VelocityTracker mVelocityTracker;

    private float startX;
    private float maxV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mVelocityTracker=VelocityTracker.obtain();

        ViewGroup par=(ViewGroup) findViewById(R.id.PagerParrent);


       /* View v= LayoutInflater.from(this).inflate(R.layout.item_simple_1,par);

        ImageView imgv=(ImageView) v.findViewById(R.id.imageView);
        imgv.setImageResource(R.drawable.ic_launcher_foreground);

        TextView tv=(TextView) v.findViewById(R.id.textView2);
        tv.setText("test text ");


        View v2= LayoutInflater.from(this).inflate(R.layout.item_simple_1,par);

        ImageView imgv2=(ImageView) v2.findViewById(R.id.imageView);
        imgv2.setImageResource(R.drawable.ic_launcher_background);

        TextView tv2=(TextView) v2.findViewById(R.id.textView2);
        tv.setText("test text2 ");
*/
        //par.addView(v);


        ArrayList<String> list=new ArrayList<>();
        list.add("1111");
        list.add("2222");
        list.add("3333");



        CustomViewPager cvp=new CustomViewPager(this,par,R.layout.item_simple_1,list);

    }


}
