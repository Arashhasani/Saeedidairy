package com.example.arash.saeedidairy.menupages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ScrollView;

import com.example.arash.saeedidairy.R;

public class AboutUs extends AppCompatActivity {

    Toolbar abouttoolbar;

    ScrollView scroll;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        scroll=(ScrollView)findViewById(R.id.scroll);
        abouttoolbar = (Toolbar)findViewById(R.id.abouttoolbar);
        setTitle("");
        setSupportActionBar(abouttoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id==android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
