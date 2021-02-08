package com.smartwebarts.swarealadmin.dashboard;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;
import com.smartwebarts.swarealadmin.R;
import com.smartwebarts.swarealadmin.addnewasociate.AddNewAsociateActivity;
import com.smartwebarts.swarealadmin.changepasword.ChangePasswordActivity;
import com.smartwebarts.swarealadmin.compnay.CompanyAccountActivity;
import com.smartwebarts.swarealadmin.contact.ContactActivity;
import com.smartwebarts.swarealadmin.dashboard.adapter.OurAssociateAdpter;
import com.smartwebarts.swarealadmin.flat.FlatActivity;
import com.smartwebarts.swarealadmin.model.DashboardModel;
import com.smartwebarts.swarealadmin.profile.ProfileActivity;
import com.smartwebarts.swarealadmin.transaction.TransactionActivity;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private NavigationView navigationView;
    ViewFlipper viewFlipper;
    RecyclerView ourProjectList;
    MaterialCardView flatcard;
    int gallery_grid_Images[] = {R.drawable.bg1, R.drawable.bg2,R.drawable.bg3,R.drawable.bg4};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        init();
        flatcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DashboardActivity.this,FlatActivity.class);
                startActivity(intent);
            }
        });
    /*    List<DashboardModel>dashboardModelList=new ArrayList<>();
        dashboardModelList.add(new DashboardModel("1","Flat"));
        dashboardModelList.add(new DashboardModel("1","plot Report"));
        dashboardModelList.add(new DashboardModel("1","Flat"));
        dashboardModelList.add(new DashboardModel("1","My Wallet"));
        dashboardModelList.add(new DashboardModel("1","My Associate"));
        dashboardModelList.add(new DashboardModel("1","Flat"));
        dashboardModelList.add(new DashboardModel("1","Flat"));
        dashboardModelList.add(new DashboardModel("1","Flat"));
        dashboardModelList.add(new DashboardModel("1","Flat"));
        dashboardModelList.add(new DashboardModel("1","Flat"));
        dashboardModelList.add(new DashboardModel("1","Flat"));
        OurAssociateAdpter ourAssociate=new  OurAssociateAdpter(dashboardModelList,this);
        ourProjectList.setAdapter(ourAssociate);
        ourProjectList.setLayoutManager(new GridLayoutManager(this, 3));
*/
        for(int i=0; i<gallery_grid_Images.length; i++){
            // This will create dynamic image views and add them to the ViewFlipper.
            setFlipperImage(gallery_grid_Images[i]);
        }
    }

    private void init() {
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        viewFlipper = (ViewFlipper)findViewById(R.id.viewflip);
        ourProjectList=findViewById(R.id.ourProjectList);
        flatcard=findViewById(R.id.flatcard);


    }
    /*Slider*/
    private void setFlipperImage(int res) {
        Log.i("Set Filpper Called", res+"");
        ImageView image = new ImageView(this);
        image.setBackgroundResource(res);
        viewFlipper.addView(image);
        viewFlipper.setFlipInterval(2000);
        viewFlipper.setAutoStart(true);
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawer.closeDrawer(GravityCompat.START);
        switch (item.getItemId()){
            case R.id.myProfile:
                Intent intent=new Intent(DashboardActivity.this, ProfileActivity.class);
                startActivity(intent);
            break;
            case R.id.addnewassociate:
                Intent add=new Intent(DashboardActivity.this, AddNewAsociateActivity.class);
                startActivity(add);
                break;
            case R.id.transactionHistory:
                Intent transaction=new Intent(DashboardActivity.this, TransactionActivity.class);
                startActivity(transaction);
                break;
            case R.id.changePassword:
                Intent changpassword=new Intent(DashboardActivity.this, ChangePasswordActivity.class);
                startActivity(changpassword);
                break;
            case R.id.companyAccountDetails:
                Intent company=new Intent(DashboardActivity.this, CompanyAccountActivity.class);
                startActivity(company);
                break;
            case R.id.shareApp:
                try {
                    String url = "https://api.whatsapp.com/send?phone="+"+91000000000";
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);
                } catch (Exception e) {
                    Toast.makeText(this, "Unable to open your whatsapp", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.contact:
                Intent contact=new Intent(DashboardActivity.this, ContactActivity.class);
                startActivity(contact);
                break;
            case R.id.logOut:

                break;
            default:

        }
        return true;
    }
    public void openDrawer(View view) {
        drawer.openDrawer(GravityCompat.START);
    }

}
