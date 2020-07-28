package com.example.transaction24;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        BottomNavigationView bottomnav=findViewById(R.id.bottom_nav);
        bottomnav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
        new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedfragment=new HomeFragment();

                switch (item.getItemId()){
                    case R.id.nav_home:
                        selectedfragment=new HomeFragment();
                        break;
                    case R.id.nav_history:
                        selectedfragment=new HistoryFragment();
                        break;
                    case R.id.nav_profile:
                        selectedfragment=new ProfileFragment();
                        break;


                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frag_container,selectedfragment).commit();
                return true;
            }
        };

}
