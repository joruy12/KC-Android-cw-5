package com.example.joryappcw5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView t2 = findViewById(R.id.textView2);
        TextView t3 = findViewById(R.id.textView3);
        TextView t4 = findViewById(R.id.textView4);
        ImageView image = findViewById(R.id.imageView);
        TextView customerNameT1 = findViewById(R.id.customerName);
        TextView ageT2 = findViewById(R.id.age);

        Bundle bundle = getIntent().getExtras();



        // name
        String name = bundle.getString("name");
        customerNameT1.setText(name);

        // age
        int age = bundle.getInt("age");
        ageT2.setText(String.valueOf(age));
    }
}