package codekamp.in.pagerviewnews;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.print.PrintHelper;

import java.util.List;

/**
 * Created by hp1 on 12-07-2016.
 */
public class MyPagerAdapter extends FragmentStatePagerAdapter {
    private FragmentManager fm;
    private List<Datum> responseList;

    public MyPagerAdapter(FragmentManager fm, List<Datum> response) {
        super(fm);
        this.fm = fm;
        this.responseList =response;
    }


    // Returns total number of pages
    @Override
    public Fragment getItem(int position) {
        NewsFragment fragment;
        if(position==responseList.size()){
           fragment = NewsFragment.newInstance(null);
        }else {
            fragment = NewsFragment.newInstance(responseList.get(position));
        }
        return fragment;
    }

    // Returns the fragment to display for that page
    @Override
    public int getCount() {
        return ((responseList.size())+1);
    }
}
