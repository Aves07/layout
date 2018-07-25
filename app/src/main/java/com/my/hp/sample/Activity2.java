package com.my.hp.sample;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Activity2 extends AppCompatActivity {

    private Spinner sp2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_2 );
        sp2=(Spinner) findViewById(R.id.spinner2);
        ArrayAdapter adp3=ArrayAdapter.createFromResource(this,R.array.data2,android.R.layout.simple_spinner_item);
        sp2.setAdapter(adp3);
    }
}
