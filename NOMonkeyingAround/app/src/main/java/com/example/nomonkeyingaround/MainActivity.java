package com.example.nomonkeyingaround;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewpager2;
    ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // create method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // get elements
        tabLayout = findViewById(R.id.tabs);
        viewpager2 = findViewById(R.id.view_pager);

        adapter = new ViewPagerAdapter(this);
        viewpager2.setAdapter(adapter);
        viewpager2.setCurrentItem(2);

        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.black);

        //enables swiping across tabs and the tabs to sync with respective page fragment
        new TabLayoutMediator(tabLayout, viewpager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position==0){
                            tab.setIcon(R.drawable.settings_custom);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                        else if (position==1){
                            tab.setIcon(R.drawable.leaderboard_custom);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                        else if (position==2){
                            tab.setIcon(R.drawable.grow_a_tree_custom);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                        else if (position==3){
                            tab.setIcon(R.drawable.to_do_custom);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                        else{
                            tab.setIcon(R.drawable.tree_collection_custom);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                    }
                }).attach();

    }
}