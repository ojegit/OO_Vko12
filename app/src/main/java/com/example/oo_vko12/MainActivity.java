package com.example.oo_vko12;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    /*
    What is included?
    -fragments instead of simple layouts that fill entire page
    -singleton pattern for the UserStorage
    -items showed with viewpager2
    -time formatting
    -sort list items based on two criteria: alphabetically or timestamp
    -display of the notes/list items:
        -make the note important
        -create items on a separate tab where they're displayed (needs fragment to fragment communication, but not transfer of data)
        (Toast is used to notify user if the item has been added)
        -RecycleView item specific real time manipulation: remove, edit and make important (shown at the bottom of the screen)

     TBA:
     -save and load data (serialization)
     -themes (e.g Materialize)
     -change text size
     -change item display style: list vs grid format (specify grid)
     -include images in addition to other data (see ex 10-11 how to apply this feature)
     -export/import data
     -
     */

    TabLayout tabLayout;
    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize TabLayout and ViewPager2
        tabLayout = findViewById(R.id.tabLayout);
        viewPager2 = findViewById(R.id.viewPager2);


        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(this);

        /*
        set tab id's so that they can be referred globally!
         */
        viewPager2.setAdapter(tabPagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });

        //https://stackoverflow.com/questions/16918854/find-fragment-by-tag-name-in-container
        //https://stackoverflow.com/questions/14035090/how-to-get-existing-fragments-when-using-fragmentpageradapter
        //https://stackoverflow.com/questions/33237235/remove-all-fragments-from-container
        /*
        int i = 0;
        for(Fragment f : getSupportFragmentManager().getFragments()) {
            i++;
            System.out.println("WHO IS " +i+ ": "+ f);
        }
         */
    }

    public List<Fragment> getFragments() {
        return getSupportFragmentManager().getFragments();
    }


}