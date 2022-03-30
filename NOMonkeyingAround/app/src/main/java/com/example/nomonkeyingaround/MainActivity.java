package com.example.nomonkeyingaround;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // create method
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        // get elements
        TabLayout tabLayout = findViewById(R.id.tabs);
        ViewPager2 viewpager2 = findViewById(R.id.view_pager);

        viewPagerAdapter adapter = new viewPagerAdapter(this);
        viewpager2.setAdapter(adapter);

        int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.black);
        //enables swiping across tabs and the tabs to sync with respective page fragment
        new TabLayoutMediator(tabLayout, viewpager2,
                new TabLayoutMediator.TabConfigurationStrategy() {
                    @Override
                    public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                        if (position==0){
                            tab.setIcon(R.drawable.settings);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                        else if (position==1){
                            tab.setIcon(R.drawable.leaderboard);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                        else if (position==2){
                            tab.setIcon(R.drawable.grow_a_tree_custom);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                        else{
                            tab.setIcon(R.drawable.to_do_custom);
                            tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                        }
                    }
                }).attach();

    }
}