package com.mamarman.depa.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mamarman.depa.R;
import com.mamarman.depa.fragment.InterLostFragment;

public class LostinternetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lostinternet);

        if (savedInstanceState == null){
        getSupportFragmentManager().beginTransaction()
                .add(R.id.containnerLost,new InterLostFragment())
                .commit();
        }
    }


}
