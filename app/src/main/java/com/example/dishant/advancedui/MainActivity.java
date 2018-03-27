package com.example.dishant.advancedui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private ListView myList;  // ListView Object
    private String[] months = {"Jan","Feb","March","April","May","June","July","August","September"
            ,"October","November","December"};   //String Array object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: Started.");

        myList = findViewById(R.id.listid);
        /*
          ArrayAdapter is set with android list layout
         */
        myList.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1, months));

        Button Ascending = findViewById(R.id.button1);
        Button Descending = findViewById(R.id.button2);

        /*
          Call methods for Ascending & Descending Buttons declared.
         */

        Ascending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Ascending Btn clicked.");
                sortA();
            }
        });

        Descending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: Descending btn clicked.");
                sortD();
            }
        });

    }

    private void sortA(){
        Log.d(TAG, "sortA: Sorting Ascending method Started.");

        /*
          Collections class is used for Sorting, Sort method is used from Collections class for performing Ascending operation.
         */

        List<String> monthsList = Arrays.asList(months);
        /*
         String object "months" is converted into an ArrayList and passed in sort method.
          */
        Collections.sort(monthsList);
        myList.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1, months)); // ArrayAdapter is set to "months".

    }

    private void sortD(){
        Log.d(TAG, "sortD: Reverse method Started.");

        /*
          Reverse method from Collections class is used for Descending operation.
         */

        List<String> monthsList = Arrays.asList(months);
        /*
         String object "months" is converted into an ArrayList and passed in sort method.
          */
        Collections.sort(monthsList, Collections.<String>reverseOrder());
        myList.setAdapter(new ArrayAdapter<>(this,android.R.layout.simple_expandable_list_item_1, months)); // ArrayAdapter is set to "months".
    }

}
