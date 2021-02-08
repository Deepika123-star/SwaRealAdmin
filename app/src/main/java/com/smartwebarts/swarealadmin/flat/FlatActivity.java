package com.smartwebarts.swarealadmin.flat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.smartwebarts.swarealadmin.R;
import com.smartwebarts.swarealadmin.dashboard.adapter.OurAssociateAdpter;

import java.util.ArrayList;

public class FlatActivity extends AppCompatActivity {
    RecyclerView flatView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flat);

        init();
      /*  setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Plot");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
        ArrayList ourplots = new ArrayList<>();
        OurAssociateAdpter ourAssociate=new  OurAssociateAdpter(ourplots,this);
        flatView.setAdapter(ourAssociate);
        flatView.setLayoutManager(new GridLayoutManager(this, 3));

    }

    private void init() {
        flatView=findViewById(R.id.flatView);
       // toolbar=findViewById(R.id.toolbar);

    }
}