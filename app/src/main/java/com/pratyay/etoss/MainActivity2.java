package com.pratyay.etoss;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    private ImageView imgCoin;
    LottieAnimationView animationView;
    private Random rnd = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        imgCoin = findViewById(R.id.imageView2);
        animationView = findViewById(R.id.animation);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.audio);
        imgCoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                animationView.setVisibility(View.VISIBLE);
                imgCoin.setVisibility(View.INVISIBLE);
                animationView.playAnimation();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        animationView.setVisibility(View.INVISIBLE);
                        imgCoin.setVisibility(View.VISIBLE);
                    }
                }, 2000);
                toss();

            }
        });
    }
    private void toss(){
        int rand = rnd.nextInt(2) + 1;

        switch (rand) {
            case 1:
                imgCoin.setImageResource(R.drawable.heads);
                break;
            case 2:
                imgCoin.setImageResource(R.drawable.tails);
                break;
        }
    }
}