package com.heunglab.sensegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView intro = new ImageView(this);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(intro);
        Glide.with(this).load(R.drawable.intro).into(gifImage);
        intro.setBackgroundResource(R.drawable.intro);
        intro.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(IntroActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });
        setContentView(intro);
    }
}
