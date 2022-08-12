package com.example.joryappcw5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private final int GALLERY_REQ_CODE= 1000;
    ImageView imgGallery;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       imgGallery = findViewById(R.id.imgGallery);
        Button btnGallery = findViewById(R.id.btnCamera);
        TextView t1 = findViewById(R.id.textView);
        EditText name = findViewById(R.id.ed1);
        EditText age = findViewById(R.id.ed2);
        Button next =findViewById(R.id.button);

        name.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    next.setEnabled(false);
                } else {
                    next.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });






        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Name =name.getText().toString();
                int Age = Integer.parseInt(age.getText().toString());

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("name", Name);
                intent.putExtra("age", Age);

                startActivity(intent);
            }
        });







        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                 Intent iGallery = new Intent(Intent.ACTION_PICK);
                 iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                 startActivityForResult(iGallery, GALLERY_REQ_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
            if(requestCode==GALLERY_REQ_CODE){
                // for gallery

                imgGallery.setImageURI(data.getData());

            }
        }


    }
}


