package com.example.mediaplayeractivity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
      @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          //TODO (2) : Use FragmentManager & FragmentTransaction to add MainFragment
       }

    @Override
    public void onBackPressed() {
        //TODO (9) : Use popBackStack to return to the previous fragment and if it is the first fragment call the parent class's constructor (super)

    }


}
