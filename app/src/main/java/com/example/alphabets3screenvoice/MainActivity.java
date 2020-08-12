package com.example.alphabets3screenvoice;

package com.example.spellingbook;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static TextToSpeech t1;
    Button btnalpha;
    public static String[] eachWord = {"a for Apple", "b for Boll", "c for Cat", "d for Dog", "e for Elephant", " f for Fish", "g for Grapes", "h for Horse",
            "i for Ice Cream", "j for Jeep", "k for Kite", "l for Lion", "m for Mango", "n for Nest", "o for Orange", "p for Parrot", "q for Queen", "r for Rabbit", "s for Snake", "t for Train",
            "u for Umbrella", "v for Van", "w for Watch", "x for Xylophone", "y for Yak", "z for Zebra"};
    public static String[] eachWordSpeech = {"a for Apple", "b for Ball", "c for Cat", "d for Dog", "e for Elephant", " f for Fish", "g for Grapes", "h for Horse",
            "i for Ice Cream", "j for Jeep", "k for Kite", "l for Lion", "m for Mango", "n for Nest", "o for Orange", "p for Parrot", "q for Queen", "r for Rabbit", "s for Snake", "t for Train",
            "u for Umbrella", "v for Van", "w for Watch", "x for Xylophone", "y for Yak", "z for Zebra"};
    public static int[] image = {
            R.drawable.apple,
            R.drawable.ball,
            R.drawable.cat,
            R.drawable.dog,
            R.drawable.eleph,
            R.drawable.fish,
            R.drawable.grap,
            R.drawable.horse,
            R.drawable.icecream,
            R.drawable.jeep,
            R.drawable.kite,
            R.drawable.wild,
            R.drawable.mango,
            R.drawable.nest,
            R.drawable.orange,
            R.drawable.parr,
            R.drawable.queen,
            R.drawable.rabbit,
            R.drawable.snake,
            R.drawable.train,
            R.drawable.umber,
            R.drawable.van,
            R.drawable.watch,
            R.drawable.xap,
            R.drawable.yark,
            R.drawable.ze};
    TextView txt, txtPlay;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//           ==============


        int st = Integer.parseInt(getIntent().getExtras().getString("position"));
        txt = findViewById(R.id.txt_alpha);
        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.US);
                }
            }
        });
        txtPlay = findViewById(R.id.txtPlay);
        imgView = findViewById(R.id.imageView);
        txt.setText((eachWord[st]).toUpperCase());
        final String stEachWord = eachWord[st];
        final String stEachWordSpeech = eachWordSpeech[st];
        imgView.setImageResource(image[st]);
        txtPlay.setText(eachWordSpeech[st].substring(6));

        btnalpha = findViewById(R.id.back_button1);
        btnalpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.speak(stEachWord, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t1.speak(stEachWordSpeech, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        finish();
    }
}