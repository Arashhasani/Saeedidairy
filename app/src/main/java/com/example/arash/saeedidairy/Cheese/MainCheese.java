package com.example.arash.saeedidairy.Cheese;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.arash.saeedidairy.R;

import java.util.ArrayList;
import java.util.List;

public class MainCheese extends AppCompatActivity {




    String[] name_array = new String []{

            "پنیر کم چرب",
            "پنیر نیم چرب",
            "پنیر پر چرب",

    };

    int[] image_array= new int[]{

            R.drawable.cheese,
            R.drawable.cheese,
            R.drawable.cheese,

    };



    List<Cheese> cheese_array = new ArrayList<>();
    Toolbar cheesetoolbar;
    RecyclerView cheeserecycler;



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_cheese);
        cheesetoolbar=(Toolbar)findViewById(R.id.cheesetoolbar);
        setTitle("");
        setSupportActionBar(cheesetoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        for (int i = 0 ; i<name_array.length ; i++){

            Cheese cheese_add = new Cheese();
            cheese_add.name=name_array[i];
            cheese_add.image=image_array[i];

            cheese_array.add(cheese_add);


        }

        cheeserecycler=(RecyclerView)findViewById(R.id.cheeserecycler);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        cheeserecycler.setLayoutManager(lm);
        cheeserecycler.setHasFixedSize(true);
        cheeserecycler.setAdapter(new CheeseRecyclerAdapter(getBaseContext() , cheese_array));
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
