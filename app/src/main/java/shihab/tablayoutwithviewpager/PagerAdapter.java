package shihab.tablayoutwithviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Shihab on
 */
public class PagerAdapter  extends FragmentStatePagerAdapter{
    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        Fragment frag=null;
        switch (position){
            case 0:
                frag=new MyFishFragment();
                break;
            case 1:
                frag=new FishMarketFragment();
                break;
           /* case 2:
                frag=new WeatherFragment();
                break;*/
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title=" ";
        switch (position){
            case 0:
                title="My Fish";
                break;
            case 1:
                title="Fish Market";
                break;
            /*case 2:
                title="Study";
                break;*/
        }

        return title;
    }
}
