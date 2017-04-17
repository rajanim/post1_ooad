package com.example.spenc.search;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //Add Home Layer
        Fragment homeView= new HomeFrame();

        FragmentManager fraMng= getFragmentManager();
        FragmentTransaction fraT= fraMng.beginTransaction()
                .replace(R.id.frame_layout_id,homeView);
        fraT.commit();


    }

    @Override
    public void onBackPressed() {
        int count = getFragmentManager().getBackStackEntryCount();

        if(count==0)
            super.onBackPressed();
        else
            getFragmentManager().popBackStack();

    }
}
