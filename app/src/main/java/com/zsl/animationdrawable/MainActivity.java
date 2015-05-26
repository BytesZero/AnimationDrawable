package com.zsl.animationdrawable;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button bt_start,bt_start_oneshot,bt_stop,bt_stop_start;

    ImageView iv_show;


    AnimationDrawable animationDrawable;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();

    }

    private void initEvent() {
        bt_start.setOnClickListener(this);
        bt_start_oneshot.setOnClickListener(this);
        bt_stop.setOnClickListener(this);
        bt_stop_start.setOnClickListener(this);
    }

    private void initView() {
        bt_start= (Button) findViewById(R.id.main_bt_start);
        bt_start_oneshot= (Button) findViewById(R.id.main_bt_start_oneshot);
        bt_stop= (Button) findViewById(R.id.main_bt_stop);
        bt_stop_start= (Button) findViewById(R.id.main_bt_start_stop);

        iv_show= (ImageView) findViewById(R.id.main_iv_show);
        iv_show.setBackgroundResource(R.drawable.anim_one);

        animationDrawable= (AnimationDrawable) iv_show.getBackground();
    }


    @Override
    public void onClick(View v) {
        if (animationDrawable==null){
            return;
        }

        if (v==bt_start){
            start(false);
        }else if (v==bt_start_oneshot){
            start(true);
        }else if (v==bt_stop){
            animationDrawable.stop();
        }else if (v==bt_stop_start){
            if (animationDrawable.isRunning()){
                animationDrawable.stop();
            }else {
                animationDrawable.run();
            }
        }
    }

    /**
     * 开启动画
     * @param oneshot
     */
    private void start(boolean oneshot) {
        if (animationDrawable!=null){
            if (animationDrawable.isRunning()){
                animationDrawable.stop();
            }
            animationDrawable.setOneShot(oneshot);
            animationDrawable.start();
        }
    }
}
