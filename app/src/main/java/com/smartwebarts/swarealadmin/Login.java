package com.smartwebarts.swarealadmin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import com.smartwebarts.swarealadmin.dashboard.DashboardActivity;

public class Login extends AppCompatActivity {

    AppCompatTextView cirLoginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cirLoginButton=findViewById(R.id.cirLoginButton);
        cirLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(), DashboardActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                finish();
                overridePendingTransition(R.anim.enter, R.anim.exit);
                startActivity(intent);
            }
        });

    }
}
