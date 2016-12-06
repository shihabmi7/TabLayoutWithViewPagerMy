package shihab.tablayoutwithviewpager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class TabLayoutWithViewPagerActivity extends AppCompatActivity {

    ViewPager viewPager;
    public static TabLayout tabLayout;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayout_viewpager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       /* fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Click action
                Intent intent = new Intent(TabLayoutWithViewPagerActivity.this, FishItemAddActivity.class);
                startActivity(intent);
            }
        });*/

        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);

        FragmentManager manager = getSupportFragmentManager();

        PagerAdapter adapter = new PagerAdapter(manager);
        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        // mTabLayout.setupWithViewPager(mPager1);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.setTabsFromPagerAdapter(adapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                viewPager.setCurrentItem(tab.getPosition());
//                viewPager.setVisibility(View.VISIBLE);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

//                viewPager.setVisibility(View.GONE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

//                viewPager.setVisibility(View.GONE);
            }
        });

        // set tab
        setIConForTab();


        //tabLayout.setOnClickListener(tabClickListener);

    }

    private View.OnClickListener tabClickListener = new View.OnClickListener() {
        public void onClick(View v) {

            if (checkIsFragVisible()) {

                v.setVisibility(View.INVISIBLE);
            } else {

                v.setVisibility(View.VISIBLE);
            }
        }
    };

    public boolean checkIsFragVisible() {
        Fragment yourFragment = getSupportFragmentManager().findFragmentById(R.id.weather_fragment);
        return yourFragment != null && yourFragment.isVisible();
    }

    private void setIConForTab() {
        //after initialization TabLayout and ViewPager

        for (int i = 0; i <= 6; i++) {

            TabLayout.Tab tabCall = tabLayout.getTabAt(i);
            tabCall.setIcon(R.drawable.selection);

        }

    }

    public class PagerAdapter extends FragmentStatePagerAdapter {

        int totalFragment = 7;
        private String tabTitles[] = new String[]{"Sat", "Sun", "Mon", "Tues", "Wed", "Thu", "Fri"};

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Fragment frag = null;

          /*  switch (position) {
                case 0:
                    frag = new WeatherFragment();
                    break;
                case 1:
                    frag = new WeatherFragment();
                    break;
                case 2:
                    frag = new WeatherFragment();
                    break;
                case 3:
                    frag = new WeatherFragment();
                    break;
                case 4:
                    frag = new WeatherFragment();
                    break;
                case 5:

                    break;
                case 6:
                    frag = new WeatherFragment();
                    break;
            }*/

            Bundle bundle = new Bundle();
            bundle.putInt("position", position);
            frag = new WeatherFragment();
            frag.setArguments(bundle);
            return frag;
        }

        @Override
        public int getCount() {
            return tabTitles.length;
        }

        @Override
        public CharSequence getPageTitle(int position) {

            return tabTitles[position];
        }
    }
}
