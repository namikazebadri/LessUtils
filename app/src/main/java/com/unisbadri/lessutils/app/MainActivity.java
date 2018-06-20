package com.unisbadri.lessutils.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.unisbadri.lessutils.commons.Store;
import com.unisbadri.lessutils.resource.StringUtils;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.i("LALA", StringUtils.fromResource(R.string.lessPlaceHolderText));

        Store.Calendar.get("");
    }
}
