package com.example.arash.saeedidairy.dough;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.arash.saeedidairy.R;

import java.util.ArrayList;
import java.util.List;

public class MainDough extends AppCompatActivity {

    String[] name_array = new String []{

            "دوغ کم چرب",
            "دوغ نیم چرب",
            "دوغ پر چرب",

    };

    int[] image_array= new int[]{

            R.drawable.dough,
            R.drawable.dough,
            R.drawable.dough,

    };

    List<Dough> Dough_Array = new ArrayList<>();

    RecyclerView recyclerView;
    Toolbar doughtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dough);

        for (int i = 0 ; i <name_array.length ; i++){
            Dough dough = new Dough();
            dough.image=image_array[i];
            dough.name=name_array[i];
            Dough_Array.add(dough);


        }


        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new DoughRecyclerAdapter(getApplicationContext(),Dough_Array));

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
