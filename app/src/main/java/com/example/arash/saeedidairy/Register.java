package com.example.arash.saeedidairy;

import android.content.ContentValues;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Toolbar registertoolbar;
    ImageView registerlogo;
    CardView cardregister;
    EditText usernameregister , passwordregister , phoneregister;
    Button registerbtn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerbtn=(Button)findViewById(R.id.registerbtn);
        usernameregister=(EditText)findViewById(R.id.usernameregister);
        passwordregister=(EditText)findViewById(R.id.passwordregister);
        phoneregister=(EditText)findViewById(R.id.phoneregister);


        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = String.valueOf(usernameregister.getText());
                String pass = String.valueOf(passwordregister.getText());
                String phone = String.valueOf(phoneregister.getText());

                ContentValues values = new ContentValues();
                values.put("username",user);
                values.put("password",pass);
                values.put("phone",phone);
                try{
                    new DataBaseHandler(Register.this).getWritableDatabase().insert("users",null,values);
                    Toast.makeText(Register.this,"ثبت نام با موفقیت انجام شد",Toast.LENGTH_SHORT).show();

                }catch (Exception e){
                    System.out.println("Can Not Insert Data !!");
                }


            }
        });

        registertoolbar=(Toolbar)findViewById(R.id.registertoolbar);
        registerlogo= (ImageView) findViewById(R.id.registerlogo);
        cardregister = (CardView)findViewById(R.id.cardregister);

        setTitle("");
        setSupportActionBar(registertoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_inandmove);
        registerlogo.startAnimation(animation);
        cardregister.startAnimation(animation);


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
