package com.example.thepinktool;

import androidx.appcompat.app.AppCompatActivity;


import android.animation.ValueAnimator;
import android.graphics.Point;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

import android.provider.MediaStore;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class toolscene2 extends AppCompatActivity {


    Handler handler;
    Runnable runnable;
    final int UPDATE_MILLIS = 30;
    EditText input;
    Button sendbtn;
    TextView answer;
    Point size;
    TextView coin;
    ImageView hungermeter;
    Button feedButton;
    int coinCounter = 0;

    int tool_frame = 0;
    int hungerrate = 100;


    ImageView toolimg;
    MediaPlayer music;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolscene2);

        toolimg = findViewById(R.id.toolimg);
        sendbtn = findViewById(R.id.sendbtn);
        input = findViewById(R.id.cumle);
        answer = findViewById(R.id.answer);
        answer.setVisibility(View.INVISIBLE);

        coin = findViewById(R.id.coin);
        hungermeter = findViewById(R.id.staminameter);
        feedButton = findViewById(R.id.feedButton);

        music = MediaPlayer.create(getApplicationContext(),R.raw.music);
        music.setLooping(true);
        music.start();






        final ImageView bg1 = (ImageView) findViewById(R.id.bg);
        final ImageView bg2 = (ImageView) findViewById(R.id.bg3);


        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(10000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = bg1.getWidth();
                final float translationX = width * progress;
                bg1.setTranslationX(translationX);
                bg2.setTranslationX(translationX - width); //2 resim aynı sekilde yan yana


            }
        });
        animator.start();

        hungermeter.setImageResource(R.drawable.stamina100);
        closeActivity.start();



    }

    Thread closeActivity = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                while(true){
                    if (hungerrate >= 0) {
                        Thread.sleep(20000);
                        hungerrate -= 20;

                        if(hungerrate>=60 && hungerrate<=80)
                            hungermeter.setImageResource(R.drawable.stamina80);

                        if(hungerrate>=40 && hungerrate<50)
                            hungermeter.setImageResource(R.drawable.stamina45);

                        if(hungerrate>=20 && hungerrate<40)
                            hungermeter.setImageResource(R.drawable.stamina30);

                        if(hungerrate<20)
                            hungermeter.setImageResource(R.drawable.stamina1);

                    } else
                        hungerrate = 0;

                    Thread.sleep(1);

                }


            } catch (Exception e) {
                e.getLocalizedMessage();
            }
        }
    });


    public void buttonpressed(View view) {

        String getcumle;
        String playername = "noname";
        getcumle = input.getText().toString().toLowerCase();
        input.setText("");
        input.setEnabled(false);
        input.setEnabled(true);


        if(hungerrate>=10) {

            if (getcumle.contains("love") || getcumle.contains("like")) {
                if(hungerrate>=40) {
                    toolimg.setImageResource(R.drawable.tool_happy);
                    answer.setText("Me too!");
                    coinCounter += 5;
                }else{
                    toolimg.setImageResource(R.drawable.tool_confused);
                    answer.setText("Im hungry :S");
                }

            }


            if (getcumle.contains("bye") || getcumle.equals("bb") || getcumle.contains("bb tool")) {

                toolimg.setImageResource(R.drawable.tool_happy);
                answer.setText("good bye");


            }


            if (getcumle.equals("are you")) {
                Random r = new Random();
                int cm = r.nextInt(3) + 1;
                coinCounter += 5;

                toolimg.setImageResource(R.drawable.tool);
                if (cm == 2)
                    answer.setText("Yes, I am.");
                else
                    answer.setText("No, I am not.");

            }

            if (getcumle.equals("do you")) {
                Random c = new Random();
                int cm = c.nextInt(3) + 1;
                coinCounter += 5;

                toolimg.setImageResource(R.drawable.tool);
                if (cm == 2)
                    answer.setText("Yes, I do.");
                else
                    answer.setText("No, I dont.");

            }

            if (getcumle.contains("can you")) {
                Random c = new Random();
                int cm = c.nextInt(3) + 1;
                coinCounter += 5;

                toolimg.setImageResource(R.drawable.tool);
                if (cm == 2)
                    answer.setText("Yes, I can.");
                else
                    answer.setText("No, I cant.");

            }

            if (getcumle.contains("should you")) {
                Random c = new Random();
                int cm = c.nextInt(3) + 1;
                coinCounter += 5;

                toolimg.setImageResource(R.drawable.tool);
                if (cm == 2)
                    answer.setText("Yes, I should.");
                else
                    answer.setText("No, I shouldnt.");

            }

            if (getcumle.contains("would you")) {
                Random c = new Random();
                int cm = c.nextInt(3) + 1;
                coinCounter += 5;

                toolimg.setImageResource(R.drawable.tool);
                if (cm == 2)
                    answer.setText("Yes, I would.");
                else
                    answer.setText("No, I wouldnt.");

            }

            if (getcumle.contains("will you")) {
                Random c = new Random();
                int cm = c.nextInt(3) + 1;
                coinCounter += 5;

                toolimg.setImageResource(R.drawable.tool);
                if (cm == 2)
                    answer.setText("Yes, I will.");
                else
                    answer.setText("No, I wont.");

            }

            if (getcumle.contains("do you")) {
                coinCounter += 5;

                toolimg.setImageResource(R.drawable.tool);
                answer.setText("Yes, I do.");

            }


            if (getcumle.contains("petscop")) {
                coinCounter += 10;

                toolimg.setImageResource(R.drawable.tool_confused);
                answer.setText("Petscop? What's that?? ;)");

            }

            if (getcumle.contains("anisage")) {
                coinCounter += 10;

                toolimg.setImageResource(R.drawable.tool_happy);
                answer.setText("Anisage is the best game company!");

            }

            if ((getcumle.contains("aerotales") || getcumle.contains("aero tales")) && (getcumle.contains("password") || getcumle.contains("pw"))) {

                toolimg.setImageResource(R.drawable.tool_confused);
                answer.setText("First solve my puzzle! What is the answer of life?");

            }

            if (getcumle.equals("42")) {
                coinCounter += 20;
                toolimg.setImageResource(R.drawable.tool_happy);
                answer.setText("345362");

            }

            if (getcumle.contains("fuck") || getcumle.contains("ass hole") || getcumle.contains("dick") || getcumle.contains("sex") || getcumle.contains("pussy") || getcumle.contains("oç") || getcumle.contains("shit")) {
                coinCounter -= 10;
                toolimg.setImageResource(R.drawable.tool_angry);
                answer.setText("How rude!");

            }

            if (getcumle.contains("bored")) {

                toolimg.setImageResource(R.drawable.tool);
                answer.setText("Me too..");

            }

            if (getcumle.equals("hello") || getcumle.equals("hi") || getcumle.equals("hello the tool") || getcumle.equals("hello tool")) {
                if(hungerrate>=40) {
                    coinCounter += 5;
                    toolimg.setImageResource(R.drawable.tool);
                    answer.setText("Hello");
                }else{
                    toolimg.setImageResource(R.drawable.tool_confused);
                    answer.setText("Im hungry :S");
                }

            }

            if (getcumle.contains("my name is")) {
                if(hungerrate>=40) {
                    coinCounter += 5;
                    playername = getcumle.toString().substring(10);
                    toolimg.setImageResource(R.drawable.tool);
                    answer.setText("Hello, " + playername);

                }
                else{
                    toolimg.setImageResource(R.drawable.tool_confused);
                    answer.setText("Im hungry :S");
                }

            }


            if (getcumle.contains("how old are you")) {
                coinCounter += 5;
                toolimg.setImageResource(R.drawable.tool_happy);
                answer.setText("I'm ?? years old.");


            }


            if (getcumle.contains("what is your favorite") || getcumle == "what is your favourite") {
                if(hungerrate>=40) {


                    if (getcumle.contains("game")) {
                        coinCounter += 5;
                        toolimg.setImageResource(R.drawable.tool);
                        answer.setText("Aero Tales Online");

                    }


                    if (getcumle.contains("movie") || getcumle.contains("film")) {
                        coinCounter += 5;
                        toolimg.setImageResource(R.drawable.tool);
                        answer.setText("Cube II");

                    }


                    if (getcumle.contains("place")) {
                        coinCounter += 5;
                        toolimg.setImageResource(R.drawable.tool);
                        answer.setText("Here");

                    }


                    if (getcumle.contains("anime")) {
                        coinCounter += 5;
                        toolimg.setImageResource(R.drawable.tool_happy);
                        answer.setText("Sword Art Online");

                    }

                    if (getcumle.contains("drink")) {
                        coinCounter += 5;
                        toolimg.setImageResource(R.drawable.tool_confused);
                        answer.setText("Oil");

                    }

                    if (getcumle.contains("food")) {
                        coinCounter += 5;
                        toolimg.setImageResource(R.drawable.tool_confused);
                        answer.setText("Your brain");

                    }

                    if (getcumle.contains("hobby") || getcumle.contains("hobbies")) {
                        coinCounter += 5;
                        toolimg.setImageResource(R.drawable.tool_happy);
                        answer.setText("Talking with people");

                    }
                }
                else{
                toolimg.setImageResource(R.drawable.tool_confused);
                answer.setText("Im hungry :S");
            }


            }

            if (getcumle.contains(("my hobby")) || getcumle.contains("my hobbies")) {
                coinCounter += 5;
                toolimg.setImageResource(R.drawable.tool_happy);
                answer.setText("Oh, I like it!");

            }

            if ((getcumle.contains("what") && getcumle.contains("time") && getcumle.contains("is")) || getcumle.contains("date")) {
                Date currentTime = Calendar.getInstance().getTime();
                coinCounter += 5;
                toolimg.setImageResource(R.drawable.tool);
                answer.setText("Oh time, its" + currentTime + " !");

            }


            if (getcumle.contains("how are you") || getcumle == "sup") {
                coinCounter += 5;
                toolimg.setImageResource(R.drawable.tool_happy);
                answer.setText("fine you?");

            }

            if (getcumle.contains("who are you") || getcumle.contains("what is your name")) {
                coinCounter += 5;
                toolimg.setImageResource(R.drawable.tool);
                answer.setText("The Tool!");

            }

            if (getcumle.contains("who is")) {
                coinCounter += 5;
                toolimg.setImageResource(R.drawable.tool_confused);
                answer.setText("You know better than me :)");

            }

            if (getcumle.equals("hey")) {
                answer.setText("hey!");
                toolimg.setImageResource(R.drawable.tool);
                coinCounter += 5;

            }

            if (getcumle.equals("sorry") || getcumle.equals("im sorry") || getcumle.equals("i'm sorry")) {
                answer.setText("its ok!");
                toolimg.setImageResource(R.drawable.tool_confused);
                coinCounter += 5;

            }

            if (getcumle.equals("me too") || getcumle.equals("good") || getcumle.equals("fine")) {
                answer.setText("hehe :)");
                toolimg.setImageResource(R.drawable.tool_happy);
                coinCounter += 5;

            }


            if (getcumle.equals("bad")) {
                answer.setText("ohh.. :(");
                toolimg.setImageResource(R.drawable.tool_confused);
                coinCounter += 5;

            }
        }else
            answer.setText("i dont wanna answer your questions.. o(-_-)o");

        coin.setText("COIN: " + coinCounter);






        answer.setVisibility(View.VISIBLE);
        answer.startAnimation(AnimationUtils.loadAnimation(toolscene2.this,R.anim.pluse));





    }


    public void feedButtonClicked(View view) {

     if(coinCounter>=25)
     {


         hungerrate=100;
         hungermeter.setImageResource(R.drawable.stamina100);
         coinCounter-=25;
         coin.setText("COIN: " + coinCounter);


     }else
     {
         Toast.makeText(getApplicationContext(),"No enough coin!",Toast.LENGTH_SHORT).show();
     }


    }
}