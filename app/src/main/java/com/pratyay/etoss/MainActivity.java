package com.pratyay.etoss;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imgCoin;
    private Random rnd =  new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgCoin = findViewById(R.id.imgCoin);
        Button button1 = (Button)this.findViewById(R.id.button);
        final MediaPlayer mp = MediaPlayer.create(this, R.raw.facebook);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
                toss();

            }
        });
    }
    private void toss(){
        int rand = rnd.nextInt(2) + 1;

        switch (rand){
            case 1:
                imgCoin.setImageResource(R.drawable.heads);
                break;
            case 2:
                imgCoin.setImageResource(R.drawable.tails);
                break;


        }
    }
}