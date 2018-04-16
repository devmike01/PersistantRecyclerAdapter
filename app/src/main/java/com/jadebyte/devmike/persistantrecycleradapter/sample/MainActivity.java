package com.jadebyte.devmike.persistantrecycleradapter.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jadebyte.devmike.persistantrecycleradapter.R;

/**
 * Created by DevMike on 4/13/2018.
 */

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedState){
        super.onCreate(savedState);
        setContentView(R.layout.activity_main);
        if (savedState == null){

            getSupportFragmentManager().beginTransaction().replace(R.id.layout, new FragmentSample()).commit();
        }
    }
}
