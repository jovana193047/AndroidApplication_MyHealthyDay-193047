package com.example.myhealthyday;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class HealthyTestBookActivity extends AppCompatActivity {

    EditText edname, ednaddress, edcontact, edpincode;
    Button btnBooking, btnBackBooking;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_test_book);

        edname = findViewById(R.id.editTextPersonNameBook);
        ednaddress = findViewById(R.id.addressBooking);
        edcontact = findViewById(R.id.textContactNumber);
        edpincode = findViewById(R.id.textPinCode);
        btnBooking = findViewById(R.id.buttonBooking);
        btnBackBooking = findViewById(R.id.buttonBookingBack);

        Intent intent = getIntent();
        String[] price = intent.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = intent.getStringExtra("date");
        String time = intent.getStringExtra("time");

        btnBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthyTestBookActivity.this, HealthyTestDetailsActivity.class));
            }
        });

        btnBackBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthyTestBookActivity.this, FindGymOrTrainerActivity.class));
            }
        });
    }

}