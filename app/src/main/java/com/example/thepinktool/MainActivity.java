package com.example.thepinktool;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;



public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView bg1 = (ImageView) findViewById(R.id.bg1);
        final ImageView bg2 = (ImageView) findViewById(R.id.bg2);


        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(10000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = bg1.getWidth();
                final float translationX = width * progress; // seamless olması icin
                bg1.setTranslationX(translationX);
                bg2.setTranslationX(translationX - width); //2 resim aynı sekilde yan yana
            }
        });
        animator.start();

    }

    public void startGame(View view) {

        Intent intent = new Intent(this, toolscene2.class);
        startActivity(intent);
        finish();
    }
}
