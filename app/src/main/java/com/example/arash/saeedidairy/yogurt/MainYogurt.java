package com.example.arash.saeedidairy.yogurt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.arash.saeedidairy.R;

import java.util.ArrayList;
import java.util.List;

public class MainYogurt extends AppCompatActivity {

    String[] name_array = new String []{

            "ماست کم چرب",
            "ماست نیم چرب",
            "ماست پر چرب",

    };

    int[] image_array= new int[]{

            R.drawable.yogurt,
            R.drawable.yogurt,
            R.drawable.yogurt,

    };

    List<Yogurt> Yagurt_Array = new ArrayList<>();

    RecyclerView recyclerView;
    Toolbar doughtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_yogurt);

        for (int i = 0 ; i <name_array.length ; i++){
            Yogurt yogurt = new Yogurt();
            yogurt.image=image_array[i];
            yogurt.name=name_array[i];
            Yagurt_Array.add(yogurt);


        }


        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new YagurtRecyclerAdapter(getApplicationContext(),Yagurt_Array));

        doughtoolbar = (Toolbar)findViewById(R.id.doughtoolbar);
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
