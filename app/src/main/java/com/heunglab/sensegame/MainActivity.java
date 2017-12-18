package com.heunglab.sensegame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class MainActivity extends AppCompatActivity {

    Button exit_btn, com_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView title = (ImageView)findViewById(R.id.title);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(title);
        Glide.with(this).load(R.drawable.title_img).into(gifImage);
        title.setBackgroundResource(R.drawable.title_img);

        exit_btn = (Button) findViewById(R.id.exit_btn);
        exit_btn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        com_btn = (Button) findViewById(R.id.com_btn);
        com_btn.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent_comgame = new Intent(getApplicationContext(), ComActivity.class);
                        startActivity(intent_comgame);
                    }
                }
        );
    }
}
