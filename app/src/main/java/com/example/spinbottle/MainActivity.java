package com.example.spinbottle;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
     private ImageView imgbottle;
     private Random random= new Random();
     private int lstDir;
     private boolean spinning;
    private MediaPlayer mediaPlayer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgbottle= findViewById(R.id.bottle);

        //play background sound on click
         mediaPlayer = MediaPlayer.create(this,R.raw.sound);



        imgbottle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();

                //spin the bottle
        int newDir= random.nextInt(1800);
        float pivotx = imgbottle.getWidth()/2;
        float pivoty= imgbottle.getHeight()/2;



        final Animation rotate = new RotateAnimation(lstDir,newDir,pivotx,pivoty);
        rotate.setDuration(2500);
        rotate.setFillAfter(true);

        if(!spinning){
            rotate.setAnimationListener( new Animation.AnimationListener()
            {

                @Override
                public void onAnimationStart (Animation animation){
                    spinning = true;
                }

                @Override
                public void onAnimationEnd (Animation animation){
                    spinning = false;
                }

                @Override
                public void onAnimationRepeat (Animation animation){

                }
            });
        lstDir = newDir;
        imgbottle.startAnimation(rotate);

            }


            }
        });

    }
}


