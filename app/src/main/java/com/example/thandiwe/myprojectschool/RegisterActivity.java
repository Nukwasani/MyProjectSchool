package com.example.thandiwe.myprojectschool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class RegisterActivity extends AppCompatActivity {

    private EditText lname, lsurname, laddress, lidNo;
    private Button btnRegister;
    private Spinner gender, race, H_language, I_language, date;


    private Learner learner;
    private DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        learner = new Learner();

        lname = (EditText)findViewById(R.id.editText7);
        lsurname = (EditText)findViewById(R.id.editText8);
        laddress = (EditText)findViewById(R.id.editText9);
        lidNo = (EditText)findViewById(R.id.editText10);


        gender = (Spinner)findViewById(R.id.spinnerGender);
        race = (Spinner)findViewById(R.id.spinnerRace);
        H_language = (Spinner)findViewById(R.id.spinnerH_Language);
        I_language = (Spinner)findViewById(R.id.spinnerI_Language);
        date = (Spinner)findViewById(R.id.spinnerDate);

        btnRegister = (Button)findViewById(R.id.save);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                databaseReference = FirebaseDatabase.getInstance().getReference();

                learner.setName(lname.getText().toString());
                learner.setSurname(lsurname.getText().toString());
             //  learner.setId(Integer.parseInt(lidNo.getText().toString()));
                learner.setAddress(laddress.getText().toString());

                databaseReference.child("Learner").push().setValue(learner);

            }
        });


    }
}
