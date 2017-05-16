package com.example.arash.saeedidairy.menupages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.arash.saeedidairy.R;

public class ContactUs extends AppCompatActivity {

    Toolbar contacttoolbar;
    EditText email , subject , message;
    Button sendbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        email=(EditText)findViewById(R.id.email);
        subject=(EditText)findViewById(R.id.subject);
        message=(EditText)findViewById(R.id.message);
        sendbtn=(Button)findViewById(R.id.sendbtn);
        contacttoolbar=(Toolbar)findViewById(R.id.contacttoolbar);
        setTitle("");
        setSupportActionBar(contacttoolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        sendbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email =email.getText().toString() ;
                String Subject =subject.getText().toString() ;
                String Message =message.getText().toString() ;

                String[] Emailaddress={Email};
                Intent sendmail = new Intent(Intent.ACTION_SEND);
                sendmail.putExtra(Intent.EXTRA_EMAIL,Emailaddress);
                sendmail.putExtra(Intent.EXTRA_SUBJECT,Subject);
                sendmail.setType("plain/text");
                sendmail.putExtra(Intent.EXTRA_TEXT,Message);

                startActivity(sendmail);

            }
        });
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
