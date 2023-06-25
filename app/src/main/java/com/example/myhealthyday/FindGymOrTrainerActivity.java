package com.example.myhealthyday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindGymOrTrainerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_gym_or_trainer);

        CardView exit = findViewById(R.id.cardOfBack);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FindGymOrTrainerActivity.this, HomeActivity.class));
            }
        });

        CardView cardGYMTrainer = findViewById(R.id.cardFindGym);
        cardGYMTrainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindGymOrTrainerActivity.this, FiindGymDetailsActivity .class);
                it.putExtra("title", "Gym with personal trainer");
                startActivity(it);
            }
        });

        CardView cardFitness = findViewById(R.id.FitnessGym);
        cardFitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindGymOrTrainerActivity.this, FiindGymDetailsActivity .class);
                it.putExtra("title", "Fitness gym");
                startActivity(it);
            }
        });
        CardView cardPilates = findViewById(R.id.pilatesGym);
        cardPilates.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindGymOrTrainerActivity.this, FiindGymDetailsActivity .class);
                it.putExtra("title", "Aerobic fitness gym");
                startActivity(it);
            }
        });
        CardView cardZumba = findViewById(R.id.zumba);
        cardZumba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindGymOrTrainerActivity.this, FiindGymDetailsActivity .class);
                it.putExtra("title", "Zumba");
                startActivity(it);
            }
        });
        CardView cardHipHop = findViewById(R.id.hiphopwithfitness);
        cardHipHop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(FindGymOrTrainerActivity.this, FiindGymDetailsActivity .class);
                it.putExtra("title", "Hip-hop with fitness");
                startActivity(it);
            }
        });

    }
}