package com.example.arash.saeedidairy.ProductPages.MilkPages;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.arash.saeedidairy.R;

public class YagurtCheesFat extends AppCompatActivity {
    Toolbar doughtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yagurt_chees_fat);
        doughtoolbar=(Toolbar)findViewById(R.id.doughtoolbar);
        setSupportActionBar(doughtoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("");


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
