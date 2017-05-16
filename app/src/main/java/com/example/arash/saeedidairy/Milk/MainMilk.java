package com.example.arash.saeedidairy.Milk;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.arash.saeedidairy.R;

import java.util.ArrayList;
import java.util.List;

public class MainMilk extends AppCompatActivity {

    String[] name_array = new String []{

            "شیر کم چرب",
            "شیر نیم چرب",
            "شیر پر چرب",

    };

    int[] image_array= new int[]{

            R.drawable.milk,
            R.drawable.milk,
            R.drawable.milk,

    };

    List<Milk> Milk_Array = new ArrayList<>();

    RecyclerView recyclerView;
    Toolbar doughtoolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_milk);

        for (int i = 0 ; i <name_array.length ; i++){
            Milk milk = new Milk();
            milk.image=image_array[i];
            milk.name=name_array[i];
            Milk_Array.add(milk);


        }


        LinearLayoutManager lm = new LinearLayoutManager(this);
        recyclerView=(RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(lm);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new MilkRecyclerAdapter(getApplicationContext(),Milk_Array));

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
