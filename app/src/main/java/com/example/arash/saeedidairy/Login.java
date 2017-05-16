package com.example.arash.saeedidairy;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Login extends AppCompatActivity {


    ImageView loginlogo;
    CardView cardlogin;
    EditText usernamelogin , passwordlogin;
    Button loginbtn , registerbtn , exitbtn;
    SharedPreferences sharedPreferences;
    public static String shared_key="login";
    SharedPreferences.Editor editor;
    AppCompatCheckBox remembercheckbox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        loginlogo = (ImageView)findViewById(R.id.loginlogo);
        cardlogin = (CardView)findViewById(R.id.cardlogin);
        loginbtn=(Button)findViewById(R.id.loginbtn);
        registerbtn=(Button)findViewById(R.id.registerbtn);
        exitbtn=(Button)findViewById(R.id.exitbtn);
        usernamelogin=(EditText)findViewById(R.id.usernamelogin);
        passwordlogin=(EditText)findViewById(R.id.passwordlogin);
        remembercheckbox=(AppCompatCheckBox)findViewById(R.id.remembercheckbox);
        sharedPreferences=getSharedPreferences(shared_key,MODE_PRIVATE);
        editor=sharedPreferences.edit();
        usernamelogin.setText(sharedPreferences.getString("usernamesh",null));
        passwordlogin.setText(sharedPreferences.getString("passwordsh",null));

//        loginbtn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                String user=usernamelogin.getText().toString();
//                String pass=passwordlogin.getText().toString();
//
//                if (user.equals("admin")&&pass.equals("12345")){
//
//                    if (remembercheckbox.isChecked()){
//                        editor.putString("username",user);
//                        editor.putString("password",pass);
//                        editor.commit();
//                    }
//
//                    Intent intent = new Intent(Login.this,MainActivity.class);
//                    startActivity(intent);
//                    finish();
//                }else {
//                    Toast.makeText(Login.this,"اطلاعات ورودی اشتباه است",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });



        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int i=0;
                String user=String.valueOf(usernamelogin.getText());
                String pass=String.valueOf(passwordlogin.getText());
                try {
                    Cursor cursor = new DataBaseHandler(Login.this).getReadableDatabase().rawQuery("SELECT * FROM users",null);
                    while (cursor.moveToNext()){
                        if (cursor.getString(cursor.getColumnIndex("username")).equals(user)&&cursor.getString(cursor.getColumnIndex("password")).equals(pass)){
                            if (remembercheckbox.isChecked()){
                        editor.putString("usernamesh",user);
                        editor.putString("passwordsh",pass);
                        editor.commit();
                   }
                            i=1;
                        }

                    }
                    if (i==1){
                        Intent intent = new Intent(Login.this,MainActivity.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this , "اطلاعات ورود اشتباه است" , Toast.LENGTH_SHORT).show();
                    }


                    cursor.close();
                }catch (Exception e){
                    System.out.println("Can Not Read Table !!");
                }


            }
        });


        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_inandmove);
        loginlogo.startAnimation(animation);
        cardlogin.startAnimation(animation);

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this , Register.class);
                startActivity(intent);
            }
        });
        exitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
