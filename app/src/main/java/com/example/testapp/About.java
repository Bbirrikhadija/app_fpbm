package com.example.testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;
import mehdi.sakout.aboutpage.AboutPage;
import mehdi.sakout.aboutpage.Element;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.testapp.MainActivity;
import com.example.testapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class About extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        View aboutPage = new AboutPage(this).isRTL(false).setImage(R.drawable.fpbm)
                .setDescription((getString(R.string.about_us_description)))
                .addItem(new Element().setTitle("Version 1.0"))
                .addGroup("CONNECT WITH US!")
                .addEmail("fpbm@usms.ma ")
                .addWebsite("http://www.fpbm.ma/new/")
                .addYoutube("UCEljtJtReQRR1uo26q1_JAA")   //Enter your youtube link here (replace with my channel link)
                .addFacebook("170070076902877")    //Your facebook id
                .addItem(createCopyright())
                .create();
        setContentView(aboutPage);
    }

    private Element createCopyright()
    {
        Element copyright = new Element();
        @SuppressLint("DefaultLocale") final String copyrightString = String.format("Copyright %d by Master ISI", Calendar.getInstance().get(Calendar.YEAR));
        copyright.setTitle(copyrightString);
        // copyright.setIcon(R.mipmap.ic_launcher);
        copyright.setGravity(Gravity.CENTER);
        copyright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(About.this,copyrightString,Toast.LENGTH_SHORT).show();
            }
        });
        return copyright;

    }
}
