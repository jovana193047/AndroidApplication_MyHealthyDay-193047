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
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class FiindGymDetailsActivity extends AppCompatActivity {

    private String[][] gym_details1 =
            {
                    {"Gym Name : MaxFit", "Address : Oktomvriska", "StartedYears : 3years", "MobileNo : 002852456","MonthPrice : 1200"},
                    {"Gym Name : MyGym", "Address : Kapistec", "StartedYears : 5years", "MobileNo : 002834986","MonthPrice : 1400"},
                    {"Gym Name : California", "Address : Partizanska", "StartedYears : 2years", "MobileNo : 00296524326","MonthPrice : 1000"}
            };

    private String[][] gym_details2 =
            {
                    {"Gym Name : ImperiaFitness", "Address : Oktomvriska", "StartedYears : 1year", "MobileNo : 032456456","MonthPrice : 1000"},
                    {"Gym Name : LifeFitness", "Address : Ilidenska", "StartedYears : 5years", "MobileNo : 0031456789","MonthPrice : 900"},
                    {"Gym Name : FitnessBodyCenter", "Address : Partizanska", "StartedYears : 3years", "MobileNo : 002765342","MonthPrice : 1600"}

            };

    private String[][] gym_details3 =
            {
                    {"Gym Name : ChillGym,", "Address : Oktomvriska", "StartedYears : 1years", "MobileNo : 031245678","MonthPrice : 1200"},
                    {"Gym Name : SpectraFitnessCentar", "Address : Partizanska", "StartedYears : 2years", "MobileNo : 002456321","MonthPrice : 1800"},
                    {"Gym Name : Atleta", "Address : Aerodrom", "StartedYears : 5years", "MobileNo : 00289724326","MonthPrice : 1500"}

            };

    private String[][] gym_details4 =
            {
                    {"Gym Name : ProjectFit", "Address : Kapistec", "StartedYears : 3years", "MobileNo : 002456890","MonthPrice : 2400"},
                    {"Gym Name : FitnessStanica", "Address : Ilidenska", "StartedYears : 2years", "MobileNo : 002345678","MonthPrice : 2600"},
                    {"Gym Name : ExtremeFitness", "Address : MUB", "StartedYears : 6years", "MobileNo : 0031456789","MonthPrice : 1400"}

            };
    private String[][] gym_details5 =
            {
                    {"Gym Name : FitnessBodyZumba", "Address : Oktomvriska", "StartedYears : 3year", "MobileNo : 031245678","MonthPrice : 1200"},
                    {"Gym Name : DanceFitnessDesire", "Address : Kapistec", "StartedYears : 5years", "MobileNo : 0023456789","MonthPrice : 2000"},
                    {"Gym Name : MaxDanceFit", "Address : Partizanska", "StartedYears : 2year", "MobileNo : 0031245678","MonthPrice : 1600"}
            };



    TextView textView;
    Button btn;

    String [][] gym_details = {};
     HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiind_gym_details2);

        textView = findViewById(R.id.textTitleAppName);
        btn = findViewById(R.id.btnToBackCart);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        textView.setText(title);

        if(title.compareTo("Gym with personal trainer")==0)
            gym_details = gym_details1;
        else
        if(title.compareTo("Fitness gym")==0)
            gym_details = gym_details2;
        else
        if(title.compareTo("Aerobic fitness gym")==0)
            gym_details = gym_details3;
        else
        if(title.compareTo("Zumba")==0)
            gym_details = gym_details4;
        else
            gym_details = gym_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FiindGymDetailsActivity.this, FindGymOrTrainerActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0; i<gym_details.length; i++){
            item = new HashMap<String, String>();
            item.put("line1", gym_details[i][0]);
            item.put("line2", gym_details[i][1]);
            item.put("line3", gym_details[i][2]);
            item.put("line4", gym_details[i][3]);
            item.put("line5", "Cons Fees:"+gym_details[i][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this,list,
                R.layout.multi_lines,
                new String[]{"line1","line2", "line3","line4","line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
             );

        ListView lst = findViewById(R.id.listViewHTCheckout);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent it = new Intent(FiindGymDetailsActivity.this, BookAppointmentActivity.class);
                it.putExtra("text1",title);
                it.putExtra("text2",gym_details[i][0]);
                it.putExtra("text3",gym_details[i][1]);
                it.putExtra("text4",gym_details[i][3]);
                it.putExtra("text5",gym_details[i][4]);
                startActivity(it);

            }
        });



    }
}