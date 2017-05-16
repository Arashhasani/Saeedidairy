package com.example.arash.saeedidairy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.ldoublem.loadingviewlib.LVBlock;

public class SplashScreen extends AppCompatActivity {

    TextView spalshtext , splashwait;
    ImageView splashlogo;
    ProgressBar splashprogress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);



        LVBlock lvBlock = new LVBlock(SplashScreen.this);
        lvBlock=(LVBlock)findViewById(R.id.block);
        lvBlock.startAnim();


                spalshtext=(TextView)findViewById(R.id.spalshtext);
                splashwait=(TextView)findViewById(R.id.splashwait);
                splashlogo=(ImageView)findViewById(R.id.splashlogo);

//        splashprogress=(ProgressBar)findViewById(R.id.splashprogress);
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_inandmove);
//        splashlogo.startAnimation(animation);
//        spalshtext.startAnimation(animation);
//        splashwait.startAnimation(animation);
//
//        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
//        splashprogress.startAnimation(animation1);




        Thread thread = new Thread(){

            public void run(){



                try {


                    sleep(5000);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent intent = new Intent(SplashScreen.this , Login.class);
                    startActivity(intent);

                }


            }




        };
        thread.start();

    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
