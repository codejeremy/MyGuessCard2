package com.mingrisoft.myguesscard;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

public class sat extends Activity {

    private Button button_end;
    private Button button_cont;
    private TextView grade1;
    private TextView grade2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sat);
        SharedPreferences pref = getSharedPreferences("data",MODE_WORLD_READABLE);

        button_end = findViewById(R.id.end);
        button_cont=findViewById(R.id.cont);
        grade1=findViewById(R.id.grade1);
        grade2=findViewById(R.id.grade2);


        grade1.setText(String.valueOf(MainActivity.q));
        grade2.setText(String.valueOf(MainActivity.c));

        button_cont.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.q = 0;
                MainActivity.c = 0;
                Intent i =new Intent(sat.this,MainActivity.class);
                startActivity(i);
            }
        });
        button_end.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                MainActivity.q = 0;
                MainActivity.c = 0;
                finish();
            }
        });


    }
}
