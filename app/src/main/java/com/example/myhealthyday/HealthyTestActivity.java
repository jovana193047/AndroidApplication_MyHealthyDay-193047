package com.example.myhealthyday;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class HealthyTestActivity extends AppCompatActivity {

    private String [][] packages =
            {
                    {"Package 1: Full Body Checkup", "","","","999"},
                    {"Package 2: Calories in blood ", "","","","599"},
                    {"Package 3: Blood Clucose Checkup", "","","","499"},
                    {"Package 4: Immunity Checkup", "","","","799"}
            };
    private String [] package_details = {
            "Blood Clucose Checkup\n" +
                    "Complete Hemogram\n" +
                    "Liver Function Test\n" +
                    "Kidney Function Test",
            "Blood Clucose Checkup",
            "Immunity Checkup",
            "Vitamin C\n" +
                    "Iron Studies\n" +
                    "Calories in blood\n" +
                    "Full Body Checkup"
    };
    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart, btnBack;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy_test);

        btnGoToCart = findViewById(R.id.buttonCheckoutCart);
        btnBack = findViewById(R.id.btnToBackCart);
        listView = findViewById(R.id.listViewHTCheckout);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthyTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<String, String>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost:"+packages[i][4]+"/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent it = new Intent(HealthyTestActivity.this, HealthyTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][4]);
                startActivity(it);
            }
        });

        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HealthyTestActivity.this, CartHealthyActivity.class));
            }
        });
    }
}