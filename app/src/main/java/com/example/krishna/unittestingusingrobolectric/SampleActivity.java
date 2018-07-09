package com.example.krishna.unittestingusingrobolectric;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SampleActivity extends AppCompatActivity {
    public Button mClickMeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
//        mHelloWorldTextView = (TextView) findViewById(R.id.helloWorldTextView);
        mClickMeButton = (Button) findViewById(R.id.nextButton);
        mClickMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SampleActivity.this, "Krishna", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(SampleActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
