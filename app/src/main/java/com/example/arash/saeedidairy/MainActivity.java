package com.example.arash.saeedidairy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.arash.saeedidairy.Cheese.MainCheese;
import com.example.arash.saeedidairy.Milk.MainMilk;
import com.example.arash.saeedidairy.dough.MainDough;
import com.example.arash.saeedidairy.menupages.AboutUs;
import com.example.arash.saeedidairy.menupages.ContactUs;
import com.example.arash.saeedidairy.yogurt.MainYogurt;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

import java.net.URI;

public class MainActivity extends AppCompatActivity {


    Toolbar maintoolbar;
    NavigationView navigation;
    DrawerLayout drawer;
    FloatingActionButton fab;
    ImageView milkpic , cheesepic , yogurtpic , doughpic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        maintoolbar=(Toolbar)findViewById(R.id.maintoolbar);
        setTitle("");
        setSupportActionBar(maintoolbar);
        navigation=(NavigationView)findViewById(R.id.navigation);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if(id==R.id.aboutus){
                    Intent intent = new Intent(MainActivity.this , AboutUs.class);
                    startActivity(intent);
                }else if(id==R.id.contactus){
                    Intent intent = new Intent(MainActivity.this , ContactUs.class);
                    startActivity(intent);
                }else if(id==R.id.exit) {
                    finish();
                }
                return true;
            }
        });

        fab=(FloatingActionButton)findViewById(R.id.fab);
//       fab.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View view) {
//
//               Snackbar.make(view , "ورود به سایت" , Snackbar.LENGTH_SHORT).setAction("دانشجویان برنامه نویسی و شبکه", new View.OnClickListener() {
//                   @Override
//                   public void onClick(View view) {
//                       Intent intent = new Intent(Intent.ACTION_VIEW , Uri.parse("http://paqnstudent.ir"));
//                       startActivity(intent);
//                   }
//               }).show();
//
//           }
//       });

        SubActionButton.Builder builder = new SubActionButton.Builder(this);

        ImageView imageView1 = new ImageView(this);
        ImageView imageView2 = new ImageView(this);
        ImageView imageView3 = new ImageView(this);

        imageView1.setImageResource(R.drawable.float_call);
        imageView2.setImageResource(R.drawable.float_map);
        imageView3.setImageResource(R.drawable.float_site);

        SubActionButton button1 = builder.setContentView(imageView1).build();
        SubActionButton button2 = builder.setContentView(imageView2).build();
        SubActionButton button3 = builder.setContentView(imageView3).build();

        new FloatingActionMenu.Builder(this).addSubActionView(button1).addSubActionView(button2).addSubActionView(button3)
                .attachTo(fab).build();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:09127372863"));
                startActivity(call);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent map = new Intent(Intent.ACTION_VIEW,Uri.parse("geo:96,36"));
                startActivity(map);
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent site = new Intent(Intent.ACTION_VIEW,Uri.parse("http://panstudent.ir"));
                startActivity(site);
            }
        });



        cheesepic=(ImageView)findViewById(R.id.cheesepic);
        milkpic=(ImageView)findViewById(R.id.milkpic);
        yogurtpic=(ImageView)findViewById(R.id.yogurtpic);
        doughpic=(ImageView)findViewById(R.id.doughpic);
        cheesepic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cheese = new Intent(MainActivity.this , MainCheese.class);
                startActivity(cheese);
            }
        });

        doughpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent dough = new Intent(MainActivity.this , MainDough.class);
                startActivity(dough);
            }
        });


        milkpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent milk = new Intent(MainActivity.this , MainMilk.class);
                startActivity(milk);
            }
        });


        yogurtpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yogurt = new Intent(MainActivity.this , MainYogurt.class);
                startActivity(yogurt);
            }
        });


    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.open_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        int id = item.getItemId();
        if (id==R.id.open_item){
            drawer.openDrawer(Gravity.RIGHT);
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        drawer=(DrawerLayout) findViewById(R.id.drawer);
        if (drawer.isDrawerOpen(Gravity.RIGHT)){
            drawer.closeDrawer(Gravity.RIGHT);
        }else {
            finish();
        }

    }



}
