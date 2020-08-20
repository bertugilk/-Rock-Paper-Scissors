package com.example.ta_kat_makas;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView o1,o2;
    private Button btnOyna;
    private ImageView img1,img2;
    MediaPlayer muzik;
    int skor1 = 0;
    int skor2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        muzik=MediaPlayer.create(MainActivity.this,R.raw.sampiyonlar);
        muzik.start();

        o1=findViewById(R.id.txtO1);
        o2=findViewById(R.id.txtO2);
        btnOyna=findViewById(R.id.btnOyna);
        img1=findViewById(R.id.img1);
        img2=findViewById(R.id.img2);

        btnOyna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int say1;
                int say2;

                Random rastgele=new Random();
                say1=rastgele.nextInt(3);

                Random random=new Random();
                say2=random.nextInt(3);

                if(say1==0){
                    img1.setImageResource(R.mipmap.rock);
                }
                if(say1==1){
                    img1.setImageResource(R.mipmap.paper);
                }
                if(say1==2){
                    img1.setImageResource(R.mipmap.scissors);
                }

                if(say2==0){
                    img2.setImageResource(R.mipmap.rock);
                }
                if(say2==1){
                    img2.setImageResource(R.mipmap.paper);
                }
                if(say2==2){
                    img2.setImageResource(R.mipmap.scissors);
                }


                if(say1==0 && say2==2){
                    skor1++;
                }
                if(say1==1 && say2==0){
                    skor1++;
                }
                if(say1==2 && say2==1){
                    skor1++;
                }

                if(say2==0 && say1==2){
                    skor2++;
                }
                if(say2==1 && say1==0){
                    skor2++;
                }
                if(say2==2 && say1==1){
                    skor2++;
                }

                o1.setText("Oyuncu1: "+skor1);
                o2.setText("Oyuncu2: "+skor2);

            }
        });
    }
}