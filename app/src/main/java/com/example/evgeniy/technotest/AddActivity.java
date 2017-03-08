package com.example.evgeniy.technotest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Evgeniy on 08.03.2017.
 */

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        final Button button = (Button) findViewById(R.id.edit_button);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras != null) {
                ((TextView) findViewById(R.id.data)).setText(extras.getString("date"));
                ((TextView) findViewById(R.id.first_name)).setText(extras.getString("name"));
                ((TextView) findViewById(R.id.second_name)).setText(extras.getString("sName"));
            }
        } else {
            ((TextView) findViewById(R.id.data)).setText((String) savedInstanceState.getSerializable("date"));
            ((TextView) findViewById(R.id.first_name)).setText((String) savedInstanceState.getSerializable("name"));
            ((TextView) findViewById(R.id.second_name)).setText((String) savedInstanceState.getSerializable("sName"));
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
