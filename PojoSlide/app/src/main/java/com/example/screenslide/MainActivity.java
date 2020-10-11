package com.example.screenslide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Profile profile = new Profile();
    private static final int NUM_PAGES = 2;
    private ViewPager mPager;
    private PagerAdapter pagerAdapter;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //TextView tv = findViewById(R.id.tt);   //just for checking ...pojo works
        //tv.setText(name);

    //    Tab1Fragment fragment1 = Tab1Fragment.newInstance(name, phone, email, password, confirm_pass);
    //    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment1).commit();

//        Tab2Fragment fragment2 = Tab2Fragment.newInstance("Goa","North Goa");
        //getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment2).commit();

        // Instantiate a ViewPager and a PagerAdapter.

        mPager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed();
        } else {
            // Otherwise, select the previous step.
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }


    private class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter {
        public ScreenSlidePagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if(position==0){
                String name = profile.getName();
                String phone= profile.getPhone();
                String email= profile.getEmail();
                String password= profile.getPassword();
                String confirm_pass=profile.getConfirm_pass();
                return Tab1Fragment.newInstance(name,phone,email,password,confirm_pass);
            }
            else{
                String gender = profile.getGender();
                String state = profile.getState();
                String district = profile.getDistrict();
                String dob = profile.getDob();
                return Tab2Fragment.newInstance(gender,state,district,dob);
            }

        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            if (position==0)
                return "Part1";
            else
                return "Part2";
        }
    }
}
