package com.smartwebarts.swarealadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.smartwebarts.swarealadmin.dashboard.DashboardActivity;
import com.smartwebarts.swarealadmin.util.AppSharedPreferences;

public class SplashActivity extends AppCompatActivity {
    private static final boolean AUTO_HIDE = true;
    private static final int AUTO_HIDE_DELAY_MILLIS = 3000;
    private ImageView fullscreen_content;
    private Animation topAnim, bottomAnim;
    private static final long SPLASH_DELAY = 2500l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        init();
        mDelayHandler.postDelayed(runnable, SPLASH_DELAY);
        startAnimation();
    }

    private void startAnimation() {
        fullscreen_content.startAnimation(topAnim);
    }

    private void init() {
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animator);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animator);
        fullscreen_content = findViewById(R.id.fullscreen_content);
        fullscreen_content.setImageDrawable(getResources().getDrawable(R.drawable.logo));
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDelayHandler.removeCallbacks(runnable);
    }

    private Handler mDelayHandler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {

           next();
        }
    };

    private String user;
    public void next() {
        AppSharedPreferences preferences = new AppSharedPreferences(getApplication());

        user = preferences.getLoginDetails();
        if (user == null || user.isEmpty()) {
            Intent intent = new Intent(getApplicationContext(), Login.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
            finish();
            overridePendingTransition(R.anim.enter, R.anim.exit);
            startActivity(intent);
        } else {
            Intent intent;
            if (preferences.getLoginRole().equalsIgnoreCase("user")) {
                intent = new Intent(getApplicationContext(), DashboardActivity.class);

                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                finish();
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(intent);
            }
        }
    }


}