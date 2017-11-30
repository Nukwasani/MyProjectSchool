package com.example.thandiwe.myprojectschool;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomePageActivity extends AppCompatActivity {

    private Button register, classes, report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        register =(Button)findViewById(R.id.btn_register);
        classes =(Button)findViewById(R.id.btn_classes);
        report =(Button)findViewById(R.id.btn_report);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent i = new Intent(HomePageActivity.this, RegisterActivity.class);
                 startActivity(i);
            }
        });


        classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(HomePageActivity.this, ClassesActivity.class);
                startActivity(i);
            }
        });


    }
}
