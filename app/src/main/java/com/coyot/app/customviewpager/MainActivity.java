package com.coyot.app.customviewpager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.widget.LinearLayout;

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

        View par=findViewById(R.id.PagerParrent);



        CustomViewPager cvp=new CustomViewPager(par);

    }


}
