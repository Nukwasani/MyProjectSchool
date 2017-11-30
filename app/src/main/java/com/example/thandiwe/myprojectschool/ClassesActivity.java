package com.example.thandiwe.myprojectschool;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ClassesActivity extends AppCompatActivity {

    private DatabaseReference databaseReference;

    private FirebaseRecyclerAdapter<Learner, LearnerViewHolder> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);


        databaseReference = FirebaseDatabase.getInstance().getReference().child("Learner");


        adapter = new FirebaseRecyclerAdapter<Learner, LearnerViewHolder>(Learner.class, R.layout.custom_view, LearnerViewHolder.class, databaseReference) {
            @Override
            protected void populateViewHolder(LearnerViewHolder viewHolder, Learner model, final int position) {

                viewHolder.setSurname(model.getName());
                viewHolder.setName(model.getSurname());
                viewHolder.setAddress(model.getAddress());
                viewHolder.setId(model.getId());


                viewHolder.setCard().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        AlertDialog.Builder builder = new  AlertDialog.Builder(ClassesActivity.this);

                        builder.setTitle("Options");
                        builder.setMessage("Do you want to delete?");

                        builder.setNegativeButton("Update", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String key = getRef(position).getKey();

                                Intent i = new Intent(ClassesActivity.this, UpdateInforActivity.class);
                                i.putExtra("name", key);
                                startActivity(i);


                            }
                        });

                        builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                getRef(position).removeValue();
                            }
                        });

                        builder.show();
                    }
                });


            }
        };

        RecyclerView recyclerView;
        recyclerView= (RecyclerView) findViewById(R.id.recycler);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }




    private static class LearnerViewHolder extends RecyclerView.ViewHolder {
        View view;

        public LearnerViewHolder(View itemView) {
            super(itemView);

            view = itemView;

        }
        public void setName(String name) {

            TextView tvName = (TextView)view.findViewById(R.id.tvName);
            tvName.setText(name);
        }

        public void setSurname(String surname) {

            TextView tvSurname = (TextView)view.findViewById(R.id.tvSurname);
            tvSurname.setText(surname);
        }

        public void setAddress(String address) {

            TextView tvAddress = (TextView)view.findViewById(R.id.tvAddress);
            tvAddress.setText(address);
        }

        public void setId(int id) {

            TextView tvId = (TextView)view.findViewById(R.id.tvId);
            tvId.setText(id);
        }


        public CardView setCard() {

            CardView card = (CardView) view.findViewById(R.id.cardView);


            return card;

        }
    }
}
