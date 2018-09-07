package com.example.laurenthai.prog01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioGroup;
import android.widget.RadioButton;


public class MainActivity extends AppCompatActivity {

    /* order: walking, boosted, evolve, hover, segway */
    double[] MPH = {3.1, 18, 26, 8, 12.5};
    int[] RANGE = {30, 7, 31, 8, 24};

    EditText input;
    TextView output;
    TextView walkResult, boostResult, evResult, hovResult, segResult;

    Button calcBtn;
    RadioGroup rGroup;
    RadioButton radioButton;
    double inputDist, outputTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = (EditText) findViewById(R.id.txtDist);
        output = (TextView) findViewById(R.id.result);
        walkResult = (TextView) findViewById(R.id.walkingOut);
        boostResult = (TextView) findViewById(R.id.boostedOut);
        evResult = (TextView) findViewById(R.id.evolveOut);
        hovResult = (TextView) findViewById(R.id.hoverOut);
        segResult = (TextView) findViewById(R.id.segwayOut);
        calcBtn = (Button) findViewById(R.id.calcBtn);

        rGroup = (RadioGroup) findViewById(R.id.vehicleGroup);


        /* user hits calculate button */
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /* get id of selected radio button */
                /* 0) walking 1) boosted 2) evolve 3) hover 4) segway */
                int rbID = rGroup.getCheckedRadioButtonId();
                View radioButton = rGroup.findViewById(rbID);
                int ind  = rGroup.indexOfChild(radioButton);
                /* id = id % 10; */

                inputDist = Double.parseDouble(input.getText().toString());
                outputTime = inputDist / MPH[ind];

                if ((ind==0 & inputDist>30) || (ind==1 & inputDist>7) || (ind==2 & inputDist>31) || (ind==3 & inputDist>8) || (ind==4 & inputDist>24)) {
                    output.setText("Distance out of range for selected vehicle");
                }
                else {


                    output.setText("This trip will take " + String.format("%.2f", outputTime) + " hours");


                    /* get the rest of the travel times */
                    walkResult.setText("Walking will take " + String.format("%.2f", inputDist / MPH[0]) + " hours");
                    boostResult.setText("Boosted Board will take " + String.format("%.2f", inputDist / MPH[1]) + " hours");
                    evResult.setText("Evolve Skateboard will take " + String.format("%.2f", inputDist / MPH[2]) + " hours");
                    hovResult.setText("Hoverboard will take " + String.format("%.2f", inputDist / MPH[3]) + " hours");
                    segResult.setText("Segway will take " + String.format("%.2f", inputDist / MPH[4]) + " hours");
                }
            }
        });

        /* deletes hint text when input is selected */
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText inp = (EditText) findViewById(R.id.txtDist);
                inp.setText("");
            }
        });


        }

    }


